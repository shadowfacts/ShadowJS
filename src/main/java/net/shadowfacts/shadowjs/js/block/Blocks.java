package net.shadowfacts.shadowjs.js.block;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author shadowfacts
 */
public class Blocks {

	public static WrappedBlock get(String id) {
		return get("minecraft", id);
	}

	public static WrappedBlock get(String modId, String id) {
		return new WrappedBlock(GameRegistry.findBlock(modId, id));
	}

}
