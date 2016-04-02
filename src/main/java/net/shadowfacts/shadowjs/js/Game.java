package net.shadowfacts.shadowjs.js;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ICrashCallable;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author shadowfacts
 */
public class Game {

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
