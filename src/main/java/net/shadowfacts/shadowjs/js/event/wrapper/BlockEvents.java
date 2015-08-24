package net.shadowfacts.shadowjs.js.event.wrapper;

import net.shadowfacts.shadowjs.js.block.WrappedBlock;
import net.shadowfacts.shadowjs.js.itemstack.WrappedItemStack;
import net.shadowfacts.shadowjs.js.player.WrappedPlayer;
import net.shadowfacts.shadowjs.js.world.WrappedWorld;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public abstract class BlockEvents {

	public abstract int getX();
	public abstract int getY();
	public abstract int getZ();
	public abstract WrappedWorld getWorld();
	public abstract WrappedBlock getBlock();
	public abstract int getMetadata();

	public abstract void cancel();


	public static class Break extends BlockEvents {

		private net.minecraftforge.event.world.BlockEvent.BreakEvent event;

		public Break(net.minecraftforge.event.world.BlockEvent.BreakEvent event) {
			this.event = event;
		}

		public WrappedPlayer getPlayer() {
			return new WrappedPlayer(event.getPlayer());
		}

		public int getXp() {
			return event.getExpToDrop();
		}

		@Override
		public int getX() {
			return event.x;
		}

		@Override
		public int getY() {
			return event.y;
		}

		@Override
		public int getZ() {
			return event.z;
		}

		@Override
		public WrappedWorld getWorld() {
			return new WrappedWorld(event.world);
		}

		@Override
		public WrappedBlock getBlock() {
			return new WrappedBlock(event.block);
		}

		@Override
		public int getMetadata() {
			return event.blockMetadata;
		}

		@Override
		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class Place extends BlockEvents {

		private net.minecraftforge.event.world.BlockEvent.PlaceEvent event;

		public Place(net.minecraftforge.event.world.BlockEvent.PlaceEvent event) {
			this.event = event;
		}

		public WrappedPlayer getPlayer() {
			return new WrappedPlayer(event.player);
		}

		public WrappedItemStack getHeldItem() {
			return new WrappedItemStack(event.itemInHand);
		}

		public WrappedBlock getPlacedBlock() {
			return new WrappedBlock(event.placedBlock);
		}

		public WrappedBlock getBlockPlacedAgainst() {
			return new WrappedBlock(event.placedAgainst);
		}

		@Override
		public int getX() {
			return event.x;
		}

		@Override
		public int getY() {
			return event.y;
		}

		@Override
		public int getZ() {
			return event.z;
		}

		@Override
		public WrappedWorld getWorld() {
			return new WrappedWorld(event.world);
		}

		@Override
		public WrappedBlock getBlock() {
			return new WrappedBlock(event.block);
		}

		@Override
		public int getMetadata() {
			return event.blockMetadata;
		}

		@Override
		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class HarvestDrops extends BlockEvents {
		private net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent event;

		public HarvestDrops(net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent event) {
			this.event = event;
		}

		public int getFortune() {
			return event.fortuneLevel;
		}

		private ArrayList<WrappedItemStack> drops;
		public ArrayList<WrappedItemStack> getDrops() {
			if (drops == null) {
				drops = new ArrayList<>();
				event.drops.stream().forEach(stack -> drops.add(new WrappedItemStack(stack)));
			}
			return drops;
		}

		public boolean isSilkTouch() {
			return event.isSilkTouching;
		}

		public float getDropChance() {
			return event.dropChance;
		}

		public WrappedPlayer getHarvester() {
			return new WrappedPlayer(event.harvester);
		}

		@Override
		public int getX() {
			return event.x;
		}

		@Override
		public int getY() {
			return event.y;
		}

		@Override
		public int getZ() {
			return event.z
					;
		}

		@Override
		public WrappedWorld getWorld() {
			return new WrappedWorld(event.world);
		}

		@Override
		public WrappedBlock getBlock() {
			return new WrappedBlock(event.block);
		}

		@Override
		public int getMetadata() {
			return event.blockMetadata;
		}

		@Override
		public void cancel() {

		}
	}

}
