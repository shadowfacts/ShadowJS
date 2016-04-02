package net.shadowfacts.shadowjs.util;

import net.minecraft.item.ItemStack;

/**
 * @author shadowfacts
 */
public class MiscUtils {

	public static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
		return stackA == null && stackB == null || (!((stackA != null && stackB != null) && stackA.getItem() != stackB.getItem()) && (stackA.getItemDamage() == stackB.getItemDamage() && (!(stackA.getTagCompound() == null && stackB.getTagCompound() != null) && (stackA.getTagCompound() == null || stackA.getTagCompound().equals(stackB.getTagCompound())))));
	}

}
