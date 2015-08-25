package net.shadowfacts.shadowjs.js.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import net.shadowfacts.shadowjs.ShadowJS;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author shadowfacts
 */
public class JSEventRegistry {

	private static JSEventRegistry instance = new JSEventRegistry();

	public static JSEventRegistry getInstance() {
		return instance;
	}

	private static HashMap<Class, Events> classEventsHashMap = new HashMap<>();

	private static HashMap<Class, ArrayList<ScriptObjectMirror>> handlers = new HashMap<>();

	static void registerEvent(Class eventClass, Events event) {
		classEventsHashMap.put(eventClass, event);
	}

	static void registerEvent(Events event) {
		registerEvent(event.forgeEventClass, event);
	}

	private static void registerHandler(Class eventClass, ScriptObjectMirror handler) {
		if (handler.isFunction()) {
			if (handlers.get(eventClass) == null) {
				handlers.put(eventClass, new ArrayList<>());
			}
			handlers.get(eventClass).add(handler);
			ShadowJS.log.info("Registered handler for event: " + eventClass.getName());
		} else {
			throw new IllegalArgumentException("Cannot register a non-function event handler");
		}
	}

	public static void registerHandler(Events event, ScriptObjectMirror handler) {
		registerHandler(event.forgeEventClass, handler);
	}

	@SubscribeEvent
	public void handleEvent(Event event) {
		Events events = classEventsHashMap.get(event.getClass());
		if (events != null) {
			try {
				Object jsEvent = events.jsEventClass.getConstructor(event.getClass()).newInstance(event);
				ArrayList<ScriptObjectMirror> handlers = JSEventRegistry.handlers.get(event.getClass());
				if (handlers != null) {
					handlers.stream().forEach(handler -> handler.call(null, jsEvent));
				}
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			}
		}
	}

}
