package net.shadowfacts.shadowjs.js;

import net.shadowfacts.shadowjs.ShadowJS;
import net.shadowfacts.shadowjs.api.ShadowJSAPI;

import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author shadowfacts
 */
public class SJSInterface {

	public static void eval(String fileName) throws ScriptException {
		File f = new File(ShadowJSAPI.getScriptsDir(), fileName);
		ShadowJS.log.info("Evaluating " + fileName);
		try {
			ShadowJSAPI.getScriptEngine().eval(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static LogWrapper getLogger(String name) {
		return LogWrapper.of(name);
	}

	public static char asChar(String s) {
		return s.charAt(0);
	}

}
