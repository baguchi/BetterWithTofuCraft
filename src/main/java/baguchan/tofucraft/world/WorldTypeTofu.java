package baguchan.tofucraft.world;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.world.biome.ModBiomes;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import net.minecraft.core.world.biome.provider.BiomeProviderSingleBiome;
import net.minecraft.core.world.config.season.SeasonConfig;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.type.WorldTypeOverworld;
import net.minecraft.core.world.weather.Weather;
import net.minecraft.core.world.wind.WindManagerGeneric;

public class WorldTypeTofu extends WorldTypeOverworld {

	public WorldTypeTofu(String languageKey) {
		super(languageKey,
			Weather.overworldClear,
			new WindManagerGeneric(),
			SeasonConfig.builder()
				.withSeasonInCycle(Seasons.OVERWORLD_SPRING, 14)
				.withSeasonInCycle(Seasons.OVERWORLD_FALL, 14)
				.build());
	}

	@Override
	public int getOceanBlock() {
		return ModBlocks.soymilk.id;
	}

	@Override
	public int getFillerBlock() {
		return ModBlocks.tofu_terrain.id;
	}

	@Override
	public int getMinY() {
		return 0;
	}

	@Override
	public int getMaxY() {
		return 127;
	}

	@Override
	public int getOceanY() {
		return 64;
	}

	@Override
	public BiomeProvider createBiomeProvider(World world) {
		return new BiomeProviderSingleBiome(ModBiomes.TOFU_PLAIN, 1.0, 1.0, 1.0);
	}

	@Override
	public ChunkGenerator createChunkGenerator(World world) {
		return new ChunkGeneratorTofuWorld(world);
	}

	@Override
	public float getCloudHeight() {
		return 108.0f;
	}

	@Override
	public boolean hasAurora() {
		return true;
	}

	@Override
	public boolean isValidSpawn(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean mayRespawn() {
		return false;
	}
}
