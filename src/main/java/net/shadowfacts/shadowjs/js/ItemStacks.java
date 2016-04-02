package net.shadowfacts.shadowjs.js;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author shadowfacts
 */
public class ItemStacks {

	public static StackWrapper get(String modId, String id, int meta, int count) {
		ItemStack stack = GameRegistry.makeItemStack(modId + ":" + id, meta, count, "");
		if (stack == null) {
			throw new IllegalArgumentException("Invalid modId/id combo " + modId + " " + id);
		}
		return StackWrapper.of(stack);
	}

	public static StackWrapper get(String modId, String id, int meta) {
		return get(modId, id, meta, 1);
	}

	public static StackWrapper get(String modId, String id) {
		return get(modId, id, 0);
	}

	public static StackWrapper get(String id) {
		String modId = id.contains(":") ? id.split(":")[0] : "minecraft";
		String itemId = id.contains(":") ? id.split(":")[1] : id;
		return get(modId, itemId);
	}

}
