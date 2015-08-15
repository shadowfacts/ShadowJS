package net.shadowfacts.shadowjs;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
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

	private static final Logger log = LogManager.getLogger("ShadowJS");

	private File scriptsDir;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		scriptsDir = new File(event.getModConfigurationDirectory().getAbsolutePath() + "/shadowfacts/scripts/");
		if (!scriptsDir.exists()) scriptsDir.mkdirs();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

//		engine.createBindings()

		String includes = "";
		try {
//			includes = Files.toString(new File("includes.js"), Charsets.UTF_8);
			includes = Resources.toString(Resources.getResource("includes.js"), Charsets.UTF_8);
		} catch (IOException e) {
			ShadowJS.log.error("There was a problem loading the includes file.");
			e.printStackTrace();
		}
		final String finalIncludes = includes;

		Arrays.stream(scriptsDir.listFiles()).filter(file -> file.getName().endsWith(".js")).forEach(file -> {
			try {

				String text = finalIncludes + Files.toString(file, Charsets.UTF_8);

				engine.eval(text);
//				engine.eval(new FileReader(file));
			} catch (IOException e) {
				ShadowJS.log.error("There was a problem loading the script");
			} catch (ScriptException e) {
				ShadowJS.log.error("There was a problem evaluating the script: " + file.getAbsolutePath());
				e.printStackTrace();
			}
		});

	}

}
