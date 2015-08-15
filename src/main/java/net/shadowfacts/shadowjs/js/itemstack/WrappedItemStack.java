package net.shadowfacts.shadowjs.js.itemstack;

import net.minecraft.item.ItemStack;
import net.shadowfacts.shadowjs.api.item.Ingredient;

/**
 * @author shadowfacts
 */
public class WrappedItemStack implements Ingredient {

	private ItemStack stack;

	WrappedItemStack(ItemStack stack) {
		this.stack = stack;
	}

	@Override
	public ItemStack getItemStack() {
		return stack;
	}

	@Override
	public ItemStack getItemStack(int count) {
		ItemStack theStack = stack.copy();
		theStack.stackSize = count;
		return theStack;
	}
}
