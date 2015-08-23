package net.shadowfacts.shadowjs.js.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.shadowfacts.shadowjs.api.item.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author shadowfacts
 */
public class CraftingManager {

	public static void registerShapedRecipe(Ingredient result,
											Object i1, Object i2, Object i3,
											Object i4, Object i5, Object i6,
											Object i7, Object i8, Object i9) {

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
			if (i1 instanceof Ingredient) params.add(((Ingredient) i1).getItemStack());
			else if (i1 instanceof String) params.add(i1);
			else throw new RuntimeException("The first ingredient parameter should be an Ingredient or a string");
		}
		if (i2 != null) {
			params.add('B');
			if (i2 instanceof Ingredient) params.add(((Ingredient) i2).getItemStack());
			else if (i2 instanceof String) params.add(i2);
			else throw new RuntimeException("The second ingredient parameter should be an Ingredient or a string");
		}
		if (i3 != null) {
			params.add('C');
			if (i3 instanceof Ingredient) params.add(((Ingredient) i3).getItemStack());
			else if (i3 instanceof String) params.add(i3);
			else throw new RuntimeException("The third ingredient parameter should be an Ingredient or a string");
		}
//		DEF
		if (i4 != null) {
			params.add('D');
			if (i4 instanceof Ingredient) params.add(((Ingredient) i4).getItemStack());
			else if (i4 instanceof String) params.add(i4);
			else throw new RuntimeException("The fourth ingredient parameter should be an Ingredient or a string");
		}
		if (i5 != null) {
			params.add('E');
			if (i5 instanceof Ingredient) params.add(((Ingredient) i5).getItemStack());
			else if (i5 instanceof String) params.add(i5);
			else throw new RuntimeException("The fifth ingredient parameter should be an Ingredient or a string");
		}
		if (i6 != null) {
			params.add('F');
			if (i6 instanceof Ingredient) params.add(((Ingredient) i6).getItemStack());
			else if (i6 instanceof String) params.add(i6);
			else throw new RuntimeException("The sixth ingredient parameter should be an Ingredient or a string");
		}
//		GHI
		if (i7 != null) {
			params.add('G');
			if (i7 instanceof Ingredient) params.add(((Ingredient) i7).getItemStack());
			else if (i7 instanceof String) params.add(i7);
			else throw new RuntimeException("The seventh ingredient parameter should be an Ingredient or a string");
		}
		if (i8 != null) {
			params.add('H');
			if (i8 instanceof Ingredient) params.add(((Ingredient) i8).getItemStack());
			else if (i8 instanceof String) params.add(i8);
			else throw new RuntimeException("The eighth ingredient parameter should be an Ingredient or a string");
		}
		if (i9 != null) {
			params.add('I');
			if (i9 instanceof Ingredient) params.add(((Ingredient) i9).getItemStack());
			else if (i9 instanceof String) params.add(i9);
			else throw new RuntimeException("The ninth ingredient parameter should be an Ingredient or a string");
		}

		GameRegistry.addRecipe(new ShapedOreRecipe(result.getItemStack(), params.toArray()));
	}

	public static void registerShapelessRecipe(Ingredient result, Object... inputs) {
		if (inputs.length > 9) throw new RuntimeException("Shapeless recipe cannot have more than 9 inputs");
		if (inputs[0] == null) throw new RuntimeException("Shapeless recipe must have at least 1 input");

		ArrayList<Object> params = new ArrayList<>();

		if (inputs[0] instanceof Ingredient)  params.add(((Ingredient)inputs[0]).getItemStack());
		else if (inputs[0] instanceof String) params.add(inputs[0]);
		else throw new RuntimeException("The first ingredient parameter should be an Ingredient or a string");

		if (inputs.length > 1 && inputs[1] != null) {
			if (inputs[1] instanceof Ingredient)  params.add(((Ingredient)inputs[1]).getItemStack());
			else if (inputs[1] instanceof String) params.add(inputs[1]);
			else throw new RuntimeException("The second ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 2 && inputs[2] != null) {
			if (inputs[2] instanceof Ingredient)  params.add(((Ingredient)inputs[2]).getItemStack());
			else if (inputs[2] instanceof String) params.add(inputs[2]);
			else throw new RuntimeException("The third ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 3 && inputs[3] != null) {
			if (inputs[3] instanceof Ingredient)  params.add(((Ingredient)inputs[3]).getItemStack());
			else if (inputs[3] instanceof String) params.add(inputs[3]);
			else throw new RuntimeException("The fourth ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 4 && inputs[4] != null) {
			if (inputs[4] instanceof Ingredient)  params.add(((Ingredient)inputs[4]).getItemStack());
			else if (inputs[4] instanceof String) params.add(inputs[4]);
			else throw new RuntimeException("The fifth ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 5 && inputs[5] != null) {
			if (inputs[5] instanceof Ingredient)  params.add(((Ingredient)inputs[5]).getItemStack());
			else if (inputs[5] instanceof String) params.add(inputs[5]);
			else throw new RuntimeException("The sixth ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 6 && inputs[6] != null) {
			if (inputs[0] instanceof Ingredient)  params.add(((Ingredient)inputs[0]).getItemStack());
			else if (inputs[0] instanceof String) params.add(inputs[0]);
			else throw new RuntimeException("The first ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 7 && inputs[7] != null) {
			if (inputs[7] instanceof Ingredient)  params.add(((Ingredient)inputs[7]).getItemStack());
			else if (inputs[7] instanceof String) params.add(inputs[7]);
			else throw new RuntimeException("The eighth ingredient parameter should be an Ingredient or a string");
		}
		if (inputs.length > 8 && inputs[8] != null) {
			if (inputs[9] instanceof Ingredient)  params.add(((Ingredient)inputs[9]).getItemStack());
			else if (inputs[9] instanceof String) params.add(inputs[9]);
			else throw new RuntimeException("The ninth ingredient parameter should be an Ingredient or a string");
		}

		GameRegistry.addRecipe(new ShapelessOreRecipe(result.getItemStack(), params.toArray()));
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
	public static void removeAllFurnaceRecipes(Ingredient output) {
		ItemStack result = output.getItemStack();

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
