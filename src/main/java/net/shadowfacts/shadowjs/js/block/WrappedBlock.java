package net.shadowfacts.shadowjs.js.block;

import net.minecraft.block.Block;

/**
 * @author shadowfacts
 */
public class WrappedBlock {

	private Block block;

	WrappedBlock(Block block) {
		this.block = block;
	}

	public WrappedBlock setTexture(String name) {
		block.setBlockTextureName(name);
		return this;
	}

	public WrappedBlock setLightLevel(float level) {
		block.setLightLevel(level);
		return this;
	}

	public WrappedBlock setHardness(float hardness) {
		block.setHardness(hardness);
		return this;
	}

	public WrappedBlock setExplosionResistance(float resistance) { // is futile
		block.setResistance(resistance);
		return this;
	}

	public WrappedBlock setHarvestLevel(String tool, int level) {
		block.setHarvestLevel(tool, level);
		return this;
	}

	public WrappedBlock setHarvestLevel(String tool, int level, int metadata) {
		block.setHarvestLevel(tool, level, metadata);
		return this;
	}

}
