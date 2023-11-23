package baguchan.tofucraft.mixin;

import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public class WorldFeatureLabyrinthMixin {

	@Inject(method = "pickCheckLootItem(Ljava/util/Random;)Lnet/minecraft/core/item/ItemStack;", at = @At(value = "RETURN"), cancellable = true)
	private void addToLabyrinthLoot(Random random, CallbackInfoReturnable<ItemStack> cir) {
		int i = random.nextInt(20);
		if (i == 0 && cir.getReturnValue() == null) {
			ItemStack stack = new ItemStack(ModItems.tofu_stick);

			cir.setReturnValue(stack);
		}
	}
}
