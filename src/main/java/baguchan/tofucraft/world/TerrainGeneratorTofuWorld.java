package baguchan.tofucraft.world;

import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.chunk.perlin.DensityGenerator;
import net.minecraft.core.world.generate.chunk.perlin.TerrainGeneratorLerp;
import net.minecraft.core.world.generate.chunk.perlin.overworld.DensityGeneratorOverworld;
import net.minecraft.core.world.type.WorldType;

public class TerrainGeneratorTofuWorld extends TerrainGeneratorLerp {
	private final DensityGenerator densityGenerator;

	protected TerrainGeneratorTofuWorld(World world, DensityGenerator densityGenerator) {
		super(world);
		this.densityGenerator = densityGenerator;
	}

	public TerrainGeneratorTofuWorld(World world) {
		this(world, new DensityGeneratorOverworld(world));
	}

	@Override
	protected int getBlockAt(int x, int y, int z, double density) {
		WorldType type = this.world.getWorldType();
		if (y <= type.getMinY() + this.rand.nextInt(5)) {
			return ModBlocks.tofu_bedrock.id;
		}
		if (density > 0.0) {
			return type.getFillerBlock();
		}
		if (y >= type.getMinY() && y < type.getMinY() + type.getOceanY()) {
			return type.getOceanBlock();
		}
		return 0;
	}

	@Override
	public DensityGenerator getDensityGenerator() {
		return this.densityGenerator;
	}
}

