package net.shadowfacts.shadowjs.js;

import lombok.ToString;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.shadowjs.api.Ingredient;

/**
 * @author shadowfacts
 */
@ToString
public class ItemWrapper implements Ingredient {

	private Item item;

	private ItemWrapper(Item item) {
		this.item = item;
	}

	public ItemWrapper preventRepair() {
		item.setNoRepair();
		return this;
	}

	public ItemWrapper setHarvestLevel(String tool, int level) {
		item.setHarvestLevel(tool, level);
		return this;
	}

	public ItemWrapper setMaxDamage(int damage) {
		item.setMaxDamage(damage);
		return this;
	}

	public ItemWrapper registerOreDictionary(String name) {
		OreDictionary.registerOre(name, item);
		return this;
	}

	@Override
	public ItemStack getItemStack(int amount) {
		return new ItemStack(item, amount);
	}

	static ItemWrapper of(Item item) {
		return new ItemWrapper(item);
	}

}
