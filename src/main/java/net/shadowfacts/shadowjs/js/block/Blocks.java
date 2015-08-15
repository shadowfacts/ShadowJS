package net.shadowfacts.shadowjs.js.block;

import net.minecraft.block.Block;

/**
 * @author shadowfacts
 */
public class Blocks {

	public static WrappedBlock get(String id) {
		return new WrappedBlock((Block)Block.blockRegistry.getObject(id));
	}

	public static WrappedBlock get(String modId, String id) {
		return get(modId + ":" + id);
	}

}
