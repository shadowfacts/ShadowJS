package net.shadowfacts.shadowjs;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class SJSClassFilter {

	public static SJSClassFilter instance = new SJSClassFilter();

	public static ArrayList<String> validClasses = new ArrayList<>();

	static {
		validClasses.add("net.shadowfacts.shadowjs.js.*");
		validClasses.add("java.util.ArrayList");
		validClasses.add("cpw.mods.fml.relauncher.Side");
	}

	public boolean exposeToScripts(String s) {
		for (String str : validClasses) {
			if (s.matches(str)) {
				return true;
			}
		}
		return false;
	}

}
