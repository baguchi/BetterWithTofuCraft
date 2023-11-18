package baguchan.tofucraft.mixin;

import baguchan.tofucraft.ModSoundPools;
import baguchan.tofucraft.TofuCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.SoundPool;
import net.minecraft.client.sound.SoundPoolEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.File;
import java.util.Random;

@Mixin(value = SoundManager.class, remap = false)
public class SoundManagerMixin {
	@Shadow
	@Final
	private Random rand = new Random();
	@Shadow
	private Minecraft mc;

	@Redirect(method = "playRandomMusicIfReady", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/SoundPool;getRandomSound()Lnet/minecraft/client/sound/SoundPoolEntry;"))
	public SoundPoolEntry playRandomMusicIfReady(SoundPool instance) {
		SoundPoolEntry soundpoolentry = this.mc != null && this.mc.thePlayer != null && this.mc.thePlayer.world.dimension == TofuCraft.tofuDimension ? ModSoundPools.MOD_SOUND_POOLS_TOFU_MUSIC.getRandomSound() : instance.getRandomSound();
		return soundpoolentry;
	}

	@Redirect(method = "walkFolder(Ljava/io/File;Ljava/io/File;Lnet/minecraft/client/sound/SoundPool;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/SoundPool;addSound(Ljava/lang/String;Ljava/io/File;)Lnet/minecraft/client/sound/SoundPoolEntry;"))
	private static SoundPoolEntry dimensionMusic(SoundPool instance, String soundpoolentry, File e) {
		if (e.getPath().contains(new File("/tofu_world/").getPath())) {
			return ModSoundPools.MOD_SOUND_POOLS_TOFU_MUSIC.addSound(soundpoolentry, e);
		}
		return instance.addSound(soundpoolentry, e);
	}
}
