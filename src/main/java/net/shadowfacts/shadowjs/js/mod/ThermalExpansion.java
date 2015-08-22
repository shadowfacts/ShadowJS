package net.shadowfacts.shadowjs.js.mod;

import cofh.api.modhelpers.ThermalExpansionHelper;
import net.shadowfacts.shadowjs.api.item.Ingredient;

/**
 * @author shadowfacts
 */
public class ThermalExpansion {

//	Redstone Furnace
	public static void addFurnaceRecipe(Ingredient input, Ingredient output, int energy) {
		ThermalExpansionHelper.addFurnaceRecipe(energy, input.getItemStack(), output.getItemStack());
	}

	public static void removeFurnaceRecipe(Ingredient input) {
		ThermalExpansionHelper.removeFurnaceRecipe(input.getItemStack());
	}

//	Pulverizer
	public static void addPulverizerRecipe(Ingredient input, Ingredient primaryOutput, Ingredient secondaryOutput, int secondaryChance, int energy) {
		ThermalExpansionHelper.addPulverizerRecipe(energy, input.getItemStack(), primaryOutput.getItemStack(), secondaryOutput.getItemStack(), secondaryChance);
	}

	public static void addPulverizerRecipe(Ingredient input, Ingredient primaryOutput, Ingredient secondaryOutput, int energy) {
		ThermalExpansionHelper.addPulverizerRecipe(energy, input.getItemStack(), primaryOutput.getItemStack(), secondaryOutput.getItemStack());
	}

	public static void addPulverizerRecipe(Ingredient input, Ingredient output, int energy) {
		ThermalExpansionHelper.addPulverizerRecipe(energy, input.getItemStack(), output.getItemStack());
	}

	public static void removePulverizerRecipe(Ingredient input) {
		ThermalExpansionHelper.removePulverizerRecipe(input.getItemStack());
	}

//	Sawmill
	public static void addSawmillRecipe(Ingredient input, Ingredient primaryOutput, Ingredient secondaryOutput, int secondaryChance, int energy) {
		ThermalExpansionHelper.addSawmillRecipe(energy, input.getItemStack(), primaryOutput.getItemStack(), secondaryOutput.getItemStack(), secondaryChance);
	}

	public static void addSawmillRecipe(Ingredient input, Ingredient primaryOutput, Ingredient secondaryOutput, int energy) {
		ThermalExpansionHelper.addSawmillRecipe(energy, input.getItemStack(), primaryOutput.getItemStack(), secondaryOutput.getItemStack());
	}

	public static void addSawmillRecipe(Ingredient input, Ingredient output, int energy) {
		ThermalExpansionHelper.addSawmillRecipe(energy, input.getItemStack(), output.getItemStack());
	}

	public static void removeSawmillRecipe(Ingredient input) {
		ThermalExpansionHelper.removeSawmillRecipe(input.getItemStack());
	}

//	Induction Smelter
	public static void addInductionSmelterRecipe(Ingredient primaryInput, Ingredient secondaryInput, Ingredient output, int energy) {
		ThermalExpansionHelper.addSmelterRecipe(energy, primaryInput.getItemStack(), secondaryInput.getItemStack(), output.getItemStack());
	}

	public static void addInductionSmelterRecipe(Ingredient primaryInput, Ingredient secondaryInput,
												 Ingredient primaryOutput, Ingredient secondaryOutput,
												 int energy) {
		ThermalExpansionHelper.addSmelterRecipe(energy, primaryInput.getItemStack(), secondaryInput.getItemStack(),
														primaryOutput.getItemStack(), secondaryOutput.getItemStack());
	}

	public static void addInductionSmelterRecipe(Ingredient primaryInput, Ingredient secondaryInput,
												 Ingredient primaryOutput, Ingredient secondaryOutput,
												 int secondaryChance, int energy) {
		ThermalExpansionHelper.addSmelterRecipe(energy, primaryInput.getItemStack(), secondaryInput.getItemStack(),
														primaryOutput.getItemStack(), secondaryOutput.getItemStack(), secondaryChance);
	}

	public static void removeInductionSmelterRecipe(Ingredient primaryInput, Ingredient secondaryInput) {
		ThermalExpansionHelper.removeSmelterRecipe(primaryInput.getItemStack(), secondaryInput.getItemStack());
	}

//	Energetic Infuser
	public static void addEnergeticInfuserRecipe(Ingredient input, Ingredient output, int energy) {
		ThermalExpansionHelper.addChargerRecipe(energy, input.getItemStack(), output.getItemStack());
	}

	public static void removeEnergeticInfuserRecipe(Ingredient input) {
		ThermalExpansionHelper.removeChargerRecipe(input.getItemStack());
	}

//	Phytogenic Insolator
	public static void addInsolatorRecipe(Ingredient primaryInput, Ingredient secondaryInput,
										  Ingredient primaryOutput, Ingredient secondaryOutput,
										  int secondaryChance, int energy) {
		ThermalExpansionHelper.addInsolatorRecipe(energy, primaryInput.getItemStack(), secondaryInput.getItemStack(),
				primaryOutput.getItemStack(), secondaryOutput.getItemStack(),
				secondaryChance);
	}

	public static void addInsolatorRecipe(Ingredient primaryInput, Ingredient secondaryInput,
										  Ingredient primaryOutput, Ingredient secondaryOutput,
										  int energy) {
		ThermalExpansionHelper.addInsolatorRecipe(energy, primaryInput.getItemStack(), secondaryInput.getItemStack(),
															primaryOutput.getItemStack(), secondaryOutput.getItemStack());
	}

	public static void addInsolatorRecipe(Ingredient primaryInput, Ingredient secondaryInput,
										  Ingredient primaryOutput, int energy) {
		ThermalExpansionHelper.addInsolatorRecipe(energy, primaryInput.getItemStack(), secondaryInput.getItemStack(),
															primaryOutput.getItemStack());
	}

//	Dynamos
//	Magmatic Dynamo
	public static void addMagmaticFuel(String fluidName, int energy) {
		ThermalExpansionHelper.addMagmaticFuel(fluidName, energy);
	}

//	Compression Dynamo
	public  static void addCompressionFuel(String fluidName, int energy) {
		ThermalExpansionHelper.addMagmaticFuel(fluidName, energy);
	}

//	Reactant Dynamo
	public static void addReactantFuel(String fluidName, int energy) {
		ThermalExpansionHelper.addReactantFuel(fluidName, energy);
	}

//	Coolants
	public static void addCoolant(String fluidName, int energy) {
		ThermalExpansionHelper.addCoolant(fluidName, energy);
	}

}
