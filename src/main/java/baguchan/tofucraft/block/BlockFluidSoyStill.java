package baguchan.tofucraft.block;

import net.minecraft.core.block.BlockFluidStill;
import net.minecraft.core.block.material.Material;

public class BlockFluidSoyStill extends BlockFluidStill {
	public BlockFluidSoyStill(String name, int openIds, Material soymilkMaterial) {
		super(name, openIds, soymilkMaterial);
	}
	@Override
	public int tickRate() {
		return 5;
	}
}
