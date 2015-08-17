package net.shadowfacts.shadowjs.js.item;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author shadowfacts
 */
public class Items {

	public static WrappedItem get(String id) {
		return get("minecraft", id);
	}

	public static WrappedItem get(String modId, String id) {
		return new WrappedItem(GameRegistry.findItem(modId, id));
	}

}
