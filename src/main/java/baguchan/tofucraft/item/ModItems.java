package baguchan.tofucraft.item;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.util.IDUtils;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

import static turniplabs.halplibe.helper.ItemHelper.findOpenIds;

public class ModItems {
	//tofu
	public static final Item tofukinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemFoodStackable("Tofu Kinu", findOpenIds(IDUtils.getCurrItemId()), 1, false, 32), "tofukinu", "tofukinu.png");
	public static final Item tofumomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemFoodStackable("Tofu Momen", findOpenIds(IDUtils.getCurrItemId()), 2, false, 32), "tofumomen", "tofumomen.png");
	public static final Item tofuishi = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemFoodStackable("Tofu Ishi", findOpenIds(IDUtils.getCurrItemId()), 2, false, 32), "tofuishi", "tofuishi.png");
	public static final Item tofumetal = ItemHelper.createItem(TofuCraft.MOD_ID, new Item("Tofu Metal", findOpenIds(IDUtils.getCurrItemId())), "tofumetal", "tofumetal.png");
	public static final Item tofudiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new Item("Tofu Diamond", findOpenIds(IDUtils.getCurrItemId())), "tofudiamond", "tofudiamond.png");
	//misc
	public static final Item soymilk_bucket = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemBucket("Soymilk Bucket", findOpenIds(IDUtils.getCurrItemId()), ModBlocks.soymilk), "bucket_soymilk", "bucket_soymilk.png").setContainerItem(Item.bucket);
	public static final Item soybeans_seeds = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemSeeds("Soybeans Seeds", findOpenIds(IDUtils.getCurrItemId()), ModBlocks.soybean), "seeds_soybeans", "seeds_soybeans.png");


	//armor
	public static final ArmorMaterial armor_kinu = ArmorHelper.createArmorMaterial("tofu_kinu", 1, 0.0f, 0.0f, 0.0f, 15.0f);
	public static final Item armorHelmetKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Kinu Helmet", findOpenIds(IDUtils.getCurrItemId()), armor_kinu, 0), "tofu_kinu_helmet", "tofu_kinu_helmet.png");
	public static final Item armorChestplateKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Kinu Chestplate", findOpenIds(IDUtils.getCurrItemId()), armor_kinu, 1), "tofu_kinu_chestplate", "tofu_kinu_chestplate.png");
	public static final Item armorLeggingsKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Kinu Leggings", findOpenIds(IDUtils.getCurrItemId()), armor_kinu, 2), "tofu_kinu_leggings", "tofu_kinu_leggings.png");
	public static final Item armorBootsKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Kinu Boots", findOpenIds(IDUtils.getCurrItemId()), armor_kinu, 3), "tofu_kinu_boots", "tofu_kinu_boots.png");


	public static final ArmorMaterial armor_momen = ArmorHelper.createArmorMaterial("tofu_momen", 1, 0.0f, 0.0f, 0.0f, 15.0f);
	public static final Item armorHelmetMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Momen Helmet", findOpenIds(IDUtils.getCurrItemId()), armor_momen, 0), "tofu_momen_helmet", "tofu_momen_helmet.png");
	public static final Item armorChestplateMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Momen Chestplate", findOpenIds(IDUtils.getCurrItemId()), armor_momen, 1), "tofu_momen_chestplate", "tofu_momen_chestplate.png");
	public static final Item armorLeggingsMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Momen Leggings", findOpenIds(IDUtils.getCurrItemId()), armor_momen, 2), "tofu_momen_leggings", "tofu_momen_leggings.png");
	public static final Item armorBootsMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Momen Boots", findOpenIds(IDUtils.getCurrItemId()), armor_momen, 3), "tofu_momen_boots", "tofu_momen_boots.png");

	public static final ArmorMaterial armor_solid = ArmorHelper.createArmorMaterial("tofu_solid", 120, 30.0f, 30.0f, 25.0f, 30.0f);
	public static final Item armorHelmetSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Solid Helmet", findOpenIds(IDUtils.getCurrItemId()), armor_solid, 0), "tofu_solid_helmet", "tofu_solid_helmet.png");
	public static final Item armorChestplateSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Solid Chestplate", findOpenIds(IDUtils.getCurrItemId()), armor_solid, 1), "tofu_solid_chestplate", "tofu_solid_chestplate.png");
	public static final Item armorLeggingsSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Solid Leggings", findOpenIds(IDUtils.getCurrItemId()), armor_solid, 2), "tofu_solid_leggings", "tofu_solid_leggings.png");
	public static final Item armorBootsSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Ishi Boots", findOpenIds(IDUtils.getCurrItemId()), armor_solid, 3), "tofu_solid_boots", "tofu_solid_boots.png");

	public static final ArmorMaterial armor_metal = ArmorHelper.createArmorMaterial("tofu_metal", 190, 42.5f, 42.5f, 42.5f, 42.5f);
	public static final Item armorHelmetMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Metal Helmet", findOpenIds(IDUtils.getCurrItemId()), armor_metal, 0), "tofu_metal_helmet", "tofu_metal_helmet.png");
	public static final Item armorChestplateMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Metal Chestplate", findOpenIds(IDUtils.getCurrItemId()), armor_metal, 1), "tofu_metal_chestplate", "tofu_metal_chestplate.png");
	public static final Item armorLeggingsMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Metal Leggings", findOpenIds(IDUtils.getCurrItemId()), armor_metal, 2), "tofu_metal_leggings", "tofu_metal_leggings.png");
	public static final Item armorBootsMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Metal Boots", findOpenIds(IDUtils.getCurrItemId()), armor_metal, 3), "tofu_metal_boots", "tofu_metal_boots.png");


	public static void createItems() {

	}
}
