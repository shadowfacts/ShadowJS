package net.shadowfacts.shadowjs.js.event.wrapper;

import net.minecraftforge.event.world.ExplosionEvent;
import net.shadowfacts.shadowjs.js.world.WrappedWorld;

/**
 * @author shadowfacts
 */
public abstract class ExplosionEvents {

	public abstract WrappedWorld getWorld();

	public static class Start extends ExplosionEvents {

		private ExplosionEvent.Start event;

		public Start(ExplosionEvent.Start event) {
			this.event = event;
		}

		@Override
		public WrappedWorld getWorld() {
			return new WrappedWorld(event.world);
		}

		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class Detonate extends ExplosionEvents {

		private ExplosionEvent.Detonate event;

		public Detonate(ExplosionEvent.Detonate event) {
			this.event = event;
		}

		@Override
		public WrappedWorld getWorld() {
			return new WrappedWorld(event.world);
		}
	}


}
