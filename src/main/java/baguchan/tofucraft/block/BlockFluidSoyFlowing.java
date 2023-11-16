package baguchan.tofucraft.block;

import net.minecraft.core.block.BlockFluidFlowing;
import net.minecraft.core.block.material.Material;

public class BlockFluidSoyFlowing extends BlockFluidFlowing {
	public BlockFluidSoyFlowing(String name, int openIds, Material soymilkMaterial) {
		super(name, openIds, soymilkMaterial);
	}

	@Override
	public int tickRate() {
		return 5;
	}
}
