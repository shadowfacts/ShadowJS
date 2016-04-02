package net.shadowfacts.shadowjs.util;

import net.shadowfacts.shadowjs.SJSConfig;
import net.shadowfacts.shadowjs.ShadowJS;
import sun.misc.Launcher;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shadowfacts
 */
public class NashornUtils {

	public static ScriptEngine engine;

	public static void init() {
		try {
			ClassLoader cl = Launcher.getLauncher().getClassLoader();
			Class<?> factoryClass = cl.loadClass("jdk.nashorn.api.scripting.NashornScriptEngineFactory");
			Class<?> filterClass = cl.loadClass("jdk.nashorn.api.scripting.ClassFilter");
			Class<?> sjsFilterClass = cl.loadClass("net.shadowfacts.shadowjs.SJSClassFilter");

			ScriptEngineFactory factory = (ScriptEngineFactory)factoryClass.getConstructor().newInstance();

			Method getScriptEngine = factory.getClass().getMethod("getScriptEngine", filterClass);

			Object filter = sjsFilterClass.newInstance();

			engine = (ScriptEngine)getScriptEngine.invoke(factory, filter);
		} catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException e) {
			ShadowJS.log.error("Couldn't start the Nashorn engine, disabling ShadowJS");
			SJSConfig.enabled = false;
			e.printStackTrace();
		}
	}

}
