package net.shadowfacts.shadowjs.js.misc;

import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.shadowjs.js.block.WrappedBlock;
import net.shadowfacts.shadowjs.js.item.WrappedItem;
import net.shadowfacts.shadowjs.js.itemstack.WrappedItemStack;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class OreDictionaryInterface {

	public static ArrayList<WrappedItemStack> getOres(String name) {
		ArrayList<WrappedItemStack> ret = new ArrayList<>();
		OreDictionary.getOres(name).stream().forEach(stack -> ret.add(new WrappedItemStack(stack)));
		return ret;
	}

	public static void registerOre(WrappedBlock block, String name) {
		block.registerOreDictionaryName(name);
	}

	public static void registerOre(WrappedItem item, String name) {
		item.registerOreDictionaryName(name);
	}

	public static void registerOre(WrappedItemStack stack, String name) {
		stack.registerOreDictionaryName(name);
	}

}
