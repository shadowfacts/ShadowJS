package net.shadowfacts.shadowjs.js;

import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shadowfacts
 */
public class OreDict {

	public static List<StackWrapper> get(String name) {
		return OreDictionary.getOres(name).stream()
				.map(StackWrapper::of)
				.collect(Collectors.toList());
	}

	public static void register(BlockWrapper block, String name) {
		block.registerOreDictionary(name);
	}

	public static void register(ItemWrapper item, String name) {
		item.registerOreDictionary(name);
	}

	public static void register(StackWrapper stack, String name) {
		stack.registerOreDictionary(name);
	}

}
