package net.shadowfacts.shadowjs.js.mod;

import codechicken.nei.api.API;
import net.shadowfacts.shadowjs.api.item.Ingredient;

/**
 * @author shadowfacts
 */
public class NEI {

	public static void hide(Ingredient ingredient) {
		API.hideItem(ingredient.getItemStack());
	}

	public static void setOverrideName(Ingredient ingredient, String name) {
		API.setOverrideName(ingredient.getItemStack(), name);
	}

}
