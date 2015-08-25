package net.shadowfacts.shadowjs.js.event.wrapper;

import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.shadowfacts.shadowjs.js.player.WrappedPlayer;

/**
 * @author shadowfacts
 */
public abstract class ItemEvents {

	public abstract EntityItem getEntityItem();

	public abstract void cancel();

	public static class ItemThrownEvent extends ItemEvents {

		private ItemTossEvent event;

		public ItemThrownEvent(ItemTossEvent event) {
			this.event = event;
		}

		public WrappedPlayer getThrower() {
			return new WrappedPlayer(event.player);
		}

		@Override
		public EntityItem getEntityItem() {
			return event.entityItem;
		}

		@Override
		public void cancel() {
			event.setCanceled(true);
		}
	}

}
