package baguchan.tofucraft.world.gen;

import baguchan.tofucraft.world.gen.feature.WorldFeatureTofuOre;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.WorldFeature;
import org.jetbrains.annotations.ApiStatus;
import useless.terrainapi.config.OreConfig;
import useless.terrainapi.generation.GeneratorFeatures;
import useless.terrainapi.generation.Parameters;
import useless.terrainapi.generation.overworld.OverworldFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TofuWorldOreFeatures extends GeneratorFeatures {
	@ApiStatus.Internal
	public List<Float> startingRangeList = new ArrayList();
	@ApiStatus.Internal
	public List<Float> endingRangeList = new ArrayList();
	public OreConfig config;

	public TofuWorldOreFeatures(OreConfig config) {
		this.config = config;
	}

	public void addFeature(WorldFeature feature, int chances, float rangeModifier) {
		this.addFeature(feature, chances, rangeModifier, (Biome[]) null);
	}

	public void addFeature(WorldFeature feature, int chances, float rangeModifier, Biome[] biomes) {
		this.addFeature((x) -> {
			return feature;
		}, (Object[]) null, OverworldFunctions::getStandardOreBiomesDensity, new Object[]{chances, biomes}, rangeModifier);
	}

	public void addFeature(Function<Parameters, WorldFeature> featureFunction, Object[] featureParameters, Function<Parameters, Integer> densityFunction, Object[] densityParameters, float rangeModifier) {
		this.addFeature(featureFunction, featureParameters, densityFunction, densityParameters, 0.0F, rangeModifier);
	}

	public void addFeature(Function<Parameters, WorldFeature> featureFunction, Object[] featureParameters, Function<Parameters, Integer> densityFunction, Object[] densityParameters, float startingRange, float endingRange) {
		super.addFeature(featureFunction, featureParameters, densityFunction, densityParameters);
		this.startingRangeList.add(startingRange);
		this.endingRangeList.add(endingRange);
	}

	public void addManagedOreFeature(String modID, Block block, int defaultClusterSize, int defaultChances, float defaultRange) {
		this.config.setOreValues(modID, block, defaultClusterSize, defaultChances, defaultRange);
		this.addManagedOreFeature(block);
	}

	public void addManagedOreFeature(Block block) {
		String currentBlock = block.getKey();
		this.addFeature((x) -> {
			return new WorldFeatureTofuOre(block.id, (Integer) this.config.clusterSize.get(currentBlock));
		}, (Object[]) null, OverworldFunctions::getStandardOreBiomesDensity, new Object[]{this.config.chancesPerChunk.get(currentBlock), null}, (Float) this.config.verticalStartingRange.get(currentBlock), (Float) this.config.verticalEndingRange.get(currentBlock));
	}

	public void addManagedOreFeature(String modID, Block block, int defaultClusterSize, int defaultChances, float defaultStartingRange, float defaultEndingRange) {
		this.config.setOreValues(modID, block, defaultClusterSize, defaultChances, defaultStartingRange, defaultEndingRange);
		this.addManagedOreFeature(block);
	}
}
