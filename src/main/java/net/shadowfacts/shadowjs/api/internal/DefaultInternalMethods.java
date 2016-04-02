package net.shadowfacts.shadowjs.api.internal;

import javax.script.ScriptEngine;
import java.io.File;

/**
 * no-op
 * @author shadowfacts
 */
public class DefaultInternalMethods implements InternalMethods {

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public void addInclude(String include) {

	}

	@Override
	public String getIncludes() {
		return "";
	}

	@Override
	public File getScriptsDir() {
		return null;
	}

	@Override
	public void setScriptsDir(File scriptsDir) {

	}

	@Override
	public File getMainScript() {
		return null;
	}

	@Override
	public void setMainScript(File mainScript) {

	}

	@Override
	public ScriptEngine getScriptEngine() {
		return null;
	}

}
