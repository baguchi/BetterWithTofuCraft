package baguchan.tofucraft.block;

import baguchan.better_ai.api.IBlockPathGetter;
import baguchan.better_ai.util.BlockPath;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFluidStill;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockFluidSoyStill extends BlockFluidStill implements IBlockPathGetter {
	public BlockFluidSoyStill(String name, int openIds, Material soymilkMaterial) {
		super(name, openIds, soymilkMaterial);
	}


	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		this.checkForHarden(world, x, y, z);
		if (blockId == Side.TOP.getId()) {
			return;
		}
		int id = world.getBlockId(x, y, z);
		if (world.getBlockId(x, y, z) == this.id) {
			this.func_30004_j(world, x, y, z);
		}
	}

	private void func_30004_j(World world, int i, int j, int k) {
		int l = world.getBlockMetadata(i, j, k);
		world.editingBlocks = true;
		world.setBlockAndMetadata(i, j, k, ModBlocks.soymilk_flow.id, l);
		world.markBlocksDirty(i, j, k, i, j, k);
		world.scheduleBlockUpdate(i, j, k, ModBlocks.soymilk_flow.id, this.tickRate());
		world.editingBlocks = false;
	}

	private void checkForHarden(World world, int x, int y, int z) {
		int meta;
		boolean flag;
		if (world.getBlockId(x, y, z) != this.id) {
			return;
		}
		if (this.blockMaterial == Material.lava) {
			flag = false;
			if (flag || world.getBlockMaterial(x, y, z - 1) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x, y, z + 1) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x - 1, y, z) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x + 1, y, z) == Material.water) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x, y + 1, z) == Material.water) {
				flag = true;
			}
			if (flag) {
				meta = world.getBlockMetadata(x, y, z);
				if (meta == 0) {
					world.setBlockWithNotify(x, y, z, Block.obsidian.id);
				} else if (meta <= 2) {
					world.setBlockWithNotify(x, y, z, Block.cobbleGranite.id);
				} else if (meta <= 4) {
					world.setBlockWithNotify(x, y, z, Block.cobbleStone.id);
				} else {
					world.setBlockWithNotify(x, y, z, Block.cobbleBasalt.id);
				}
				this.fizz(world, x, y, z);
			}
		}
		if (this.blockMaterial == Material.water) {
			flag = false;
			if (flag || world.getBlockMaterial(x, y, z - 1) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x, y, z + 1) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x - 1, y, z) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x + 1, y, z) == Material.lava) {
				flag = true;
			}
			if (flag || world.getBlockMaterial(x, y + 1, z) == Material.lava) {
				flag = true;
			}
			if (flag && (meta = world.getBlockMetadata(x, y, z)) == 0) {
				world.setBlockWithNotify(x, y, z, Block.cobbleLimestone.id);
				this.fizz(world, x, y, z);
			}
		}
	}
	@Override
	public int tickRate() {
		return 5;
	}

	@Override
	public BlockPath getBlockPath() {
		return BlockPath.WATER;
	}
}
