package net.shadowfacts.shadowjs;

import jdk.nashorn.api.scripting.ClassFilter;

/**
 * @author shadowfacts
 */
public class SJSClassFilter implements ClassFilter {

	@Override
	public boolean exposeToScripts(String clazz) {
		return clazz.startsWith("net.shadowfacts.shadowjs.js.");
	}

}
