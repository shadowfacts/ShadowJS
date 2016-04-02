package net.shadowfacts.shadowjs.api.internal;

import javax.script.ScriptEngine;
import java.io.File;

/**
 * @author shadowfacts
 */
public interface InternalMethods {

	boolean isRunning();

	void addInclude(String include);

	String getIncludes();

	File getScriptsDir();

	void setScriptsDir(File scriptsDir);

	File getMainScript();

	void setMainScript(File mainScript);

	ScriptEngine getScriptEngine();
}
