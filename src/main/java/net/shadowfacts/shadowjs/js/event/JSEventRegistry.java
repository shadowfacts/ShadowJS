package net.shadowfacts.shadowjs.js.event;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.shadowfacts.shadowjs.ShadowJS;

import javax.script.Invocable;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shadowfacts
 */
public class JSEventRegistry {

	private static JSEventRegistry instance = new JSEventRegistry();

	public static JSEventRegistry getInstance() {
		return instance;
	}

	private static HashMap<Class, Events> classEventsHashMap = new HashMap<>();

	private static HashMap<Class, List<String>> handlers = new HashMap<>();

	static void registerEvent(Class eventClass, Events event) {
		classEventsHashMap.put(eventClass, event);
	}

	static void registerEvent(Events event) {
		registerEvent(event.forgeEventClass, event);
	}

	private static void registerHandler(Class eventClass, String handler) {
		if (handlers.get(eventClass) == null) {
			handlers.put(eventClass, new ArrayList<>());
		}
		handlers.get(eventClass).add(handler);
		ShadowJS.log.info("Registered handler for event: " + eventClass.getName());
	}

	public static void registerHandler(Events event, String handler) {
		registerHandler(event.forgeEventClass, handler);
	}

	@SubscribeEvent
	public void handleEvent(Event event) {
		Events events = classEventsHashMap.get(event.getClass());
		if (events != null) {
			List<String> handlers = JSEventRegistry.handlers.get(event.getClass());
			if (handlers != null) {
				try {
					Object jsEvent = events.jsEventClass.getConstructor(event.getClass()).newInstance(event);
					Invocable invocable = (Invocable) ShadowJS.getInstance().getScriptEngine();
					handlers.stream().forEach(s -> {
						try {
							invocable.invokeFunction(s, jsEvent);
						} catch (ScriptException e) {
							ShadowJS.log.error(String.format("There was a problem invoking the JS event handler %s for event %s", s, event), e);
						} catch (NoSuchMethodException e) {
							ShadowJS.log.error(String.format("The JS event handler %s does not exist", s), e);
						}
					});
				} catch (ReflectiveOperationException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
