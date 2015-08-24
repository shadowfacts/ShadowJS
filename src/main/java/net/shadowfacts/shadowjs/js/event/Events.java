package net.shadowfacts.shadowjs.js.event;

import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;

/**
 * @author shadowfacts
 */
public enum Events {

	HarvestBlockDrops(BlockEvent.HarvestDropsEvent.class),
	BreakBlock(BlockEvent.BreakEvent.class),
	PlaceBlock(BlockEvent.PlaceEvent.class),
	PlaceMultiBlock(BlockEvent.MultiPlaceEvent.class),
	ServerChatReceived(ServerChatEvent.class),
	CommandExecuted(CommandEvent.class),
	PrePotionBrew(PotionBrewEvent.Pre.class),
	PostPotionBrew(PotionBrewEvent.Post.class),
	ExplosionStart(ExplosionEvent.Start.class),
	ExplosionDetonate(ExplosionEvent.Detonate.class);


	Class eventClass;

	Events(Class eventClass) {
		this.eventClass = eventClass;
	}

}
