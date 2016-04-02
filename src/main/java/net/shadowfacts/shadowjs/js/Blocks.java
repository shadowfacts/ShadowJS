package net.shadowfacts.shadowjs.js;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author shadowfacts
 */
public class Blocks {

	public static BlockWrapper get(String id) {
		if (id.contains(":")) {
			return get(id.split(":")[0], id.split(":")[1]);
		} else {
			return get("minecraft", id);
		}
	}

	public static BlockWrapper get(String modId, String id) {
		Block block = GameRegistry.findBlock(modId, id);
		if (block == null) {
			throw new IllegalArgumentException("Invalid modId/id combo " + modId + " " + id);
		}
		return BlockWrapper.of(block);
	}

}
