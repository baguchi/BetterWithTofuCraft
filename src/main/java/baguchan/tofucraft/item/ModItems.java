package baguchan.tofucraft.item;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.util.IDUtils;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
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
	public static final Item tofuDiamondNugget = ItemHelper.createItem(TofuCraft.MOD_ID, new Item("Tofu Diamond Nugget", findOpenIds(IDUtils.getCurrItemId())), "tofu_diamond_nugget", "tofu_diamond_nugget.png");
	public static final Item tofugrilled = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemFoodStackable("Tofu Grilled", findOpenIds(IDUtils.getCurrItemId()), 2, false, 32), "tofugrilled", "tofugrilled.png");

	//misc
	public static final Item soymilk_bucket = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemBucket("Soymilk Bucket", findOpenIds(IDUtils.getCurrItemId()), ModBlocks.soymilk), "bucket_soymilk", "bucket_soymilk.png").setContainerItem(Item.bucket);
	public static final Item soybeans_seeds = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemSeeds("Soybeans Seeds", findOpenIds(IDUtils.getCurrItemId()), ModBlocks.soybean), "seeds_soybeans", "seeds_soybeans.png");
	public static final Item edamame = ItemHelper.createItem(TofuCraft.MOD_ID, new Item("Edamame", findOpenIds(IDUtils.getCurrItemId())), "edamame", "edamame.png");
	public static final Item boiled_edamame = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemFoodStackable("Boiled Edamame", findOpenIds(IDUtils.getCurrItemId()), 1, false, 16), "edamame_boiled", "edamame_boiled.png");
	public static final Item bittern_bucket = ItemHelper.createItem(TofuCraft.MOD_ID, new Item("Bittern Bucket", findOpenIds(IDUtils.getCurrItemId())), "bucket_bittern", "bucket_bittern.png").setMaxStackSize(1).setContainerItem(Item.bucket);
	public static final Item bittern_jar = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemBitternJar("Bittern Jar", findOpenIds(IDUtils.getCurrItemId())), "bittern_jar", "bittern_jar.png");


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
	public static final ArmorMaterial armor_tofu_diamond = ArmorHelper.createArmorMaterial("tofu_diamond", 1000, 70.0f, 70.0f, 70.0f, 100.0f);
	public static final Item armorHelmetTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Diamond Helmet", findOpenIds(IDUtils.getCurrItemId()), armor_tofu_diamond, 0), "tofu_diamond_helmet", "tofu_diamond_helmet.png");
	public static final Item armorChestplateTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Diamond Chestplate", findOpenIds(IDUtils.getCurrItemId()), armor_tofu_diamond, 1), "tofu_diamond_chestplate", "tofu_diamond_chestplate.png");
	public static final Item armorLeggingsTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Diamond Leggings", findOpenIds(IDUtils.getCurrItemId()), armor_tofu_diamond, 2), "tofu_diamond_leggings", "tofu_diamond_leggings.png");
	public static final Item armorBootsTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemArmor("Tofu Diamond Boots", findOpenIds(IDUtils.getCurrItemId()), armor_tofu_diamond, 3), "tofu_diamond_boots", "tofu_diamond_boots.png");
	public static final Item tofu_stick = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemTofuStick("Tofu Stick", findOpenIds(IDUtils.getCurrItemId())), "tofu_stick", "tofustick.png");
	//tool
	public static final ToolMaterial tool_kinu = new ToolMaterial().setDurability(1).setEfficiency(1.05f, 1.05f).setMiningLevel(0);

	public static final Item swordTofuKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolSword("Tofu Kinu Sword", findOpenIds(IDUtils.getCurrItemId()), tool_kinu), "tofu_kinu_sword", "tofu_kinu_sword.png");
	public static final Item pickaxeTofuKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolPickaxe("Tofu Kinu Pickaxe", findOpenIds(IDUtils.getCurrItemId()), tool_kinu), "tofu_kinu_pickaxe", "tofu_kinu_pickaxe.png");
	public static final Item axeTofuKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolAxe("Tofu Kinu Axe", findOpenIds(IDUtils.getCurrItemId()), tool_kinu), "tofu_kinu_axe", "tofu_kinu_axe.png");
	public static final Item shovelTofuKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolShovel("Tofu Kinu Shovel", findOpenIds(IDUtils.getCurrItemId()), tool_kinu), "tofu_kinu_shovel", "tofu_kinu_shovel.png");
	public static final Item hoeTofuKinu = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolHoe("Tofu Kinu Hoe", findOpenIds(IDUtils.getCurrItemId()), tool_kinu), "tofu_kinu_hoe", "tofu_kinu_hoe.png");


	public static final ToolMaterial tool_momen = new ToolMaterial().setDurability(1).setEfficiency(1.05f, 1.05f).setMiningLevel(0);

	public static final Item swordTofuMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolSword("Tofu Momen Sword", findOpenIds(IDUtils.getCurrItemId()), tool_momen), "tofu_momen_sword", "tofu_momen_sword.png");
	public static final Item pickaxeTofuMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolPickaxe("Tofu Momen Pickaxe", findOpenIds(IDUtils.getCurrItemId()), tool_momen), "tofu_momen_pickaxe", "tofu_momen_pickaxe.png");
	public static final Item axeTofuMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolAxe("Tofu Momen Axe", findOpenIds(IDUtils.getCurrItemId()), tool_momen), "tofu_momen_axe", "tofu_momen_axe.png");
	public static final Item shovelTofuMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolShovel("Tofu Momen Shovel", findOpenIds(IDUtils.getCurrItemId()), tool_momen), "tofu_momen_shovel", "tofu_momen_shovel.png");
	public static final Item hoeTofuMomen = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolHoe("Tofu Momen Hoe", findOpenIds(IDUtils.getCurrItemId()), tool_momen), "tofu_momen_hoe", "tofu_momen_hoe.png");

	public static final ToolMaterial tool_solid = new ToolMaterial().setDurability(120).setEfficiency(4.0f, 6.0f).setMiningLevel(1);

	public static final Item swordTofuSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolSword("Tofu Solid Sword", findOpenIds(IDUtils.getCurrItemId()), tool_solid), "tofu_solid_sword", "tofu_solid_sword.png");
	public static final Item pickaxeTofuSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolPickaxe("Tofu Solid Pickaxe", findOpenIds(IDUtils.getCurrItemId()), tool_solid), "tofu_solid_pickaxe", "tofu_solid_pickaxe.png");
	public static final Item axeTofuSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolAxe("Tofu Solid Axe", findOpenIds(IDUtils.getCurrItemId()), tool_solid), "tofu_solid_axe", "tofu_solid_axe.png");
	public static final Item shovelTofuSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolShovel("Tofu Solid Shovel", findOpenIds(IDUtils.getCurrItemId()), tool_solid), "tofu_solid_shovel", "tofu_solid_shovel.png");
	public static final Item hoeTofuSolid = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolHoe("Tofu Solid Hoe", findOpenIds(IDUtils.getCurrItemId()), tool_solid), "tofu_solid_hoe", "tofu_solid_hoe.png");

	public static final ToolMaterial tool_metal = new ToolMaterial().setDurability(250).setEfficiency(6.0f, 8.0f).setMiningLevel(2);

	public static final Item swordTofuMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolSword("Tofu Metal Sword", findOpenIds(IDUtils.getCurrItemId()), tool_metal), "tofu_metal_sword", "tofu_metal_sword.png");
	public static final Item pickaxeTofuMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolPickaxe("Tofu Metal Pickaxe", findOpenIds(IDUtils.getCurrItemId()), tool_metal), "tofu_metal_pickaxe", "tofu_metal_pickaxe.png");
	public static final Item axeTofuMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolAxe("Tofu Metal Axe", findOpenIds(IDUtils.getCurrItemId()), tool_metal), "tofu_metal_axe", "tofu_metal_axe.png");
	public static final Item shovelTofuMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolShovel("Tofu Metal Shovel", findOpenIds(IDUtils.getCurrItemId()), tool_metal), "tofu_metal_shovel", "tofu_metal_shovel.png");
	public static final Item hoeTofuMetal = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolHoe("Tofu Metal Hoe", findOpenIds(IDUtils.getCurrItemId()), tool_metal), "tofu_metal_hoe", "tofu_metal_hoe.png");

	public static final ToolMaterial tool_diamond = new ToolMaterial().setDurability(1324).setEfficiency(12.0f, 40.0f).setMiningLevel(3);

	public static final Item swordTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolSword("Tofu Diamond Sword", findOpenIds(IDUtils.getCurrItemId()), tool_diamond), "tofu_diamond_sword", "tofu_diamond_sword.png");
	public static final Item pickaxeTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolPickaxe("Tofu Diamond Pickaxe", findOpenIds(IDUtils.getCurrItemId()), tool_diamond), "tofu_diamond_pickaxe", "tofu_diamond_pickaxe.png");
	public static final Item axeTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolAxe("Tofu Diamond Axe", findOpenIds(IDUtils.getCurrItemId()), tool_diamond), "tofu_diamond_axe", "tofu_diamond_axe.png");
	public static final Item shovelTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolShovel("Tofu Diamond Shovel", findOpenIds(IDUtils.getCurrItemId()), tool_diamond), "tofu_diamond_shovel", "tofu_diamond_shovel.png");
	public static final Item hoeTofuDiamond = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemToolHoe("Tofu Diamond Hoe", findOpenIds(IDUtils.getCurrItemId()), tool_metal), "tofu_diamond_hoe", "tofu_diamond_hoe.png");
	//misc 2
	public static final Item salt = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemBitternJar("salt", findOpenIds(IDUtils.getCurrItemId())), "salt", "salt.png");
	public static final Item soystick = ItemHelper.createItem(TofuCraft.MOD_ID, new ItemFoodStackable("soystick", findOpenIds(IDUtils.getCurrItemId()), 3, false, 4), "soystick", "soystick.png");


	public static void createItems() {

	}
}
