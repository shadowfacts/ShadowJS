package net.shadowfacts.shadowjs.js.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.shadowfacts.shadowjs.api.item.Ingredient;

import java.util.ArrayList;

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


}
