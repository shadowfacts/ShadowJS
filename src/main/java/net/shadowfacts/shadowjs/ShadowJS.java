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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author shadowfacts
 */
@Mod(modid =  ShadowJS.modId, name = ShadowJS.name, version = ShadowJS.version)
public class ShadowJS {

	public static final String modId = "ShadowJS";
	public static final String name = "ShadowJS";
	public static final String version = "0.1.0";

	public static final Logger log = LogManager.getLogger("ShadowJS");

	@Mod.Instance(modId)
	private static ShadowJS instance;

	private File scriptsDir;

	private ScriptEngine scriptEngine;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		scriptsDir = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/shadowfacts/scripts/");
		if (!scriptsDir.exists()) scriptsDir.mkdirs();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) throws ScriptException {
		scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");


		String includes = "";
		try {
			includes = Resources.toString(Resources.getResource("includes.js"), Charsets.UTF_8);
		} catch (IOException e) {
			ShadowJS.log.error("There was a problem loading the includes file.");
			e.printStackTrace();
		}

		log.info("Evaluating includes");
		scriptEngine.eval(includes);


		File main = new File(scriptsDir.getAbsolutePath() + "/main.js");
		if (main.exists()) {
			try {
				log.info("Evaluating main.js");
				scriptEngine.eval(new FileReader(main));
			} catch (FileNotFoundException e) {
				ShadowJS.log.error("There was a problem loading the main file");
			}
		} else {
			ShadowJS.log.warn("./config/shadowfacts/scripts/main.js did not exist!");
			ShadowJS.log.info("There's really no point using ShadowJS if you don't have a main script :V");
		}
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(CommandHand.instance);
	}

	public File getScriptsDir() {
		return scriptsDir;
	}

	public ScriptEngine getScriptEngine() {
		return scriptEngine;
	}

	public static ShadowJS getInstance() {
		return instance;
	}

}
