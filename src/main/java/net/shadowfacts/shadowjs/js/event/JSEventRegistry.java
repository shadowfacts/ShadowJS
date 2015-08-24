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

	private static HashMap<Class, ArrayList<ScriptObjectMirror>> eventHandlerMap = new HashMap<>();

	private static void registerHandler(Class eventClass, ScriptObjectMirror handler) {
		if (handler.isFunction()) {
			if (eventHandlerMap.get(eventClass) == null) {
				eventHandlerMap.put(eventClass, new ArrayList<>());
			}
			eventHandlerMap.get(eventClass).add(handler);
			ShadowJS.log.info("Registered handler for event: " + eventClass.getName());
		} else {
			throw new IllegalArgumentException("Cannot register a non-function event handler");
		}
	}

	public static void registerHandler(Events event, ScriptObjectMirror handler) {
		registerHandler(event.eventClass, handler);
	}

	private JSEventRegistry() {
	}

	@SubscribeEvent
	public void handleEvent(Event event) {
		ArrayList<ScriptObjectMirror> handlers = eventHandlerMap.get(event.getClass());
		if (handlers != null) {
			handlers.stream().forEach(handler -> handler.call(null, event));
		}
	}

}
