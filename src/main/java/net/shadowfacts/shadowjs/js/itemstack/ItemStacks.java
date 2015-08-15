package net.shadowfacts.shadowjs.js.itemstack;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

/**
 * @author shadowfacts
 */
public class ItemStacks {

	public static WrappedItemStack get(String modId, String id, int count) {
		return new WrappedItemStack(GameRegistry.findItemStack(modId, id, count));
	}

	public static WrappedItemStack get(String modId, String id) {
		return get(modId, id, 1);
	}

	public static WrappedItemStack get(String id, int count) {
		return get("minecraft", id, count);
	}

	public static WrappedItemStack get(String id) {
		return get("minecraft", id);
	}

}
