package net.shadowfacts.shadowjs.js;

import net.shadowfacts.shadowjs.ShadowJS;

import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author shadowfacts
 */
public class ShadowJSInterface {

	public static void eval(String fileName) throws ScriptException {
		File f = new File(ShadowJS.getInstance().getScriptsDir().getAbsolutePath() + "/" + fileName);
		try {
			ShadowJS.getInstance().getScriptEngine().eval(new FileReader(f));
		} catch (FileNotFoundException e) {
			ShadowJS.log.error("The specified script file (%s) did not exist!", fileName);
			e.printStackTrace();
		}
	}

}
