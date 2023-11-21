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
	public List<Float> rangeModifierList = new ArrayList();
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
		super.addFeature(featureFunction, featureParameters, densityFunction, densityParameters);
		this.rangeModifierList.add(rangeModifier);
	}

	public void addManagedOreFeature(String modID, Block block, int defaultClusterSize, int defaultChances, float defaultRange) {
		this.config.setOreValues(modID, block, defaultClusterSize, defaultChances, defaultRange);
		this.addManagedOreFeature(block);
	}

	public void addManagedOreFeature(Block block) {
		String currentBlock = block.getKey();
		this.addFeature(new WorldFeatureTofuOre(block.id, (Integer) this.config.clusterSize.get(currentBlock)), (Integer) this.config.chancesPerChunk.get(currentBlock), (Float) this.config.verticalRange.get(currentBlock));
	}
}
