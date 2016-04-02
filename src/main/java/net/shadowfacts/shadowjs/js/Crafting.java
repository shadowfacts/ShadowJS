package net.shadowfacts.shadowjs.js;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.shadowfacts.shadowjs.api.Ingredient;
import net.shadowfacts.shadowjs.util.MiscUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shadowfacts
 */
public class Crafting {

	public static void addShaped(Ingredient result, Object... inputs) {
		Object[] params = new Object[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			Object o;

			if (inputs[i] instanceof Ingredient) {
				o = ((Ingredient)inputs[i]).getItemStack();
			} else if (inputs[i] instanceof String || inputs[i] instanceof Character) {
				o = inputs[i];
			} else {
				throw new IllegalArgumentException("Recipe input must be an Ingredient, String, or Character");
			}

			params[i] = o;
		}
		GameRegistry.addRecipe(new ShapedOreRecipe(result.getItemStack(), params));
	}

	public static void addShapeless(Ingredient result, Object... inputs) {
		if (inputs.length > 9) throw new IllegalArgumentException("Shapeless recipe cannot have more than 9 inputs");
		if (inputs[0] == null) throw new IllegalArgumentException("Shapeless recipe must have at least 1 input");

		Object[] params = new Object[inputs.length];

		for (int i = 0; i < inputs.length; i++) {
			Object o = null;

			if (inputs[i] instanceof Ingredient) {
				o = ((Ingredient)inputs[i]).getItemStack();
			} else if (inputs[i] instanceof String) {
				o = inputs[i];
			} else {
				throw new IllegalArgumentException("Recipe input must be an Ingredient or a String");
			}

			params[i] = o;
		}

		GameRegistry.addRecipe(new ShapelessOreRecipe(result.getItemStack(), params));
	}

	public static void removeAll(Ingredient output) {
		ItemStack outputStack = output.getItemStack();

		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

		recipes.removeAll(recipes.stream()
				.filter(recipe -> recipe.getRecipeOutput() != null)
				.filter(recipe -> MiscUtils.areItemStacksEqual(recipe.getRecipeOutput(), outputStack))
				.collect(Collectors.toList()));
	}

//	public static void registerShapedRecipe(Ingredient result,
//											Object i1, Object i2, Object i3,
//											Object i4, Object i5, Object i6,
//											Object i7, Object i8, Object i9) {
//
//		List<Object> params = new ArrayList<>();
//
////		Pattern
//		StringBuilder line1 = new StringBuilder();
//		StringBuilder line2 = new StringBuilder();
//		StringBuilder line3 = new StringBuilder();
//
//		line1.append(i1 != null ? "A" : " ");
//		line1.append(i2 != null ? "B" : " ");
//		line1.append(i3 != null ? "C" : " ");
//
//		line2.append(i4 != null ? "D" : " ");
//		line2.append(i5 != null ? "E" : " ");
//		line2.append(i6 != null ? "F" : " ");
//
//		line3.append(i7 != null ? "G" : " ");
//		line3.append(i8 != null ? "H" : " ");
//		line3.append(i9 != null ? "I" : " ");
//
//		params.add(line1.toString());
//		params.add(line2.toString());
//		params.add(line3.toString());
//
////		Ingredients
////		ABC
//		if (i1 != null) {
//			params.add('A');
//			if (i1 instanceof Ingredient) params.add(((Ingredient) i1).getItemStack());
//			else if (i1 instanceof String) params.add(i1);
//			else throw new RuntimeException("The first ingredient parameter should be an Ingredient or a string");
//		}
//		if (i2 != null) {
//			params.add('B');
//			if (i2 instanceof Ingredient) params.add(((Ingredient) i2).getItemStack());
//			else if (i2 instanceof String) params.add(i2);
//			else throw new RuntimeException("The second ingredient parameter should be an Ingredient or a string");
//		}
//		if (i3 != null) {
//			params.add('C');
//			if (i3 instanceof Ingredient) params.add(((Ingredient) i3).getItemStack());
//			else if (i3 instanceof String) params.add(i3);
//			else throw new RuntimeException("The third ingredient parameter should be an Ingredient or a string");
//		}
////		DEF
//		if (i4 != null) {
//			params.add('D');
//			if (i4 instanceof Ingredient) params.add(((Ingredient) i4).getItemStack());
//			else if (i4 instanceof String) params.add(i4);
//			else throw new RuntimeException("The fourth ingredient parameter should be an Ingredient or a string");
//		}
//		if (i5 != null) {
//			params.add('E');
//			if (i5 instanceof Ingredient) params.add(((Ingredient) i5).getItemStack());
//			else if (i5 instanceof String) params.add(i5);
//			else throw new RuntimeException("The fifth ingredient parameter should be an Ingredient or a string");
//		}
//		if (i6 != null) {
//			params.add('F');
//			if (i6 instanceof Ingredient) params.add(((Ingredient) i6).getItemStack());
//			else if (i6 instanceof String) params.add(i6);
//			else throw new RuntimeException("The sixth ingredient parameter should be an Ingredient or a string");
//		}
////		GHI
//		if (i7 != null) {
//			params.add('G');
//			if (i7 instanceof Ingredient) params.add(((Ingredient) i7).getItemStack());
//			else if (i7 instanceof String) params.add(i7);
//			else throw new RuntimeException("The seventh ingredient parameter should be an Ingredient or a string");
//		}
//		if (i8 != null) {
//			params.add('H');
//			if (i8 instanceof Ingredient) params.add(((Ingredient) i8).getItemStack());
//			else if (i8 instanceof String) params.add(i8);
//			else throw new RuntimeException("The eighth ingredient parameter should be an Ingredient or a string");
//		}
//		if (i9 != null) {
//			params.add('I');
//			if (i9 instanceof Ingredient) params.add(((Ingredient) i9).getItemStack());
//			else if (i9 instanceof String) params.add(i9);
//			else throw new RuntimeException("The ninth ingredient parameter should be an Ingredient or a string");
//		}
//
//		GameRegistry.addRecipe(new ShapedOreRecipe(result.getItemStack(), params.toArray()));
//	}


}
