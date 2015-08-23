package net.shadowfacts.shadowjs;

import jdk.nashorn.api.scripting.ClassFilter;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class SJSClassFilter implements ClassFilter {

	public static ArrayList<String> validClasses = new ArrayList<>();

	static {
		validClasses.add("net.shadowfacts.shadowjs.js.*");
		validClasses.add("java.util.ArrayList");
		validClasses.add("cpw.mods.fml.relauncher.Side");
	}

	@Override
	public boolean exposeToScripts(String s) {
		for (String str : validClasses) {
			if (s.matches(str)) {
				return true;
			}
		}
		return false;
	}

}
