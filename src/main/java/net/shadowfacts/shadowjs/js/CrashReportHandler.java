package net.shadowfacts.shadowjs.js;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ICrashCallable;

/**
 * @author shadowfacts
 */
public class CrashReportHandler {

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

}