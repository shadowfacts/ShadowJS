package net.shadowfacts.shadowjs;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.shadowfacts.shadowjs.api.ShadowJSAPI;
import net.shadowfacts.shadowjs.util.NashornUtils;
import net.shadowfacts.shadowmc.util.LogHelper;

import javax.script.ScriptException;
import java.io.*;

/**
 * @author shadowfacts
 */
@Mod(modid = ShadowJS.modId, name = ShadowJS.name, version = ShadowJS.version, acceptedMinecraftVersions = "[1.8.8,1.8.9]", dependencies = "required-after:shadowmc;")
public class ShadowJS {

	public static final String modId = "ShadowJS";
	public static final String name = "ShadowJS";
	public static final String version = "1.0.0";

	public static LogHelper log = new LogHelper(modId);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {
		ShadowJSAPI.setInternalMethods(new SJSInternalMethods());

		SJSConfig.init(event.getModConfigurationDirectory());

		ShadowJSAPI.setScriptsDir(new File(event.getModConfigurationDirectory(), "/shadowfacts/scripts/"));
		ShadowJSAPI.setMainScript(new File(ShadowJSAPI.getScriptsDir(), "main.js"));

		if (!ShadowJSAPI.getMainScript().exists()) {
			log.info("main.js did not exist, creating it");
			ShadowJSAPI.getMainScript().createNewFile();
			PrintStream out = new PrintStream(ShadowJSAPI.getMainScript());
			out.print("// ShadowJS entry point");
			out.close();
		}

		log.info("Loading deafult includes");
		ShadowJSAPI.addInclude(Resources.toString(Resources.getResource("includes.js"), Charsets.UTF_8));
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) throws ScriptException, FileNotFoundException {
//		GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.diamond_block, "AB", "B ", 'A', net.minecraft.init.Items.diamond, 'B', Blocks.bookshelf));

		if (SJSConfig.enabled) {
			log.info("Creating script engine");
			NashornUtils.init();

			log.info("Evaluating includes");
			ShadowJSAPI.getScriptEngine().eval(ShadowJSAPI.getIncludes());

			log.info("Evaluating main.js");
			ShadowJSAPI.getScriptEngine().eval(new FileReader(ShadowJSAPI.getMainScript()));
		}
	}

}
