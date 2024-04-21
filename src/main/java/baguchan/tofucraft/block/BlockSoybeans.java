package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockCropsWheat;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

import java.util.Random;

public class BlockSoybeans extends BlockFlower implements IBonemealable {
	int[] stage0 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_0.png");
	int[] stage1 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_1.png");
	int[] stage2 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_2.png");
	int[] stage3 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_3.png");
	int[] stage4 = TextureHelper.getOrCreateBlockTexture(TofuCraft.MOD_ID, "soybean_4.png");

	public final int[] growthStageTextures = new int[]{texCoordToIndex(stage0[0], stage0[1]), texCoordToIndex(stage1[0], stage1[1]), texCoordToIndex(stage2[0], stage2[1]), texCoordToIndex(stage3[0], stage3[1]), texCoordToIndex(stage4[0], stage4[1])};


	public BlockSoybeans(String key, int id) {
		super(key, id);
		this.setTicking(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	}

	public boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.farmlandDirt.id;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		if (world.getBlockLightValue(x, y + 1, z) >= 9) {
			int l = world.getBlockMetadata(x, y, z);
			if (l < 7) {
				float f = this.getGrowthRate(world, x, y, z);
				if (rand.nextInt((int) (100.0F / f)) == 0) {
					++l;
					world.setBlockMetadataWithNotify(x, y, z, l);
				}
			}
		}

	}

	public void fertilize(World world, int i, int j, int k) {
		world.setBlockMetadataWithNotify(i, j, k, 7);
	}

	private float getGrowthRate(World world, int x, int y, int z) {
		float growthRate = 1.0F;
		int idNegZ = world.getBlockId(x, y, z - 1);
		int idPosZ = world.getBlockId(x, y, z + 1);
		int idNegX = world.getBlockId(x - 1, y, z);
		int idPosX = world.getBlockId(x + 1, y, z);
		int idNegXNegZ = world.getBlockId(x - 1, y, z - 1);
		int idPosXNegZ = world.getBlockId(x + 1, y, z - 1);
		int idPosXPosZ = world.getBlockId(x + 1, y, z + 1);
		int idNegXPosZ = world.getBlockId(x - 1, y, z + 1);
		boolean xNeighbor = idNegX == this.id || idPosX == this.id;
		boolean zNeighbor = idNegZ == this.id || idPosZ == this.id;
		boolean diagNeighbor = idNegXNegZ == this.id || idPosXNegZ == this.id || idPosXPosZ == this.id || idNegXPosZ == this.id;

		for (int dx = x - 1; dx <= x + 1; ++dx) {
			for (int dz = z - 1; dz <= z + 1; ++dz) {
				int id = world.getBlockId(dx, y - 1, dz);
				float growthRateMod = 0.0F;
				if (id == Block.farmlandDirt.id) {
					growthRateMod = 1.0F;
					if (world.getBlockMetadata(dx, y - 1, dz) > 0) {
						growthRateMod = 3.0F;
					}
				}

				if (dx != x || dz != z) {
					growthRateMod /= 4.0F;
				}

				growthRate += growthRateMod;
			}
		}

		if (diagNeighbor || xNeighbor && zNeighbor) {
			growthRate /= 2.0F;
		}

		if (world.seasonManager.getCurrentSeason() != null) {
			growthRate *= world.seasonManager.getCurrentSeason().cropGrowthFactor;
		}

		return growthRate;
	}

	public int getBlockTextureFromSideAndMetadata(Side side, int data) {
		if (data < 0 || data > 7) {
			data = 7;
		}

		return this.growthStageTextures[data];
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return meta != 7 ? new ItemStack[]{new ItemStack(Item.seedsWheat)} : new ItemStack[]{new ItemStack(Item.seedsWheat, world.rand.nextInt(3) + 1), new ItemStack(Item.wheat)};
	}

	public boolean onBonemealUsed(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (world.getBlockMetadata(blockX, blockY, blockZ) < 7) {
			if (!world.isClientSide) {
				((BlockCropsWheat) Block.cropsWheat).fertilize(world, blockX, blockY, blockZ);
				if (entityplayer.getGamemode().consumeBlocks()) {
					--itemstack.stackSize;
				}
			}

			return true;
		} else {
			return false;
		}
	}
}
