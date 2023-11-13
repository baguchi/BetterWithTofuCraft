package baguchan.tofucraft.block.tofu;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockMomenTofu extends BlockTofu {

	public BlockMomenTofu(String key, int id, Material material) {
		super(key, id, material);
		this.setTickOnLoad(true);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		if (rand.nextInt(3) == 0) {
			if (this.isUnderWeight(world, x, y, z)) {
				int meta = world.getBlockMetadata(x, y, z);
				if (meta >= 7) {
					world.setBlock(x, y, z, ModBlocks.ishi_tofu.id);
				} else {
					world.setBlockMetadata(x, y, z, meta + 1);
				}
			}
		}
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case SILK_TOUCH: {
				return new ItemStack[]{new ItemStack(this)};
			}
		}
		return new ItemStack[]{new ItemStack(ModItems.tofumomen, 4)};
	}

}
