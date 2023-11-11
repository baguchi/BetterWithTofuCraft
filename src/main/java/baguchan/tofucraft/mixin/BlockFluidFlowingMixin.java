package baguchan.tofucraft.mixin;

import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.block.BlockFluid;
import net.minecraft.core.block.BlockFluidFlowing;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockFluidFlowing.class, remap = false)
public class BlockFluidFlowingMixin extends BlockFluid {
	public BlockFluidFlowingMixin(String key, int id, Material material) {
		super(key, id, material);
	}

	@Inject(method = "setFluidStill", at = @At("HEAD"), cancellable = true)
	private void setFluidStill(World world, int x, int y, int z, CallbackInfo ci) {
		if (ModBlocks.soymilk_flow.id == this.id) {
			ci.cancel();
		}
	}
}
