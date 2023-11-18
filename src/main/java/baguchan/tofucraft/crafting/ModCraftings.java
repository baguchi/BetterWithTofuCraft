package baguchan.tofucraft.crafting;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
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
		RecipeHelper.Crafting.createRecipe(ModBlocks.diamond_tofu, 1, new Object[]{
			"TT",
			"TT",
			'T', ModItems.tofudiamond});
		RecipeHelper.Crafting.createRecipe(ModItems.tofudiamond, 1, new Object[]{
			"TTT",
			"TTT",
			"TTT",
			'T', ModItems.tofuDiamondNugget});
		RecipeHelper.Crafting.createShapelessRecipe(new ItemStack(ModItems.tofuDiamondNugget, 9), new Object[]{ModItems.tofudiamond});

		RecipeHelper.Crafting.createRecipe(ModBlocks.grilled_tofu, 1, new Object[]{
			"TT",
			"TT",
			'T', ModItems.tofugrilled});

		RecipeHelper.Smelting.createRecipe(ModItems.tofugrilled, ModItems.tofukinu);
		RecipeHelper.Smelting.createRecipe(ModItems.tofugrilled, ModItems.tofumomen);
		RecipeHelper.Smelting.createRecipe(ModBlocks.grilled_tofu, ModBlocks.kinu_tofu);
		RecipeHelper.Smelting.createRecipe(ModBlocks.grilled_tofu, ModBlocks.momen_tofu);


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

		RecipeHelper.Smelting.createRecipe(ModItems.bittern_bucket, Item.bucketWater);
		RecipeHelper.Smelting.createRecipe(ModItems.boiled_edamame, ModItems.edamame);

		RecipeHelper.Crafting.createShapelessRecipe(new ItemStack(ModItems.bittern_jar, 3), new Object[]{Item.jar, Item.jar, Item.jar, ModItems.bittern_bucket});
	}
}
