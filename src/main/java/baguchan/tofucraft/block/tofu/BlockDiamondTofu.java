package baguchan.tofucraft.block.tofu;

import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockDiamondTofu extends Block {

	public BlockDiamondTofu(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case WORLD:
			case EXPLOSION:
			case PROPER_TOOL: {
				return new ItemStack[]{new ItemStack(ModItems.tofudiamond, 4)};
			}
			case PICK_BLOCK:
			case SILK_TOUCH: {
				return new ItemStack[]{new ItemStack(this)};
			}
		}
		return null;
	}
}
