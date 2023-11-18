package baguchan.tofucraft.block;

import net.minecraft.core.block.BlockFluidStill;
import net.minecraft.core.block.BlockPortal;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

public class BlockFluidSoyStill extends BlockFluidStill {
	public BlockFluidSoyStill(String name, int openIds, Material soymilkMaterial) {
		super(name, openIds, soymilkMaterial);
	}


	public void onBlockAdded(World world, int x, int y, int z) {
		if (world.getBlockId(x, y - 1, z) == ((BlockPortal) ModBlocks.tofu_portal).portalFrameId && !world.isClientSide) {
			((BlockPortal) ModBlocks.tofu_portal).tryToCreatePortal(world, x, y, z);
		}
		super.onBlockAdded(world, x, y, z);
	}
	@Override
	public int tickRate() {
		return 5;
	}
}
