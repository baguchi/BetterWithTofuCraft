package baguchan.tofucraft.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

public class BlockKinuTofu extends Block {
	public BlockKinuTofu(String key, int id, Material material) {
		super(key, id, material);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		entity.fallDistance *= 0.5F;
		if (entity.fallDistance > 0.5) {
			world.setBlockWithNotify(x, y, z, 0);
		}
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return AABB.getBoundingBoxFromPool(x + 0, y + 0, z + 0, x + 1, y + 1, z + 1);
	}
}
