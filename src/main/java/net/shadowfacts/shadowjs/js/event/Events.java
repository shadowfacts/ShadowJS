package net.shadowfacts.shadowjs.js.event;

import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.shadowfacts.shadowjs.js.event.wrapper.BlockEvents;

/**
 * @author shadowfacts
 */
public enum Events {

	HarvestBlockDrops(BlockEvent.HarvestDropsEvent.class, BlockEvents.HarvestDrops.class),
	BreakBlock(BlockEvent.BreakEvent.class, BlockEvents.Break.class),
	PlaceBlock(BlockEvent.PlaceEvent.class, BlockEvents.Place.class);
//	ServerChatReceived(ServerChatEvent.class),
//	CommandExecuted(CommandEvent.class),
//	PrePotionBrew(PotionBrewEvent.Pre.class),
//	PostPotionBrew(PotionBrewEvent.Post.class),
//	ExplosionStart(ExplosionEvent.Start.class),
//	ExplosionDetonate(ExplosionEvent.Detonate.class);


	Class forgeEventClass;
	Class jsEventClass;

	Events(Class forgeEventClass, Class jsEventClass, boolean register) {
		this.forgeEventClass = forgeEventClass;
		this.jsEventClass = jsEventClass;

		if (register) {
			JSEventRegistry.registerEvent(this);
		}
	}

	Events(Class forgeEventClass, Class jsEventClass) {
		this(forgeEventClass, jsEventClass, true);
	}

}
