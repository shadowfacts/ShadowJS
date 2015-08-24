package net.shadowfacts.shadowjs.js.itemstack;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.shadowjs.api.item.Ingredient;
import net.shadowfacts.shadowjs.js.nbt.WrappedTagCompound;

/**
 * @author shadowfacts
 */
public class WrappedItemStack implements Ingredient {

	private ItemStack stack;
	private WrappedTagCompound tagCompound;

	public WrappedItemStack(ItemStack stack) {
		this.stack = stack;
	}

	public WrappedItemStack setMetadata(int metadata) {
		stack.setItemDamage(metadata);
		return this;
	}

	public WrappedItemStack registerOreDictionaryName(String name) {
		OreDictionary.registerOre(name, stack);
		return this;
	}

	public WrappedTagCompound getTagCompound() {
		if (tagCompound == null && stack.getTagCompound() != null) {
			tagCompound = new WrappedTagCompound(stack.getTagCompound());
		}
		return tagCompound;
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
