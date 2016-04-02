package net.shadowfacts.shadowjs.compat;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shadowfacts
 */
@mezz.jei.api.JEIPlugin
public class JEIPlugin extends BlankModPlugin {

	private static List<ItemStack> toBlacklist = new ArrayList<>();
	private static List<ItemStack> toUnblacklist = new ArrayList<>();

	public static void addToBlacklist(ItemStack stack) {
		toBlacklist.add(stack);
	}

	public static void addToUnblacklist(ItemStack stack) {
		toUnblacklist.add(stack);
	}

	@Override
	public void register(@Nonnull IModRegistry registry) {
		toBlacklist.forEach(registry.getJeiHelpers().getItemBlacklist()::addItemToBlacklist);
		toUnblacklist.forEach(registry.getJeiHelpers().getItemBlacklist()::removeItemFromBlacklist);
	}



}
