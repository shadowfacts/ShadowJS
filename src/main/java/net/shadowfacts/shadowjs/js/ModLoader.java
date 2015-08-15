package net.shadowfacts.shadowjs.js;

import cpw.mods.fml.common.Loader;

/**
 * @author shadowfacts
 */
public class ModLoader {

	public static boolean isModLoaded(String modId) {
		return Loader.isModLoaded(modId);
	}

}
