package net.shadowfacts.shadowjs.js.item;

import net.minecraft.item.Item;

/**
 * @author shadowfacts
 */
public class Items {

	public static WrappedItem get(String id) {
		return new WrappedItem((Item)Item.itemRegistry.getObject(id));
	}

	public static WrappedItem get(String modId, String id) {
		return get(modId + ":" + id);
	}

}
