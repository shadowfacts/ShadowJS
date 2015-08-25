package net.shadowfacts.shadowjs.js.event;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.shadowfacts.shadowjs.js.event.wrapper.BlockEvents;
import net.shadowfacts.shadowjs.js.event.wrapper.ExplosionEvents;
import net.shadowfacts.shadowjs.js.event.wrapper.ItemEvents;
import net.shadowfacts.shadowjs.js.event.wrapper.ServerChatMessageReceived;

/**
 * @author shadowfacts
 */
public enum Events {

	HarvestBlockDrops(BlockEvent.HarvestDropsEvent.class, BlockEvents.HarvestDrops.class),
	BreakBlock(BlockEvent.BreakEvent.class, BlockEvents.Break.class),
	PlaceBlock(BlockEvent.PlaceEvent.class, BlockEvents.Place.class),
	ExplosionStart(ExplosionEvent.Start.class, ExplosionEvents.Start.class),
	ExplosionDetonate(ExplosionEvent.Detonate.class, ExplosionEvents.Detonate.class),
	ServerChatMessageReceived(ServerChatEvent.class, ServerChatMessageReceived.class),
	ItemThrown(ItemTossEvent.class, ItemEvents.ItemThrownEvent.class);


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
