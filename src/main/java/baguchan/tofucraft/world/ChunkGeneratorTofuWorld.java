package baguchan.tofucraft.world;

import baguchan.tofucraft.world.gen.ChunkDecoratorTofuWorldAPI;
import baguchan.tofucraft.world.gen.MapGenTofuCaves;
import baguchan.tofucraft.world.gen.TerrainGeneratorTofuWorld;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.chunk.perlin.ChunkGeneratorPerlin;

public class ChunkGeneratorTofuWorld extends ChunkGeneratorPerlin {

	protected ChunkGeneratorTofuWorld(World world) {
		super(world, new ChunkDecoratorTofuWorldAPI(world), new TerrainGeneratorTofuWorld(world), new SurfaceGeneratorTofuWorld(world), new MapGenTofuCaves(false));
	}
}
