package net.shadowfacts.shadowjs;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.shadowfacts.shadowjs.command.CommandHand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.Arrays;

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

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) throws ScriptException {
		scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
		if (scriptEngine != null) {

			log.info("Evaluating includes");
			scriptEngine.eval(includes);

			try {
				log.info("Evaluating main.js");
				scriptEngine.eval(new FileReader(main));
			} catch (FileNotFoundException e) {
				ShadowJS.log.error("There was a problem loading the main file");
			}

		} else {
			log.error("Nashorn did not exist, you must use Java 8.");
			log.error("You are currently using Java " + System.getProperty("java.version"));
			throw new RuntimeException("Missing Nashorn script engine!");
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
