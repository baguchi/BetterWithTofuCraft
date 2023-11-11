package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.util.IDUtils;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlock;
import turniplabs.halplibe.helper.BlockBuilder;

public class ModBlocks {
	public static final Block kinu_tofu = new BlockBuilder(TofuCraft.MOD_ID)
		.setResistance(0.5f)
		.setTextures("blocktofukinu.png")
		.setHardness(0.35f)
		.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.FENCES_CONNECT, ModBlockTags.TOFU)
		.setBlockSound(BlockSounds.CLOTH)
		.build(new BlockKinuTofu("kinu_tofu", IDUtils.nextIdBlock(), Material.cake));

	public static void createBlocks() {

	}

	static {
		Item.itemsList[kinu_tofu.id] = new ItemBlock(kinu_tofu);
	}

}
