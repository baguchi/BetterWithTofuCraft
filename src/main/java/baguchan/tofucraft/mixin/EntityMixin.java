package baguchan.tofucraft.mixin;

import baguchan.tofucraft.block.ModMaterials;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Entity.class, remap = false)
public class EntityMixin {

	@Shadow
	public World world;

	@Shadow
	@Final
	public AABB bb;

	@Inject(method = "checkAndHandleWater", at = @At("HEAD"), cancellable = true)
	public void checkAndHandleWater(CallbackInfoReturnable<Boolean> cir) {
		Entity entity = (Entity) (Object) this;
		if (this.world.handleMaterialAcceleration(this.bb, ModMaterials.soymilk_material, entity)) {
			cir.setReturnValue(true);
		}
	}
}
