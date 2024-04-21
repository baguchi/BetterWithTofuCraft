package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.block.tofu.*;
import baguchan.tofucraft.util.IDUtils;
import net.minecraft.client.render.block.color.BlockColorWater;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockBedrock;
import net.minecraft.core.block.BlockPortal;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;

public class ModBlocks {
	public static final Block kinu_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.35f)
		.setTextures("blocktofukinu.png")
		.setHardness(0.3f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.setTickOnLoad()
		.build(new BlockKinuTofu("kinu_tofu", IDUtils.getCurrBlockId(), Material.cake));
	public static final Block momen_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.5f)
		.setTextures("blocktofumomen.png")
		.setHardness(0.45f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.setTickOnLoad()
		.build(new BlockMomenTofu("momen_tofu", IDUtils.getCurrBlockId(), Material.cake));
	public static final Block ishi_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(5.0f)
		.setTextures("blocktofuishi.png")
		.setHardness(1.25f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockSound(BlockSounds.STONE)
		.setTickOnLoad()
		.build(new BlockIshiTofu("ishi_tofu", IDUtils.getCurrBlockId(), Material.stone));
	public static final Block metal_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(9.0f)
		.setTextures("blocktofumetal.png")
		.setHardness(4.0f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockSound(BlockSounds.METAL)
		.build(new BlockMetalTofu("metal_tofu", IDUtils.getCurrBlockId(), Material.metal));
	public static final Block diamond_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(10.0f)
		.setTextures("blocktofudiamond.png")
		.setHardness(5.0f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockSound(BlockSounds.METAL)
		.build(new BlockDiamondTofu("diamond_tofu", IDUtils.getCurrBlockId(), Material.metal));
	public static final Block grilled_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.5f)
		.setTextures("blocktofugrilled.png")
		.setHardness(0.45f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.setTickOnLoad()
		.build(new BlockGrilledTofu("grilled_tofu", IDUtils.getCurrBlockId(), Material.cake));


	//fluid
	public static final Block soymilk_flow = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("soymilk_flow.png")
		.setHardness(100.0f)
		.setTags(BlockTags.IS_WATER, BlockTags.PLACE_OVERWRITES, BlockTags.NOT_IN_CREATIVE_MENU)
		.setVisualUpdateOnMetadata()
		.build(new BlockFluidSoyFlowing("soymilk_flow", IDUtils.getCurrBlockId(), Material.water).withLightBlock(3).withDisabledStats());
	public static final Block soymilk = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("soymilk.png")
		.setHardness(100.0f)
		.setVisualUpdateOnMetadata()
		.setTags(BlockTags.IS_WATER, BlockTags.PLACE_OVERWRITES, BlockTags.NOT_IN_CREATIVE_MENU)
		.build(new BlockFluidSoyStill("soymilk", IDUtils.getCurrBlockId(), Material.water).withLightBlock(3).withDisabledStats());
	public static final Block soybean = new BlockBuilder(TofuCraft.MOD_ID)
		.setHardness(0.0f)
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
		.setTickOnLoad()
		.build(new BlockSoybeans("soybean", IDUtils.getCurrBlockId()).withDisabledStats());
	public static final Block wild_soybean = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("soybean_4.png")
		.setHardness(0.0f)
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
		.setTickOnLoad()
		.build(new BlockWildSoybeans("wild_soybean", IDUtils.getCurrBlockId()).withDisabledStats());
	public static final Block tofu_portal = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("tofu_portal.png")
		.setBlockSound(BlockSounds.GLASS)
		.setHardness(-1)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU)
		.build(new BlockPortal("tofu_portal", IDUtils.getCurrBlockId(), TofuCraft.tofuWorldID, ModBlocks.grilled_tofu.id, ModBlocks.soymilk.id));
	public static final Block tofu_terrain = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.5f)
		.setTextures("tofu_terrain.png")
		.setHardness(0.5f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.CAVES_CUT_THROUGH)
		.setBlockSound(BlockSounds.CLOTH)
		.build(new Block("tofu_terrain", IDUtils.getCurrBlockId(), Material.cake));
	public static final Block tofu_bedrock = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(6000000.0f)
		.setTextures("tofu_bedrock.png")
		.setHardness(-1)
		.setBlockSound(BlockSounds.STONE)
		.build(new BlockBedrock("tofu_bedrock", IDUtils.getCurrBlockId(), Material.stone));
	public static final Block tofu_diamond_ore = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(1.5f)
		.setTextures("ore_tofu_diamond.png")
		.setHardness(1.0f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.setTickOnLoad()
		.build(new BlockDiamondTofuOre("tofu_diamond_ore", IDUtils.getCurrBlockId(), Material.cake));

	public static final Block saltpan = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(1.5F)
		.setHardness(0.6F)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(TofuCraft.MOD_ID, "block/saltpan.json")))
		.build(new BlockSaltpan("saltpan", IDUtils.getCurrBlockId(), Material.wood));
	public static final Block saltpan_water = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(1.5F)
		.setHardness(0.6F)
		.setTickOnLoad()
		.setBlockColor(new BlockColorWater())
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_AXE)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(TofuCraft.MOD_ID, "block/saltpan_water.json")))
		.build(new BlockSaltpan("saltpan_water", IDUtils.getCurrBlockId(), Material.wood));
	public static final Block saltpan_bittern = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(1.5F)
		.setHardness(0.6F)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_AXE)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(TofuCraft.MOD_ID, "block/saltpan_bittern.json")))
		.build(new BlockSaltpan("saltpan_bittern", IDUtils.getCurrBlockId(), Material.wood));
	public static final Block saltpan_salt = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(1.5F)
		.setHardness(0.6F)
		.setTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_AXE)
		.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(TofuCraft.MOD_ID, "block/saltpan_salt.json")))
		.build(new BlockSaltpan("saltpan_salt", IDUtils.getCurrBlockId(), Material.wood));
	public static final Block tofuishi_brick = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(5.0f)
		.setTextures("tofuishi_brick.png")
		.setHardness(1.25f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockSound(BlockSounds.STONE)
		.build(new Block("tofu_ishi_brick", IDUtils.getCurrBlockId(), Material.stone));
	public static final Block tofuishi_chiseled_brick = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(5.0f)
		.setTextures("tofuishi_chiseled_brick.png")
		.setHardness(1.25f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockSound(BlockSounds.STONE)
		.build(new Block("tofu_ishi_chiseled_brick", IDUtils.getCurrBlockId(), Material.stone));
	public static final Block tofuishi_smooth_brick = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(5.0f)
		.setTextures("tofuishi_smooth_brick.png")
		.setHardness(1.25f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.setBlockSound(BlockSounds.STONE)
		.build(new Block("tofu_ishi_smooth_brick", IDUtils.getCurrBlockId(), Material.stone));



	public static void createBlocks() {

	}

	static {
		Item.itemsList[kinu_tofu.id] = new ItemBlock(kinu_tofu);
		Item.itemsList[momen_tofu.id] = new ItemBlock(momen_tofu);
		Item.itemsList[ishi_tofu.id] = new ItemBlock(ishi_tofu);
		Item.itemsList[metal_tofu.id] = new ItemBlock(metal_tofu);
		Item.itemsList[diamond_tofu.id] = new ItemBlock(diamond_tofu);
		Item.itemsList[grilled_tofu.id] = new ItemBlock(grilled_tofu);
		ItemToolPickaxe.miningLevels.put(metal_tofu, 1);
		ItemToolPickaxe.miningLevels.put(diamond_tofu, 2);

		Item.itemsList[tofu_terrain.id] = new ItemBlock(tofu_terrain);
		Item.itemsList[tofu_bedrock.id] = new ItemBlock(tofu_bedrock);
		Item.itemsList[tofu_diamond_ore.id] = new ItemBlock(tofu_diamond_ore);
		Item.itemsList[saltpan.id] = new ItemBlock(saltpan);

		Item.itemsList[tofuishi_brick.id] = new ItemBlock(tofuishi_brick);
		Item.itemsList[tofuishi_chiseled_brick.id] = new ItemBlock(tofuishi_chiseled_brick);
		Item.itemsList[tofuishi_smooth_brick.id] = new ItemBlock(tofuishi_smooth_brick);
	}

}
