package net.shadowfacts.shadowjs.js;

import lombok.ToString;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.shadowjs.api.Ingredient;

/**
 * @author shadowfacts
 */
@ToString
public class StackWrapper implements Ingredient {

	private ItemStack stack;

	private StackWrapper(ItemStack stack) {
		this.stack = stack;
	}

	public StackWrapper setMetadata(int meta) {
		stack.setItemDamage(meta);
		return this;
	}

	public StackWrapper registerOreDictionary(String name) {
		OreDictionary.registerOre(name, stack);
		return this;
	}

	@Override
	public ItemStack getItemStack(int amount) {
		ItemStack stack = this.stack.copy();
		stack.stackSize = amount;
		return stack;
	}

	static StackWrapper of(ItemStack stack) {
		return new StackWrapper(stack);
	}

}
