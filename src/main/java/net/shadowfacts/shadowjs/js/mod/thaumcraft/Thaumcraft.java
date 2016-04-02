package net.shadowfacts.shadowjs.js.mod.thaumcraft;

import net.minecraft.item.ItemStack;
import net.shadowfacts.shadowjs.api.Ingredient;
import net.shadowfacts.shadowjs.js.StackWrapper;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;

/**
 * @author shadowfacts
 */
public class Thaumcraft {

	public static AspectWrapper getAspect(String id) {
		return AspectWrapper.of(Aspect.aspects.get(id));
	}

	public static AspectListWrapper getAspectList(Object... params) {
		return AspectListWrapper.of(params);
	}

	public static void setEntityAspects(String entityName, AspectListWrapper aspects) {
		ThaumcraftApi.registerEntityTag(entityName, aspects.unwrap());
	}

	public static void addInfernalSmeltingBonus(Object in, Ingredient bonus) {
		ItemStack stack = bonus instanceof StackWrapper ? bonus.getItemStack() : bonus.getItemStack(0);
		if (in instanceof String) {
			ThaumcraftApi.addSmeltingBonus((String)in, stack);
		} else if (in instanceof Ingredient) {
			ThaumcraftApi.addSmeltingBonus(((Ingredient)in).getItemStack(), stack);
		} else {
			throw new IllegalArgumentException("Invalid input " + in);
		}
	}

	public static void addShapedArcaneCraftingRecipe(String research, Ingredient result, AspectListWrapper aspects, Object... recipe) {
		ThaumcraftApi.addArcaneCraftingRecipe(research, result.getItemStack(), aspects.unwrap(), recipe);
	}

	public static void addShapedArcaneCraftingRecipe(String[] research, Ingredient result, AspectListWrapper aspects, Object... recipe) {
		ThaumcraftApi.addArcaneCraftingRecipe(research, result.getItemStack(), aspects.unwrap(), recipe);
	}

	public static void addShapelessArcaneCraftingRecipe(String research, Ingredient result, AspectListWrapper aspects, Object... recipe) {
		ThaumcraftApi.addShapelessArcaneCraftingRecipe(research, result.getItemStack(), aspects.unwrap(), recipe);
	}

	public static void addShapelessArcaneCraftingRecipe(String[] research, Ingredient result, AspectListWrapper aspects, Object... recipe) {
		ThaumcraftApi.addShapelessArcaneCraftingRecipe(research, result.getItemStack(), aspects.unwrap(), recipe);
	}

	public static void addInfusionRecipe(String research, Ingredient result, int instability, AspectListWrapper aspects, Ingredient input, Object[] recipe) {
		Object[] newRecipe = new Object[recipe.length];
		for (int i = 0; i < recipe.length; i++) {
			Object o = null;
			if (newRecipe[i] instanceof String) {
				o = newRecipe[i];
			} else if (newRecipe[i] instanceof Ingredient) {
				o = ((Ingredient)newRecipe[i]).getItemStack();
			} else {
				throw new IllegalArgumentException("Invalid infusion recipe component " + newRecipe[i]);
			}
			newRecipe[i] = o;
		}
		ThaumcraftApi.addInfusionCraftingRecipe(research, result.getItemStack(), instability, aspects.unwrap(), input.getItemStack(), newRecipe);
	}

	public static void addInfusionRecipe(String[] research, Ingredient result, int instability, AspectListWrapper aspects, Ingredient input, Object[] recipe) {
		Object[] unwrappedRecipe = new Object[recipe.length];
		for (int i = 0; i < recipe.length; i++) {
			Object o = null;
			if (unwrappedRecipe[i] instanceof String) {
				o = unwrappedRecipe[i];
			} else if (unwrappedRecipe[i] instanceof Ingredient) {
				o = ((Ingredient)unwrappedRecipe[i]).getItemStack();
			} else {
				throw new IllegalArgumentException("Invalid infusion recipe component " + unwrappedRecipe[i]);
			}
			unwrappedRecipe[i] = o;
		}
		ThaumcraftApi.addInfusionCraftingRecipe(research, result.getItemStack(), instability, aspects.unwrap(), input.getItemStack(), unwrappedRecipe);
	}

	public static void addCrucibleRecipe(String research, Ingredient result, Object catalyst, AspectListWrapper aspects) {
		addCrucibleRecipe(new String[]{research}, result, catalyst, aspects);
	}

	public static void addCrucibleRecipe(String[] research, Ingredient result, Object catalyst, AspectListWrapper aspects) {
		Object unwrappedCatalyst = null;
		if (catalyst instanceof String) {
			unwrappedCatalyst = catalyst;
		} else if (catalyst instanceof Ingredient) {
			unwrappedCatalyst = ((Ingredient)catalyst).getItemStack();
		}
		ThaumcraftApi.addCrucibleRecipe(research, result.getItemStack(), unwrappedCatalyst, aspects.unwrap());
	}

	public static void addAspects(Ingredient item, AspectListWrapper aspects) {
		ThaumcraftApi.registerObjectTag(item.getItemStack(), aspects.unwrap());
	}

	public static void addAspects(Ingredient item, int[] meta, AspectListWrapper aspects) {
		ThaumcraftApi.registerObjectTag(item.getItemStack(), meta, aspects.unwrap());
	}

	public static void addAspects(String id, AspectListWrapper aspects) {
		ThaumcraftApi.registerObjectTag(id, aspects.unwrap());
	}

}
