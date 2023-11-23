package baguchan.tofucraft.world.gen.feature;

import useless.terrainapi.generation.Parameters;

import java.util.Random;

public class TofuWorldFunction {
	public static Void generateVillage(Parameters parameters) {
		int x = parameters.chunk.xPosition * 16;
		int z = parameters.chunk.zPosition * 16;
		for (int i = 0; i < 1; ++i) {
			int xPos = x + parameters.random.nextInt(16) + 8;
			int zPos = z + parameters.random.nextInt(16) + 8;
			int yPos = parameters.decorator.world.getHeightValue(xPos, zPos);
			if (parameters.random.nextInt(350) != 0) continue;
			Random lRand = parameters.chunk.getChunkRandom(21344760L);
			new WorldFeatureTofuVillage().generate(parameters.decorator.world, lRand, xPos, yPos, zPos);
		}
		return null;
	}
}
