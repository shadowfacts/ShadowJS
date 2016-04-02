// ShadowJS
var ShadowJS = Java.type("net.shadowfacts.shadowjs.js.SJSInterface");

// Minecraft
var Blocks = Java.type("net.shadowfacts.shadowjs.js.Blocks");
var Items = Java.type("net.shadowfacts.shadowjs.js.Items");
var ItemStacks = Java.type("net.shadowfacts.shadowjs.js.ItemStacks");
var Crafting = Java.type("net.shadowfacts.shadowjs.js.Crafting");
var Furnace = Java.type("net.shadowfacts.shadowjs.js.Furnace");
var OreDictionary = Java.type("net.shadowfacts.shadowjs.js.OreDict");
var Minecraft = Java.type("net.shadowfacts.shadowjs.js.Game");

// Mod compat
var Mods = {
	isLoaded: Minecraft.isModLoaded
};
if (Mods.isLoaded("JEI")) Mods.JEI = Java.type("net.shadowfacts.shadowjs.js.mod.JEI");
if (Mods.isLoaded("Thaumcraft")) Mods.Thaumcraft = Java.type("net.shadowfacts.shadowjs.js.mod.thaumcraft.Thaumcraft");