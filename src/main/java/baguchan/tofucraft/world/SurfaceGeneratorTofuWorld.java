package baguchan.tofucraft.world;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkGeneratorResult;
import net.minecraft.core.world.generate.chunk.perlin.SurfaceGenerator;
import net.minecraft.core.world.noise.BasePerlinNoise;
import net.minecraft.core.world.noise.PerlinNoise;

import java.util.Random;

public class SurfaceGeneratorTofuWorld implements SurfaceGenerator {
	private final World world;
	private final BasePerlinNoise<?> beachNoise;
	private final BasePerlinNoise<?> soilNoise;
	private final BasePerlinNoise<?> mainNoise;
	private final boolean generateStoneVariants;

	protected SurfaceGeneratorTofuWorld(World world, BasePerlinNoise<?> beachNoise, BasePerlinNoise<?> soilNoise, BasePerlinNoise<?> mainNoise, boolean generateStoneVariants) {
		this.world = world;
		this.beachNoise = beachNoise;
		this.soilNoise = soilNoise;
		this.mainNoise = mainNoise;
		this.generateStoneVariants = generateStoneVariants;
	}

	public SurfaceGeneratorTofuWorld(World world) {
		this(world, new PerlinNoise(world.getRandomSeed(), 4, 40), new PerlinNoise(world.getRandomSeed(), 4, 44), new PerlinNoise(world.getRandomSeed(), 8, 32), true);
	}


	@Override
	public void generateSurface(Chunk chunk, ChunkGeneratorResult result) {
		int oceanY = this.world.getWorldType().getOceanY();
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int terrainHeight = maxY + 1 - minY;
		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		int oceanBlock = this.world.getWorldType().getOceanBlock();
		int worldFillBlock = this.world.getWorldType().getFillerBlock();
		Random rand = new Random((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);
		double beachScale = 0.03125;
		double[] soilThicknessNoise = this.soilNoise.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 2.0, beachScale * 2.0, beachScale * 2.0);
		double[] stoneLayerNoise = null;
		double[] stoneLayerNoiseGranite = null;
		double[] stoneLayerNoiseLimestone = null;
		if (this.generateStoneVariants) {
			stoneLayerNoise = this.soilNoise.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 4.0, beachScale * 4.0, beachScale * 4.0);
			stoneLayerNoiseGranite = this.mainNoise.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 4.0, beachScale * 4.0, beachScale * 4.0);
			stoneLayerNoiseLimestone = this.beachNoise.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 4.0, beachScale * 4.0, beachScale * 4.0);
		}
		for (int z = 0; z < 16; ++z) {
			for (int x = 0; x < 16; ++x) {
				int soilThickness = (int) (soilThicknessNoise[z + x * 16] / 3.0 + 3.0 + rand.nextDouble() * 0.25);
				boolean generateBasaltLayer = false;
				boolean generateGraniteLayer = false;
				boolean generateLimestoneLayer = false;
				int basaltThicknessLevel = 0;
				int graniteThicknessLevel = 0;
				int limestoneThicknessLevel = 0;
				if (this.generateStoneVariants) {
					generateBasaltLayer = stoneLayerNoise[z + x * 16] + rand.nextDouble() * 0.2 > 0.0;
					generateGraniteLayer = stoneLayerNoiseGranite[z + x * 16] + rand.nextDouble() * 0.2 > 2.0;
					generateLimestoneLayer = stoneLayerNoiseLimestone[z + x * 16] + rand.nextDouble() * 0.2 > 3.0;
					basaltThicknessLevel = (int) (stoneLayerNoise[z + x] + rand.nextDouble() * 0.5);
					graniteThicknessLevel = (int) (stoneLayerNoiseGranite[z + x] + rand.nextDouble() * 0.5);
					limestoneThicknessLevel = (int) (stoneLayerNoiseLimestone[z + x] + rand.nextDouble() * 0.5);
				}
				int currentLayerDepth = -1;
				int topBlock = -1;
				int fillerBlock = -1;
				Biome lastBiome = null;
				for (int y = maxY; y >= minY; --y) {
					Biome biome = chunk.getBlockBiome(x, y, z);
					if (biome == null) {
						biome = this.world.getBiomeProvider().getBiome(chunkX * 16 + x, y >> 3, chunkZ * 16 + z);
					}
					int block = result.getBlock(x, y, z);
					if ((biome != lastBiome || topBlock == -1 || fillerBlock == -1) && block == 0) {
						topBlock = biome.topBlock;
						fillerBlock = biome.fillerBlock;
					}
					lastBiome = biome;
					if (block == 0) {
						currentLayerDepth = -1;
						continue;
					}
					if (block != worldFillBlock) continue;
					if (currentLayerDepth == -1) {
						if (soilThickness <= 0) {
							topBlock = 0;
							fillerBlock = (short) worldFillBlock;
						} else if (y >= minY + oceanY - 4 && y <= minY + oceanY + 1) {
							topBlock = biome.topBlock;
							fillerBlock = biome.fillerBlock;
						}
						if (y < minY + oceanY && topBlock == 0) {
							topBlock = (short) oceanBlock;
						}
						currentLayerDepth = soilThickness;
						if (y >= minY + oceanY - 1) {
							result.setBlock(x, y, z, topBlock);
							continue;
						}
						result.setBlock(x, y, z, fillerBlock);
						continue;
					}
					/*if (this.generateStoneVariants && currentLayerDepth <= 0) {
						if (y >= minY + basaltThicknessLevel - rand.nextInt(3) && y <= minY + 30 + basaltThicknessLevel - rand.nextInt(3) && generateBasaltLayer) {
							result.setBlock(x, y, z, Block.basalt.id);
							continue;
						}
						if (y >= minY + 64 + graniteThicknessLevel - rand.nextInt(3) && y <= minY + 128 + graniteThicknessLevel - rand.nextInt(3) && generateGraniteLayer) {
							result.setBlock(x, y, z, Block.granite.id);
							continue;
						}
						if (y < minY + 64 + limestoneThicknessLevel - rand.nextInt(3) || y > minY + 128 + limestoneThicknessLevel - rand.nextInt(3) || !generateLimestoneLayer) continue;
						result.setBlock(x, y, z, Block.limestone.id);
						continue;
					}*/
					if (currentLayerDepth > 0) {
						--currentLayerDepth;
						result.setBlock(x, y, z, fillerBlock);
					}
					if (currentLayerDepth != 0) continue;
					if (biome == Biomes.OVERWORLD_DESERT && fillerBlock == Block.sand.id) {
						currentLayerDepth = rand.nextInt(8) + 2;
						fillerBlock = (short) Block.sandstone.id;
						continue;
					}
					if (biome != Biomes.OVERWORLD_GLACIER || fillerBlock != Block.blockSnow.id) continue;
					currentLayerDepth = rand.nextInt(8) + 14;
					fillerBlock = (short) Block.permafrost.id;
				}
			}
		}
	}
}

