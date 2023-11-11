package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.block.tofu.BlockIshiTofu;
import baguchan.tofucraft.block.tofu.BlockKinuTofu;
import baguchan.tofucraft.block.tofu.BlockMetalTofu;
import baguchan.tofucraft.block.tofu.BlockMomenTofu;
import baguchan.tofucraft.util.IDUtils;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFluidFlowing;
import net.minecraft.core.block.BlockFluidStill;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlock;
import turniplabs.halplibe.helper.BlockBuilder;

import static turniplabs.halplibe.helper.BlockHelper.findOpenIds;

public class ModBlocks {
	public static final Block kinu_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.35f)
		.setTextures("blocktofukinu.png")
		.setHardness(0.3f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.FENCES_CONNECT, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.build(new BlockKinuTofu("kinu_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.cake));
	public static final Block momen_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.5f)
		.setTextures("blocktofumomen.png")
		.setHardness(0.45f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.FENCES_CONNECT, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.build(new BlockMomenTofu("momen_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.cake));
	public static final Block ishi_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(5.0f)
		.setTextures("blocktofuishi.png")
		.setHardness(1.25f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.FENCES_CONNECT)
		.setBlockSound(BlockSounds.STONE)
		.build(new BlockIshiTofu("ishi_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.stone));
	public static final Block metal_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(9.0f)
		.setTextures("blocktofumetal.png")
		.setHardness(4.0f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.FENCES_CONNECT)
		.setBlockSound(BlockSounds.METAL)
		.build(new BlockMetalTofu("metal_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.metal));

	//fluid
	public static final Block soymilk = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("soymilk.png")
		.setHardness(100.0f)
		.setTags(BlockTags.IS_WATER, BlockTags.PLACE_OVERWRITES, BlockTags.NOT_IN_CREATIVE_MENU)
		.build(new BlockFluidFlowing("soymilk", findOpenIds(IDUtils.getCurrBlockId()), Material.water).withLightOpacity(3).withDisabledStats().withDisabledNeighborNotifyOnMetadataChange());
	public static final Block soymilk_flow = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("soymilk_flow.png")
		.setHardness(100.0f)
		.setTags(BlockTags.IS_WATER, BlockTags.PLACE_OVERWRITES, BlockTags.NOT_IN_CREATIVE_MENU)
		.build(new BlockFluidStill("soymilk_flow", findOpenIds(IDUtils.getCurrBlockId()), Material.water).withLightOpacity(3).withDisabledStats().withDisabledNeighborNotifyOnMetadataChange());
	public static final Block soybean = new BlockBuilder(TofuCraft.MOD_ID)
		.setTextures("soybean.png")
		.setBlockSound(BlockSounds.GRASS)
		.build(new BlockSoybeans("soybean", findOpenIds(IDUtils.getCurrBlockId())).withHardness(0.0f).withDisabledStats().withDisabledNeighborNotifyOnMetadataChange().withTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU));


	public static void createBlocks() {

	}

	static {
		Item.itemsList[kinu_tofu.id] = new ItemBlock(kinu_tofu);
		Item.itemsList[momen_tofu.id] = new ItemBlock(momen_tofu);
		Item.itemsList[ishi_tofu.id] = new ItemBlock(ishi_tofu);
		Item.itemsList[metal_tofu.id] = new ItemBlock(metal_tofu);
	}

}
