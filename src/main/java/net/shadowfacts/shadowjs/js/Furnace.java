package net.shadowfacts.shadowjs.js;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.shadowfacts.shadowjs.api.Ingredient;
import net.shadowfacts.shadowjs.util.MiscUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shadowfacts
 */
public class Furnace {

	public static void add(Ingredient input, Ingredient result, float xp) {
		GameRegistry.addSmelting(input.getItemStack(), result.getItemStack(), xp);
	}

	public static void add(Ingredient input, Ingredient result) {
		add(input, result, 0f);
	}

	public static void removeAll(Ingredient output) {
		ItemStack outputStack = output.getItemStack();;

		List<ItemStack> toRemove = new ArrayList<>();
		FurnaceRecipes.instance().getSmeltingList().entrySet().stream()
				.filter(e -> MiscUtils.areItemStacksEqual(e.getValue(), outputStack))
				.map(Map.Entry::getKey)
				.forEach(toRemove::add);

		toRemove.forEach(FurnaceRecipes.instance().getSmeltingList()::remove);
	}

}
