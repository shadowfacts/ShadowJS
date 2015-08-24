package net.shadowfacts.shadowjs.js.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.shadowjs.api.item.Ingredient;

/**
 * @author shadowfacts
 */
public class WrappedBlock implements Ingredient {

	public Block block;

	public WrappedBlock(Block block) {
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

	public WrappedBlock registerOreDictionaryName(String name) {
		OreDictionary.registerOre(name, block);
		return this;
	}

	@Override
	public ItemStack getItemStack(int count) {
		return new ItemStack(block, count);
	}
}
