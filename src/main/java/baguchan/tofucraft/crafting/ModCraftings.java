package baguchan.tofucraft.crafting;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ModCraftings implements RecipeEntrypoint {
	public static final RecipeNamespace TOFUCRAFT = new RecipeNamespace();
	public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));

	@Override
	public void onRecipesReady() {
		TOFUCRAFT.register("workbench", WORKBENCH);
		Registries.RECIPES.register("tofucraft", TOFUCRAFT);
		DataLoader.loadRecipesFromFile("/assets/tofucraft/recipes/workbench.json");
		DataLoader.loadRecipesFromFile("/assets/tofucraft/recipes/armor.json");
		DataLoader.loadRecipesFromFile("/assets/tofucraft/recipes/tools.json");
		RecipeBuilder.Furnace(TofuCraft.MOD_ID).setInput(new ItemStack(ModItems.tofukinu)).create("cooked_grilled_tofu_from_kinu", new ItemStack(ModItems.tofugrilled));
		RecipeBuilder.Furnace(TofuCraft.MOD_ID).setInput(new ItemStack(ModItems.tofumomen)).create("cooked_grilled_tofu_from_momen", new ItemStack(ModItems.tofugrilled));
		RecipeBuilder.Furnace(TofuCraft.MOD_ID).setInput(new ItemStack(ModBlocks.kinu_tofu)).create("cooked_grilled_tofu_from_kinu_block", new ItemStack(ModBlocks.grilled_tofu));
		RecipeBuilder.Furnace(TofuCraft.MOD_ID).setInput(new ItemStack(ModBlocks.momen_tofu)).create("cooked_grilled_tofu_from_momen_block", new ItemStack(ModBlocks.grilled_tofu));
		RecipeBuilder.Furnace(TofuCraft.MOD_ID).setInput(new ItemStack(ModItems.edamame)).create("cooked_edamame", new ItemStack(ModItems.edamame));
		RecipeBuilder.Shapeless(TofuCraft.MOD_ID).addInput(new ItemStack(ModItems.salt)).addInput(new ItemStack(ModItems.soybeans_seeds)).addInput(new ItemStack(Item.wheat)).create("soy_stick", new ItemStack(ModItems.soystick));
	}

	@Override
	public void initNamespaces() {

	}
}
