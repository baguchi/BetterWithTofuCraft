package baguchan.tofucraft.block;

import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.BlockCrops;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockSoybeans extends BlockCrops {
	public BlockSoybeans(String key, int id) {
		super(key, id);
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int j) {
		if (j < 0 || j > 7) {
			j = 7;
		}
		return this.growthStageTextures[j];
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (meta != 7) {
			return new ItemStack[]{new ItemStack(ModItems.soybeans_seeds)};
		}
		return new ItemStack[]{new ItemStack(ModItems.soybeans_seeds, world.rand.nextInt(3) + 2)};
	}
}
