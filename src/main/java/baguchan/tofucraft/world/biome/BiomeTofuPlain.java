package baguchan.tofucraft.world.biome;

import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeTofuPlain extends Biome {

	public BiomeTofuPlain(String key) {
		super(key);
		setBlockedWeathers(Weather.overworldRain, Weather.overworldStorm);
		setColor(0xFFFFFF);
		setTopBlock(ModBlocks.tofu_terrain.id);
		setFillerBlock(ModBlocks.tofu_terrain.id);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
	}
}
