package net.shadowfacts.shadowjs;

import net.shadowfacts.shadowmc.config.Config;
import net.shadowfacts.shadowmc.config.ConfigManager;
import net.shadowfacts.shadowmc.config.ConfigProperty;

import java.io.File;

/**
 * @author shadowfacts
 */
@Config(name = ShadowJS.modId)
public class SJSConfig {

	@ConfigProperty
	public static boolean enabled = true;

	public static void init(File configDir) {
		ConfigManager.instance.configDir = configDir;
		ConfigManager.instance.register(ShadowJS.modId, SJSConfig.class, ShadowJS.modId);
		ConfigManager.instance.load(ShadowJS.modId);
	}

}
