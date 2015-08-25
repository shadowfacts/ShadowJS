package net.shadowfacts.shadowjs.js.event.wrapper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

/**
 * @author shadowfacts
 */
public abstract class LivingEvent {

	public abstract EntityLivingBase getEntity();

	public static class EnderTeleport {

		private EnderTeleportEvent event;

		public EnderTeleport(EnderTeleportEvent event) {
			this.event = event;
		}

		public double getTargetX() {
			return event.targetX;
		}

		public double getTargetY() {
			return event.targetY;
		}

		public double getTargetZ() {
			return event.targetZ;
		}

		public float getAttackDamage() {
			return event.attackDamage;
		}

		public EnderTeleport setTargetX(int targetX) {
			event.targetX = targetX;
			return this;
		}

		public EnderTeleport setTargetY(int targetY) {
			event.targetY = targetY;
			return this;
		}

		public EnderTeleport setTargetZ(int targetZ) {
			event.targetZ = targetZ;
			return this;
		}

		public EnderTeleport setAttackDamage(int damage) {
			event.attackDamage = damage;
			return this;
		}

	}

}
