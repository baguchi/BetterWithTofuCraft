package baguchan.tofucraft.crafting;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.item.ModItems;
import turniplabs.halplibe.helper.RecipeHelper;

public class ModCraftings {

	public static void register() {
		RecipeHelper.Crafting.createRecipe(ModBlocks.momen_tofu, 1, new Object[]{
			"TT",
			"TT",
			'T', ModItems.tofukinu});
		RecipeHelper.Crafting.createRecipe(ModBlocks.momen_tofu, 1, new Object[]{
			"TT",
			"TT",
			'T', ModItems.tofumomen});
		RecipeHelper.Crafting.createRecipe(ModBlocks.ishi_tofu, 1, new Object[]{
			"TT",
			"TT",
			'T', ModItems.tofuishi});
		RecipeHelper.Crafting.createRecipe(ModBlocks.metal_tofu, 1, new Object[]{
			"TT",
			"TT",
			'T', ModItems.tofumetal});

		//Armor
		RecipeHelper.Crafting.createRecipe(ModItems.armorHelmetKinu, 1, new Object[]{
			"TTT",
			"T T",
			'T', ModBlocks.kinu_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorChestplateKinu, 1, new Object[]{
			"T T",
			"TTT",
			"TTT",
			'T', ModBlocks.kinu_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorLeggingsKinu, 1, new Object[]{
			"TTT",
			"T T",
			"T T",
			'T', ModBlocks.kinu_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorBootsKinu, 1, new Object[]{
			"T T",
			"T T",
			'T', ModBlocks.kinu_tofu});


		RecipeHelper.Crafting.createRecipe(ModItems.armorHelmetMomen, 1, new Object[]{
			"TTT",
			"T T",
			'T', ModBlocks.momen_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorChestplateMomen, 1, new Object[]{
			"T T",
			"TTT",
			"TTT",
			'T', ModBlocks.momen_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorLeggingsMomen, 1, new Object[]{
			"TTT",
			"T T",
			"T T",
			'T', ModBlocks.momen_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorBootsMomen, 1, new Object[]{
			"T T",
			"T T",
			'T', ModBlocks.momen_tofu});


		RecipeHelper.Crafting.createRecipe(ModItems.armorHelmetSolid, 1, new Object[]{
			"TTT",
			"T T",
			'T', ModBlocks.ishi_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorChestplateSolid, 1, new Object[]{
			"T T",
			"TTT",
			"TTT",
			'T', ModBlocks.ishi_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorLeggingsSolid, 1, new Object[]{
			"TTT",
			"T T",
			"T T",
			'T', ModBlocks.ishi_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorBootsSolid, 1, new Object[]{
			"T T",
			"T T",
			'T', ModBlocks.ishi_tofu});


		RecipeHelper.Crafting.createRecipe(ModItems.armorHelmetMetal, 1, new Object[]{
			"TTT",
			"T T",
			'T', ModBlocks.metal_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorChestplateMetal, 1, new Object[]{
			"T T",
			"TTT",
			"TTT",
			'T', ModBlocks.metal_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorLeggingsMetal, 1, new Object[]{
			"TTT",
			"T T",
			"T T",
			'T', ModBlocks.metal_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorBootsMetal, 1, new Object[]{
			"T T",
			"T T",
			'T', ModBlocks.metal_tofu});


		RecipeHelper.Crafting.createRecipe(ModItems.armorHelmetTofuDiamond, 1, new Object[]{
			"TTT",
			"T T",
			'T', ModBlocks.diamond_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorChestplateTofuDiamond, 1, new Object[]{
			"T T",
			"TTT",
			"TTT",
			'T', ModBlocks.diamond_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorLeggingsTofuDiamond, 1, new Object[]{
			"TTT",
			"T T",
			"T T",
			'T', ModBlocks.diamond_tofu});
		RecipeHelper.Crafting.createRecipe(ModItems.armorBootsTofuDiamond, 1, new Object[]{
			"T T",
			"T T",
			'T', ModBlocks.diamond_tofu});
	}
}
