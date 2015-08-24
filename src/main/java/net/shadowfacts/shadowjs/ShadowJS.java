package net.shadowfacts.shadowjs;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import net.minecraftforge.common.MinecraftForge;
import net.shadowfacts.shadowjs.command.CommandHand;
import net.shadowfacts.shadowjs.js.event.JSEventRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.*;

/**
 * @author shadowfacts
 */
@Mod(modid =  ShadowJS.modId, name = ShadowJS.name, version = ShadowJS.version)
public class ShadowJS {

	public static final String modId = "ShadowJS";
	public static final String name = "ShadowJS";
	public static final String version = "0.1.0-RC2";

	public static final Logger log = LogManager.getLogger("ShadowJS");

	@Mod.Instance(modId)
	private static ShadowJS instance;

	private File scriptsDir;
	private File main;

	private ScriptEngine scriptEngine;

	private String includes = "";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {
		scriptsDir = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/shadowfacts/scripts/");
		if (!scriptsDir.exists()) scriptsDir.mkdirs();

		main = new File(scriptsDir.getAbsolutePath() + "/main.js");
		if (!main.exists()) {
			log.info("main.js did not exist, automatically creating it");
			main.createNewFile();
			PrintStream printStream = new PrintStream(new FileOutputStream(main));
			printStream.print("// ShadowJS entry point");
			printStream.close();
		}

		ShadowJS.log.info("Loading includes");
		try {
			includes = Resources.toString(Resources.getResource("includes.js"), Charsets.UTF_8);
		} catch (IOException e) {
			ShadowJS.log.error("There was a problem loading the includes file.");
			e.printStackTrace();
		}

		ShadowJS.log.info("Registering main event handler");
		MinecraftForge.EVENT_BUS.register(JSEventRegistry.getInstance());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) throws ScriptException {
		NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
		scriptEngine = factory.getScriptEngine(new SJSClassFilter());

		log.info("Evaluating includes");
		scriptEngine.eval(includes);

		try {
			log.info("Evaluating main.js");
			scriptEngine.eval(new FileReader(main));
		} catch (FileNotFoundException e) {
			ShadowJS.log.error("There was a problem loading the main file");
		}

	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(CommandHand.instance);
	}

	/**
	 * @return The scripts directory at .minecraft/config/shadowfacts/scripts/
	 */
	public File getScriptsDir() {
		return scriptsDir;
	}

	/**
	 * @return The Nashorn {@link javax.script.ScriptEngine} being used
	 */
	public ScriptEngine getScriptEngine() {
		return scriptEngine;
	}

	/**
	 * Adds the specified string to the includes. The includes are evaluated immediately before main.js
	 * @param str
	 */
	public void addInclude(String str) {
		includes += str;
	}

	/**
	 * @return The mod instance provided by {@link cpw.mods.fml.common.Mod.Instance}
	 */
	public static ShadowJS getInstance() {
		return instance;
	}

}
