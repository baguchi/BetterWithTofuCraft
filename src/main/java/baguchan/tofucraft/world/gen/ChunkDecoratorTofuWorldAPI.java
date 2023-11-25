package baguchan.tofucraft.world.gen;

import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.noise.PerlinNoise;
import org.jetbrains.annotations.ApiStatus;
import useless.terrainapi.config.ConfigManager;
import useless.terrainapi.generation.ChunkDecoratorAPI;
import useless.terrainapi.generation.Parameters;
import useless.terrainapi.generation.StructureFeatures;
import useless.terrainapi.generation.overworld.OverworldBiomeFeatures;
import useless.terrainapi.generation.overworld.OverworldConfig;
import useless.terrainapi.generation.overworld.OverworldRandomFeatures;

import java.util.Random;
import java.util.function.Function;

public class ChunkDecoratorTofuWorldAPI extends ChunkDecoratorAPI {
	public static OverworldConfig overworldConfig = (OverworldConfig) ConfigManager.getConfig("tofu_world", OverworldConfig.class);
	public final PerlinNoise treeDensityNoise;
	public final int treeDensityOverride;
	public static StructureFeatures structureFeatures = new StructureFeatures();
	public static TofuWorldOreFeatures oreFeatures;
	public static OverworldRandomFeatures randomFeatures;
	public static OverworldBiomeFeatures biomeFeatures;

	public ChunkDecoratorTofuWorldAPI(World world, int treeDensityOverride) {
		super(world);
		this.treeDensityOverride = treeDensityOverride;
		this.treeDensityNoise = new PerlinNoise(world.getRandomSeed(), 8, 74);
	}

	public ChunkDecoratorTofuWorldAPI(World world) {
		this(world, -1);
	}

	@ApiStatus.Internal
	public void decorateAPI() {
		int xCoord = this.parameterBase.chunk.xPosition * 16;
		int zCoord = this.parameterBase.chunk.zPosition * 16;
		this.generateStructures(this.parameterBase.biome, this.parameterBase.chunk, this.parameterBase.random);
		this.generateOreFeatures(this.parameterBase.biome, xCoord, zCoord, this.parameterBase.random, this.parameterBase.chunk);
		this.generateBiomeFeature(this.parameterBase.biome, xCoord, zCoord, this.parameterBase.random, this.parameterBase.chunk);
		this.generateRandomFeatures(this.parameterBase.biome, xCoord, zCoord, this.parameterBase.random, this.parameterBase.chunk);
		this.freezeSurface(xCoord, zCoord);
	}

	@ApiStatus.Internal
	public void generateStructures(Biome biome, Chunk chunk, Random random) {
		int featureSize = structureFeatures.featureFunctionList.size();

		for (int i = 0; i < featureSize; ++i) {
			((Function) structureFeatures.featureFunctionList.get(i)).apply(new Parameters(this.parameterBase, (Object[]) structureFeatures.featureParametersList.get(i)));
		}

	}

	@ApiStatus.Internal
	public void generateOreFeatures(Biome biome, int x, int z, Random random, Chunk chunk) {
		int featureSize = oreFeatures.featureFunctionsList.size();

		for (int i = 0; i < featureSize; ++i) {
			int density = (Integer) ((Function) oreFeatures.densityFunctionsList.get(i)).apply(new Parameters(this.parameterBase, (Object[]) oreFeatures.densityParametersList.get(i)));
			float startingRange = (Float) oreFeatures.startingRangeList.get(i);
			float endingRange = (Float) oreFeatures.endingRangeList.get(i);
			this.generateWithChancesUnderground((Function) oreFeatures.featureFunctionsList.get(i), new Parameters(this.parameterBase, (Object[]) oreFeatures.featureParametersList.get(i)), (float) density, (int) (startingRange * (float) this.rangeY), (int) (endingRange * (float) this.rangeY), x, z, random);
		}

	}

	@ApiStatus.Internal
	public void generateRandomFeatures(Biome biome, int x, int z, Random random, Chunk chunk) {
		int featureSize = randomFeatures.featureFunctionsList.size();

		for (int i = 0; i < featureSize; ++i) {
			if (random.nextInt((Integer) randomFeatures.inverseProbabilityList.get(i)) == 0) {
				Function<Parameters, WorldFeature> featureFunction = (Function) randomFeatures.featureFunctionsList.get(i);
				int density = (Integer) ((Function) randomFeatures.densityFunctionsList.get(i)).apply(new Parameters(this.parameterBase, (Object[]) randomFeatures.densityParametersList.get(i)));
				float startingRange = (Float) randomFeatures.startingRangeList.get(i);
				float endingRange = (Float) randomFeatures.endingRangeList.get(i);
				if ((!(-1.01 <= (double) startingRange) || !((double) startingRange <= -0.99)) && (!(-1.01 <= (double) endingRange) || !((double) endingRange <= -0.99))) {
					this.generateWithChancesUnderground(featureFunction, new Parameters(this.parameterBase, (Object[]) randomFeatures.featureParametersList.get(i)), (float) density, (int) (startingRange * (float) this.rangeY), (int) (endingRange * (float) this.rangeY), x, z, 8, 8, random);
				} else {
					this.generateWithChancesSurface(featureFunction, new Parameters(this.parameterBase, (Object[]) randomFeatures.featureParametersList.get(i)), (float) density, x, z, 8, 8, random);
				}
			}
		}

	}

	@ApiStatus.Internal
	public void generateBiomeFeature(Biome biome, int x, int z, Random random, Chunk chunk) {
		int featureSize = biomeFeatures.featureFunctionsList.size();

		for (int i = 0; i < featureSize; ++i) {
			Function<Parameters, WorldFeature> featureFunction = (Function) biomeFeatures.featureFunctionsList.get(i);
			int density = (Integer) ((Function) biomeFeatures.densityFunctionsList.get(i)).apply(new Parameters(this.parameterBase, (Object[]) biomeFeatures.densityParametersList.get(i)));
			float startingRange = (Float) biomeFeatures.startingRangeList.get(i);
			float endingRange = (Float) biomeFeatures.endingRangeList.get(i);
			if ((!(-1.01 <= (double) startingRange) || !((double) startingRange <= -0.99)) && (!(-1.01 <= (double) endingRange) || !((double) endingRange <= -0.99))) {
				this.generateWithChancesUnderground(featureFunction, new Parameters(this.parameterBase, (Object[]) biomeFeatures.featureParametersList.get(i)), (float) density, (int) (startingRange * (float) this.rangeY), (int) (endingRange * (float) this.rangeY), x, z, 8, 8, random);
			} else {
				this.generateWithChancesSurface(featureFunction, new Parameters(this.parameterBase, (Object[]) biomeFeatures.featureParametersList.get(i)), (float) density, x, z, 8, 8, random);
			}
		}

	}

	static {
		oreFeatures = new TofuWorldOreFeatures(overworldConfig);
		randomFeatures = new OverworldRandomFeatures();
		biomeFeatures = new OverworldBiomeFeatures();
	}
}
