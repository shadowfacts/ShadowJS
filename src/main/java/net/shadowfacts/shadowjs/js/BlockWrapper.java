package net.shadowfacts.shadowjs.js;

import lombok.ToString;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.shadowfacts.shadowjs.api.Ingredient;

/**
 * @author shadowfacts
 */
@ToString
public class BlockWrapper implements Ingredient {

	Block block;

	private BlockWrapper(Block block) {
		this.block = block;
	}

	public BlockWrapper setLightLevel(float level) {
		block.setLightLevel(level);
		return this;
	}

	public BlockWrapper setHardness(float hardness) {
		block.setHardness(hardness);
		return this;
	}

	public BlockWrapper setResistance(float resistance) {
		block.setResistance(resistance);
		return this;
	}

	public BlockWrapper setHarvestLevel(String tool, int level) {
		block.setHarvestLevel(tool, level);
		return this;
	}

	public BlockWrapper registerOreDictionary(String name) {
		OreDictionary.registerOre(name, block);
		return this;
	}

	@Override
	public ItemStack getItemStack(int amount) {
		return new ItemStack(block, amount);
	}

	static BlockWrapper of(Block block) {
		return new BlockWrapper(block);
	}

}
