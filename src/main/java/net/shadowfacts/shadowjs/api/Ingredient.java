package net.shadowfacts.shadowjs.api;

import net.minecraft.item.ItemStack;

/**
 * @author shadowfacts
 */
public interface Ingredient {

	default ItemStack getItemStack() {
		return getItemStack(1);
	}

	ItemStack getItemStack(int amount);

}
