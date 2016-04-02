package net.shadowfacts.shadowjs.api;

import net.shadowfacts.shadowjs.api.internal.InternalMethods;

import javax.script.ScriptEngine;
import java.io.File;

/**
 * @author shadowfacts
 */
public class ShadowJSAPI {

	private static InternalMethods internalMethods;

	/**
	 * DON'T USE THIS
	 * @param internalMethods I SAID DON'T
	 */
	public static void setInternalMethods(InternalMethods internalMethods) {
		ShadowJSAPI.internalMethods = internalMethods;
	}

	/**
	 * Is ShadowJS running
	 * @return
	 */
	public static boolean isRunning() {
		return internalMethods.isRunning();
	}

	/**
	 * Add includes to be run before script execution
	 * @param include
	 */
	public static void addInclude(String include) {
		internalMethods.addInclude(include);
	}

	/**
	 * Get the current includes
	 * @return
	 */
	public static String getIncludes() {
		return internalMethods.getIncludes();
	}

	/**
	 * The directory containing all scripts
	 * @return
	 */
	public static File getScriptsDir() {
		return internalMethods.getScriptsDir();
	}

	/**
	 * For internal use only
	 * @param scriptsDir
	 */
	public static void setScriptsDir(File scriptsDir) {
		internalMethods.setScriptsDir(scriptsDir);
	}

	/**
	 * ShadowJS entry point
	 * @return
	 */
	public static File getMainScript() {
		return internalMethods.getMainScript();
	}

	/**
	 * For internal use only
	 * @param mainScript
	 */
	public static void setMainScript(File mainScript) {
		internalMethods.setMainScript(mainScript);
	}

	/**
	 * Get the Nashorn script engine
	 * @return
	 */
	public static ScriptEngine getScriptEngine() {
		return internalMethods.getScriptEngine();
	}

}
