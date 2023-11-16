package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockCrops;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

public class BlockSoybeans extends BlockCrops {
	int[] stage0 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_0.png");
	int[] stage1 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_1.png");
	int[] stage2 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_2.png");
	int[] stage3 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_3.png");
	int[] stage4 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_4.png");

	public final int[] growthStageTextures = new int[]{texCoordToIndex(stage0[0], stage0[1]), texCoordToIndex(stage1[0], stage1[1]), texCoordToIndex(stage2[0], stage2[1]), texCoordToIndex(stage3[0], stage3[1]), texCoordToIndex(stage4[0], stage4[1])};


	public BlockSoybeans(String key, int id) {
		super(key, id);
		this.setTickOnLoad(true);
	}

	@Override
	public boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.farmlandDirt.id;
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int j) {
		if (j < 5) {
			return this.growthStageTextures[j >> 1];
		} else if (j < 7) {
			return this.growthStageTextures[3];
		} else {
			return this.growthStageTextures[4];
		}
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (meta != 7) {
			return new ItemStack[]{new ItemStack(ModItems.soybeans_seeds)};
		}
		return new ItemStack[]{new ItemStack(ModItems.soybeans_seeds, world.rand.nextInt(3) + 2)};
	}
}
