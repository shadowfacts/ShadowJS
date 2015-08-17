package net.shadowfacts.shadowjs.js.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.shadowfacts.shadowjs.api.item.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shadowfacts
 */
public class CraftingManager {

	public static void registerShapedRecipe(Ingredient result,
											Ingredient i1, Ingredient i2, Ingredient i3,
											Ingredient i4, Ingredient i5, Ingredient i6,
											Ingredient i7, Ingredient i8, Ingredient i9) {

		ArrayList<Object> params = new ArrayList<>();

//		Pattern
		StringBuilder line1 = new StringBuilder();
		StringBuilder line2 = new StringBuilder();
		StringBuilder line3 = new StringBuilder();

		line1.append(i1 != null ? "A" : " ");
		line1.append(i2 != null ? "B" : " ");
		line1.append(i3 != null ? "C" : " ");

		line2.append(i4 != null ? "D" : " ");
		line2.append(i5 != null ? "E" : " ");
		line2.append(i6 != null ? "F" : " ");

		line3.append(i7 != null ? "G" : " ");
		line3.append(i8 != null ? "H" : " ");
		line3.append(i9 != null ? "I" : " ");

		params.add(line1.toString());
		params.add(line2.toString());
		params.add(line3.toString());

//		Ingredients
//		ABC
		if (i1 != null) {
			params.add('A');
			params.add(i1.getItemStack());
		}
		if (i2 != null) {
			params.add('B');
			params.add(i2.getItemStack());
		}
		if (i3 != null) {
			params.add('C');
			params.add(i3.getItemStack());
		}
//		DEF
		if (i4 != null) {
			params.add('D');
			params.add(i4.getItemStack());
		}
		if (i5 != null) {
			params.add('E');
			params.add(i5.getItemStack());
		}
		if (i6 != null) {
			params.add('F');
			params.add(i6.getItemStack());
		}
//		GHI
		if (i7 != null) {
			params.add('G');
			params.add(i7.getItemStack());
		}
		if (i8 != null) {
			params.add('H');
			params.add(i8.getItemStack());
		}
		if (i9 != null) {
			params.add('I');
			params.add(i9.getItemStack());
		}

		GameRegistry.addShapedRecipe(result.getItemStack(), params.toArray());
	}

	public static void registerShapelessRecipe(Ingredient result, Ingredient... inputs) {
		if (inputs.length > 9) throw new RuntimeException("Shapeless recipe cannot have more than 9 inputs");
		if (inputs[0] == null) throw new RuntimeException("Shapeless recipe must have at least 1 input");

		ArrayList<ItemStack> params = new ArrayList<>();

		params.add(inputs[0].getItemStack());
		if (inputs.length > 1 && inputs[1] != null) params.add(inputs[1].getItemStack());
		if (inputs.length > 2 && inputs[2] != null) params.add(inputs[2].getItemStack());
		if (inputs.length > 3 && inputs[3] != null) params.add(inputs[3].getItemStack());
		if (inputs.length > 4 && inputs[4] != null) params.add(inputs[4].getItemStack());
		if (inputs.length > 5 && inputs[5] != null) params.add(inputs[5].getItemStack());
		if (inputs.length > 6 && inputs[6] != null) params.add(inputs[6].getItemStack());
		if (inputs.length > 7 && inputs[7] != null) params.add(inputs[7].getItemStack());
		if (inputs.length > 8 && inputs[8] != null) params.add(inputs[8].getItemStack());

		GameRegistry.addShapelessRecipe(result.getItemStack(), params.toArray());
	}

	@SuppressWarnings("unchecked")
	public static void removeAllCraftingRecipes(Ingredient output) {
		List<IRecipe> recipes = net.minecraft.item.crafting.CraftingManager.getInstance().getRecipeList();

		List<IRecipe> toRemove = new ArrayList<>();
		recipes.stream().filter(recipe -> recipe.getRecipeOutput() != null).filter(recipe -> recipe.getRecipeOutput().isItemEqual(output.getItemStack())).forEach(toRemove::add);
		toRemove.stream().forEach(recipes::remove);
	}


	public static void registerFurnaceRecipe(Ingredient input, Ingredient result, float xp) {
		GameRegistry.addSmelting(input.getItemStack(), result.getItemStack(), xp);
	}

	public static void registerFurnaceRecipe(Ingredient input, Ingredient result) {
		registerFurnaceRecipe(input, result, 0f);
	}

	@SuppressWarnings("unchecked")
	public static void removeAllFurnaceRecipes(Ingredient ingredient) {
		ItemStack result = ingredient.getItemStack();

		ArrayList<ItemStack> toRemove = new ArrayList<>();
		FurnaceRecipes.smelting().getSmeltingList().entrySet().stream().filter(object -> {
			Map.Entry<ItemStack, ItemStack> entry = (Map.Entry<ItemStack, ItemStack>) object;
			return entry.getValue().isItemEqual(result) && entry.getValue().getItemDamage() == result.getItemDamage();
		}).forEach(object -> {
			Map.Entry<ItemStack, ItemStack> entry = (Map.Entry<ItemStack, ItemStack>) object;
			toRemove.add(entry.getKey());
		});

		toRemove.stream().forEach(FurnaceRecipes.smelting().getSmeltingList()::remove);
	}
}
