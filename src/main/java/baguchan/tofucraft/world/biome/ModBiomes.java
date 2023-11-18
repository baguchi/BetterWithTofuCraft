package baguchan.tofucraft.world.biome;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

public class ModBiomes extends Biomes {
	public static Biome TOFU_PLAIN = new BiomeTofuPlain();

	public static void initializeBiomes() {
		Biomes.register("tofucraft.biome.tofu_plain", TOFU_PLAIN);
	}
}
