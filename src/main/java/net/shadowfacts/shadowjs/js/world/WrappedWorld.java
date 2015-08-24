package net.shadowfacts.shadowjs.js.world;

import net.minecraft.world.World;
import net.shadowfacts.shadowjs.js.block.WrappedBlock;

/**
 * @author shadowfacts
 */
public class WrappedWorld {

	private World world;

	public WrappedWorld(World world) {
		this.world = world;
	}

	public WrappedBlock getBlock(int x, int y, int z) {
		return new WrappedBlock(world.getBlock(x, y, z));
	}

	public int getMetadata(int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	public void setBlock(int x, int y, int z, WrappedBlock block) {
		System.out.println(world.setBlock(x, y, z, block.block));
	}

	public void setMetadata(int x, int y, int z, int metadata) {
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
	}

}
