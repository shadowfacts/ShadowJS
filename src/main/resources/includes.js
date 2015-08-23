// ShadowJS
var ShadowJS = Java.type("net.shadowfacts.shadowjs.js.ShadowJSInterface");


// Minecraft
var Minecraft = Java.type("net.shadowfacts.shadowjs.js.MinecraftInterface");
var Blocks = Java.type("net.shadowfacts.shadowjs.js.block.Blocks");
var Items = Java.type("net.shadowfacts.shadowjs.js.item.Items");
var ItemStacks = Java.type("net.shadowfacts.shadowjs.js.itemstack.ItemStacks");
var CraftingManager = Java.type("net.shadowfacts.shadowjs.js.recipe.CraftingManager");
var OreDictionary = Java.type("net.shadowfacts.shadowjs.js.misc.OreDictionaryInterface");

// Mod Compat
var Mod = {
	isLoaded: function(modId) {
		return Java.type("cpw.mods.fml.common.Loader").isModLoaded(modId);
	}
};
if (Mod.isLoaded("NotEnoughItems"))	Mod.NotEnoughItems = Java.type("net.shadowfacts.shadowjs.js.mod.NEI");
//if (Mod.isLoaded("EnderIO"))		Mod.EnderIO = Java.type("net.shadowfacts.shadowjs.js.mod.EnderIO");
if (Mod.isLoaded("ThermalExpansion")) Mod.ThermalExpansion = Java.type("net.shadowfacts.shadowjs.js.mod.ThermalExpansion");