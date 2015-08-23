package net.shadowfacts.shadowjs.js;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ICrashCallable;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;

/**
 * @author shadowfacts
 */
public class MinecraftInterface {

	public static Side getSide() {
		return FMLCommonHandler.instance().getSide();
	}

	public static void addCrashReportMessage(String label, String msg) {
		FMLCommonHandler.instance().registerCrashCallable(new ICrashCallable() {
			@Override
			public String getLabel() {
				return label;
			}

			@Override
			public String call() throws Exception {
				return msg;
			}
		});
	}

	public static boolean isModLoaded(String id) {
		return Loader.isModLoaded(id);
	}

}
