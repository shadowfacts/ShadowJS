package net.shadowfacts.shadowjs.js.mod;

import net.shadowfacts.shadowjs.api.Ingredient;
import net.shadowfacts.shadowjs.compat.JEIPlugin;

/**
 * @author shadowfacts
 */
public class JEI {

	public static void blacklist(Ingredient ingredient) {
		JEIPlugin.addToBlacklist(ingredient.getItemStack());
	}

	public static void unblacklist(Ingredient ingredient) {
		JEIPlugin.addToUnblacklist(ingredient.getItemStack());
	}

}
