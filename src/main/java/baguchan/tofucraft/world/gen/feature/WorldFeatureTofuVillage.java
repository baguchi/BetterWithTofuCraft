package baguchan.tofucraft.world.gen.feature;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.entity.EntityTofunian;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureTofuVillage extends WorldFeature {
	int villageSize = 0;
	int houseLimit;
	int houseCount = 0;
	boolean isCold = false;
	int roadBlock;
	int brickBlockA;
	int brickBlockB;

	public WorldFeatureTofuVillage() {
		this.roadBlock = ModBlocks.tofuishi_smooth_brick.id;
		this.brickBlockA = ModBlocks.tofuishi_brick.id;
		this.brickBlockB = ModBlocks.tofuishi_chiseled_brick.id;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		Biome biome = world.getBlockBiome(x, y, z);
		this.generateBranch(world, random, x, y, z);
		return true;
	}

	public void generateBranch(World world, Random random, int blockX, int blockY, int blockZ) {
		if (this.villageSize < 10) {
			++this.villageSize;
			int corridorsToSpawn = random.nextInt(4);
			for (int i = 0; i <= corridorsToSpawn; ++i) {
				this.createRoad(world, random, blockX, blockY, blockZ, random.nextInt(4), 0);
			}
		}
	}

	private void createRoad(World world, Random random, int blockX, int blockY, int blockZ, int rot, int size) {
		if (rot == 0) {
			this.generateRoad(world, random, blockX, blockY, blockZ + 4, 0, size);
		}
		if (rot == 1) {
			this.generateRoad(world, random, blockX - 4, blockY, blockZ, 1, size);
		}
		if (rot == 2) {
			this.generateRoad(world, random, blockX, blockY, blockZ - 4, 2, size);
		}
		if (rot == 3) {
			this.generateRoad(world, random, blockX + 4, blockY, blockZ, 3, size);
		}
	}

	private void generateRoad(World world, Random random, int blockX, int blockY, int blockZ, int rot, int corridorIteration) {
		int height = 2;
		int width = 2;
		int length = 2;
		for (int x = blockX - width; x <= blockX + width; ++x) {
			for (int z = blockZ - length; z <= blockZ + length; ++z) {
				int y = world.getHeightValue(x, z) - 1;
				if (rot == 0) {
					world.setBlockWithNotify(x, y, z, this.brickBlockA);

				} else if (rot == 1) {
					world.setBlockWithNotify(x, y, z, this.brickBlockA);

				} else if (rot == 2) {
					world.setBlockWithNotify(x, y, z, this.brickBlockA);

				} else {
					world.setBlockWithNotify(x, y, z, this.brickBlockA);
				}
			}
		}
		if (random.nextInt(2) == 0 && corridorIteration > 1) {
			if (random.nextInt(2) == 0) {
				this.generateBranch(world, random, blockX, blockY, blockZ);
			} else {
				this.generateBranch(world, random, blockX, blockY, blockZ);
			}
		} else if (random.nextInt(2) == 0 && corridorIteration > 1 && this.villageSize > 3 || this.villageSize >= 10 && this.houseCount < this.houseLimit) {
			this.createHouse(world, random, blockX, blockY, blockZ, rot);
			++this.houseCount;
		} else {
			if (random.nextInt(10) == 0 && corridorIteration > 1 && this.villageSize > 5) {
				return;
			}
			this.createRoad(world, random, blockX, blockY, blockZ, rot, corridorIteration + 1);
		}
	}

	private void createHouse(World world, Random random, int blockX, int blockY, int blockZ, int rot) {
		int dx = 0;
		int dz = 0;
		if (rot == 0) {
			dz = 1;
		}
		if (rot == 1) {
			dx = -1;
		}
		if (rot == 2) {
			dz = -1;
		}
		if (rot == 3) {
			dx = 1;
		}
		this.generateHouse(world, random, blockX + dx * 4, blockY, blockZ + dz * 4, random.nextInt(2) + 2, random.nextInt(2) + 3, dx, dz);
	}

	private void generateHouse(World world, Random random, int blockX, int blockY, int blockZ, int sizeWidth, int sizeY, int dx, int dz) {
		int chestZ;
		boolean door = false;
		for (int x = blockX - sizeWidth; x <= blockX + sizeWidth; ++x) {
			for (int y = blockY; y <= blockY + sizeY; ++y) {
				for (int z = blockZ - sizeWidth; z <= blockZ + sizeWidth; ++z) {
					boolean xWallNegativeCheck = x == blockX - sizeWidth;
					boolean zWallNegativeCheck = z == blockZ - sizeWidth;
					boolean xWallCheck = x == blockX + sizeWidth;
					boolean zWallCheck = z == blockZ + sizeWidth;
					boolean yWallCheck = y == blockY || y == blockY + sizeY;
					boolean ydoor = y == blockY + 1 || y == blockY + 2;

					if (!door) {
						if (zWallNegativeCheck && x == blockX && !xWallNegativeCheck && !xWallCheck && dz == 1 && ydoor) {
							world.setBlockWithNotify(x, y, z, 0);
							continue;
						}
						if (zWallCheck && x == blockX && !xWallNegativeCheck && !xWallCheck && dz == -1 && ydoor) {
							world.setBlockWithNotify(x, y, z, 0);
							continue;
						}
						if (xWallNegativeCheck && z == blockZ && !zWallNegativeCheck && !zWallCheck && dx == 1 && ydoor) {
							world.setBlockWithNotify(x, y, z, 0);
							continue;
						}
						if (xWallCheck && z == blockZ && !zWallNegativeCheck && !zWallCheck && dx == -1 && ydoor) {
							world.setBlockWithNotify(x, y, z, 0);
							continue;
						}
					}
					if (xWallCheck || zWallCheck || xWallNegativeCheck || zWallNegativeCheck) {
						world.setBlockWithNotify(x, y, z, this.brickBlockA);
						continue;
					}
					if (yWallCheck) {
						if (random.nextInt(5) == 0) {
							world.setBlockWithNotify(x, y, z, this.brickBlockB);
							continue;
						}
						world.setBlockWithNotify(x, y, z, this.brickBlockA);
						continue;
					}

					world.setBlockWithNotify(x, y, z, 0);
				}
			}
		}


		world.setBlock(blockX + sizeWidth - 1, blockY + 1, blockZ + sizeWidth - 1, ModBlocks.tofuishi_chiseled_brick.id);
		world.setBlock(blockX + sizeWidth - 1, blockY + 2, blockZ + sizeWidth - 1, Block.lanternFireflyGreen.id);


		EntityTofunian tofunian = new EntityTofunian(world);
		tofunian.moveTo(blockX, blockY + 1, blockZ, 0, 0);

		world.entityJoinedWorld(tofunian);

		/*int chestX = blockX + random.nextInt(sizeX - 1) - (sizeX - 1);
		if (this.canReplace(world, chestX, blockY - 2, chestZ = blockZ + random.nextInt(sizeX - 1) - (sizeX - 1))) {
			world.setBlockWithNotify(chestX, blockY - 1, chestZ, Block.chestPlanksOak.id);
			TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(chestX, blockY - 1, chestZ);
			for (int k4 = 0; k4 < 10; ++k4) {
				ItemStack itemstack = this.pickCheckLootItem(random);
				if (itemstack == null) continue;
				tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
			}
		}*/
	}
}
