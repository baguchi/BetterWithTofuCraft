package baguchan.tofucraft.world.biome;

import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeTofuPlain extends Biome {

	public BiomeTofuPlain() {
		setBlockedWeathers(Weather.overworldRain, Weather.overworldStorm);
		setColor(0xFFFFFF);
		setTopBlock(ModBlocks.tofu_terrain.id);
		setFillerBlock(ModBlocks.tofu_terrain.id);
	}
}
