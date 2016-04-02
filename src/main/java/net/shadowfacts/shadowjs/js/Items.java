package net.shadowfacts.shadowjs.js;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author shadowfacts
 */
public class Items {

	public static ItemWrapper get(String id) {
		if (id.contains(":")) {
			return get(id.split(":")[0], id.split(":")[1]);
		} else {
			return get("minecraft", id);
		}
	}

	public static ItemWrapper get(String modId, String id) {
		Item item = GameRegistry.findItem(modId, id);
		if (item == null) {
			throw new IllegalArgumentException("Invalid modId/id combo " + modId + " " + id);
		}
		return ItemWrapper.of(item);
	}

}
