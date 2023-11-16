package baguchan.tofucraft.block;

import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockWildSoybeans extends BlockFlower {
	public BlockWildSoybeans(String key, int id) {
		super(key, id);
		float f = 0.5f;
		this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.25f, 0.5f + f);
	}

	@Override
	public boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.grass.id || i == Block.dirt.id;
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(ModItems.soybeans_seeds, world.rand.nextInt(3) + 2)};
	}
}
