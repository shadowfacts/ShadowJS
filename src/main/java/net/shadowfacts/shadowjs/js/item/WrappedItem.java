package net.shadowfacts.shadowjs.js.item;

import net.minecraft.item.Item;

/**
 * @author shadowfacts
 */
public class WrappedItem {

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

}
