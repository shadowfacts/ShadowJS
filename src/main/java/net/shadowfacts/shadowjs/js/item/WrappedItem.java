package net.shadowfacts.shadowjs.js.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.shadowfacts.shadowjs.api.item.Ingredient;

/**
 * @author shadowfacts
 */
public class WrappedItem implements Ingredient {

	private Item item;

	WrappedItem(Item item) {
		this.item = item;
	}

	public WrappedItem setTexture(String texture) {
		item.setTextureName(texture);
		return this;
	}

	public WrappedItem preventRepair() {
		item.setNoRepair();
		return this;
	}

	public WrappedItem setHarvestLevel(String tool, int level) {
		item.setHarvestLevel(tool, level);
		return this;
	}

	public WrappedItem setMaxDamage(int damage) {
		item.setMaxDamage(damage);
		return this;
	}

	@Override
	public ItemStack getItemStack(int count) {
		return new ItemStack(item, count);
	}
}
