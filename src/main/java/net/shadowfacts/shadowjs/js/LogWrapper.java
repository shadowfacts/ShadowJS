package net.shadowfacts.shadowjs.js;

import net.shadowfacts.shadowmc.util.LogHelper;

/**
 * @author shadowfacts
 */
public class LogWrapper extends LogHelper {

	public LogWrapper(String name) {
		super("ShadowJS|" + name);
	}

	public static LogWrapper of(String name) {
		return new LogWrapper(name);
	}

}
