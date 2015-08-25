package net.shadowfacts.shadowjs.js.event.wrapper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.*;

/**
 * @author shadowfacts
 */
public abstract class LivingEvents {

	public abstract EntityLivingBase getEntity();

	public static class EnderTeleport extends LivingEvents {

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

		@Override
		public EntityLivingBase getEntity() {
			return event.entityLiving;
		}
	}

	public static class Attack extends LivingEvents {

		private LivingAttackEvent event;

		public Attack(LivingAttackEvent event) {
			this.event = event;
		}

		public float getDamage() {
			return event.ammount;
		}

		@Override
		public EntityLivingBase getEntity() {
			return event.entityLiving;
		}

		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class Death extends LivingEvents {

		private LivingDeathEvent event;

		public Death(LivingDeathEvent event) {
			this.event = event;
		}

		@Override
		public EntityLivingBase getEntity() {
			return event.entityLiving;
		}

		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class Fall extends LivingEvents {

		private LivingFallEvent event;

		public Fall(LivingFallEvent event) {
			this.event = event;
		}

		public float getDistance() {
			return event.distance;
		}

		@Override
		public EntityLivingBase getEntity() {
			return event.entityLiving;
		}

		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class Hurt extends LivingEvents {

		private LivingHurtEvent event;

		public Hurt(LivingHurtEvent event) {
			this.event = event;
		}

		public float getDamage() {
			return event.ammount;
		}

		@Override
		public EntityLivingBase getEntity() {
			return event.entityLiving;
		}

		public void cancel() {
			event.setCanceled(true);
		}
	}

	public static class Jump extends LivingEvents {

		private LivingEvent.LivingJumpEvent event;

		public Jump(LivingEvent.LivingJumpEvent event) {
			this.event = event;
		}

		@Override
		public EntityLivingBase getEntity() {
			return event.entityLiving;
		}
	}

}
