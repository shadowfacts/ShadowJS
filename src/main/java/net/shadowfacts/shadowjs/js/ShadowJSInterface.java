package net.shadowfacts.shadowjs.js;

import net.shadowfacts.shadowjs.ShadowJS;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author shadowfacts
 */
public class ShadowJSInterface {

	private static ScriptEngine engine;

	public static void eval(String fileName) throws ScriptException {
		if (engine == null) engine = ShadowJS.getInstance().getScriptEngine();


		File f = new File(ShadowJS.getInstance().getScriptsDir().getAbsolutePath() + "/" + fileName);
		try {
			engine.eval(new FileReader(f));
		} catch (FileNotFoundException e) {
			ShadowJS.log.error("The specified script file (%s) did not exist!", fileName);
			e.printStackTrace();
		}
	}

}
