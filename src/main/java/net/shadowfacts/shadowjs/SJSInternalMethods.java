package net.shadowfacts.shadowjs;

import lombok.Getter;
import lombok.Setter;
import net.shadowfacts.shadowjs.api.internal.InternalMethods;
import net.shadowfacts.shadowjs.util.NashornUtils;

import javax.script.ScriptEngine;
import java.io.File;

/**
 * @author shadowfacts
 */
public class SJSInternalMethods implements InternalMethods {

	@Getter
	private String includes = "";
	@Getter @Setter
	private File scriptsDir;
	@Getter @Setter
	private File mainScript;

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public void addInclude(String include) {
		includes += include;
	}

	@Override
	public ScriptEngine getScriptEngine() {
		return NashornUtils.engine;
	}

}
