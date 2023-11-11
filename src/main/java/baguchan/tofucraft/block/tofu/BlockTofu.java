package baguchan.tofucraft.block.tofu;

import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockTofu extends Block {
	public BlockTofu(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);
		if (isUnderWeight(world, x, y, z)) {
			if (this != ModBlocks.ishi_tofu) {
				if (rand.nextInt(4) == 0) {
					double d4 = rand.nextBoolean() ? 0.8 : -0.8;
					double d0 = ((float) x + 0.5 + (rand.nextFloat() * d4));
					double d1 = (double) ((float) y + rand.nextFloat());
					double d2 = ((float) z + 0.5 + rand.nextFloat() * d4);

					world.spawnParticle("splash", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			} else {
				if (rand.nextInt(10) == 0) {
					double d4 = rand.nextBoolean() ? 0.8 : -0.8;
					double d0 = ((float) x + 0.5 + (rand.nextFloat() * d4));
					double d1 = (double) ((float) y + rand.nextFloat());
					double d2 = ((float) z + 0.5 + rand.nextFloat() * d4);

					world.spawnParticle("splash", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	public boolean isUnderWeight(World world, int x, int y, int z) {
		Block weightBlock = world.getBlock(x, y + 1, z);
		Block baseBlock = world.getBlock(x, y - 1, z);

		boolean isWeightValid = weightBlock != null
			&& baseBlock.getIsBlockSolid(world, x, y + 1, z, Side.BOTTOM) && (weightBlock.blockMaterial == Material.stone || weightBlock.blockMaterial == Material.ice) && weightBlock != ModBlocks.ishi_tofu;

		float baseHardness = baseBlock.getHardness();
		boolean isBaseValid = baseBlock.getIsBlockSolid(world, x, y - 1, z, Side.TOP) &&
			(baseBlock.blockMaterial == Material.stone || baseBlock.blockMaterial == Material.metal || baseHardness >= 1.0F || baseHardness < 0.0F);

		return isWeightValid && isBaseValid;
	}
}
