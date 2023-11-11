package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.item.ModItems;
import baguchan.tofucraft.util.IDUtils;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
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
		.build(new BlockTofu("kinu_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.cake, ModItems.tofukinu));
	public static final Block momen_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.5f)
		.setTextures("blocktofumomen.png")
		.setHardness(0.45f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.FENCES_CONNECT, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.build(new BlockTofu("momen_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.cake, ModItems.tofumomen));
	public static final Block ishi_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(5.0f)
		.setTextures("blocktofuishi.png")
		.setHardness(1.25f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.FENCES_CONNECT)
		.setBlockSound(BlockSounds.STONE)
		.build(new BlockTofu("ishi_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.stone, ModItems.tofuishi));
	public static final Block metal_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(9.0f)
		.setTextures("blocktofumetal.png")
		.setHardness(4.0f)
		.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.FENCES_CONNECT)
		.setBlockSound(BlockSounds.METAL)
		.build(new BlockTofu("metal_tofu", findOpenIds(IDUtils.getCurrBlockId()), Material.metal, ModItems.tofumetal));


	public static void createBlocks() {

	}

	static {
		Item.itemsList[kinu_tofu.id] = new ItemBlock(kinu_tofu);
		Item.itemsList[momen_tofu.id] = new ItemBlock(momen_tofu);
		Item.itemsList[ishi_tofu.id] = new ItemBlock(ishi_tofu);
		Item.itemsList[metal_tofu.id] = new ItemBlock(metal_tofu);
	}

}
