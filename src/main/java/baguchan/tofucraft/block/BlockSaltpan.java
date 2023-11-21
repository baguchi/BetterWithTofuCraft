package baguchan.tofucraft.block;

import baguchan.tofucraft.TofuCraft;
import baguchan.tofucraft.item.ModItems;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.weather.WeatherClear;
import useless.dragonfly.helper.ModelHelper;

import java.util.Random;

public class BlockSaltpan extends useless.dragonfly.debug.block.BlockModel {
	public BlockSaltpan(String name, int openIds, Material material) {
		super(name, openIds, material, ModelHelper.getOrCreateBlockModel(TofuCraft.MOD_ID, "block/saltpan.json"));
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.getBlock(x, y, z) == ModBlocks.saltpan_water) {
			float f = this.calcAdaptation(world, x, y, z);

			if (f > 0.0F && rand.nextInt((int) (25.0F / f) + 1) == 0) {
				world.setBlockWithNotify(x, y, z, ModBlocks.saltpan_salt.id);
			}
		}
	}

	private float calcAdaptation(World world, int x, int y, int z) {
		boolean isUnderTheSun = world.canBlockSeeTheSky(x, y, z);
		boolean isRaining = !(world.getCurrentWeather() instanceof WeatherClear);
		boolean isDaytime = world.getWorldTime() % 24000 < 12000;
		double temp = world.getBlockTemperature(x, z);
		double hum = world.getBlockHumidity(x, z);
		float rate;

		if (!isUnderTheSun || isRaining) {
			rate = 0.0F;
		} else {
			rate = isDaytime ? 2.0F : 1.0F;
			rate = (float) (rate * ((hum < 0.2D) ? 4.0D : ((hum < 0.7D) ? 2.0D : ((hum < 0.9D) ? 1.0D : 0.5D))));
			rate = (float) (rate * ((temp < 0.0D) ? 1.0D : ((temp < 0.6D) ? 1.5D : ((temp < 1.0D) ? 2.0D : 4.0D))));

		}
		return rate;
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {

		if (world.getBlock(x, y, z) == ModBlocks.saltpan) {
			if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Item.bucketWater) {

				world.playSoundAtEntity(player, "random.pop", 0.2f, 0.5f);
				world.setBlockWithNotify(x, y, z, ModBlocks.saltpan_water.id);
				player.inventory.getCurrentItem().consumeItem(player);
				player.inventory.insertItem(new ItemStack(Item.bucket), false);
				return true;
			}
		}
		if (world.getBlock(x, y, z) == ModBlocks.saltpan_salt) {

			world.playSoundAtEntity(player, "random.pop", 0.2f, 0.5f);
			world.setBlockWithNotify(x, y, z, ModBlocks.saltpan_bittern.id);
			player.inventory.insertItem(new ItemStack(ModItems.salt), false);
			return true;

		}
		if (world.getBlock(x, y, z) == ModBlocks.saltpan_bittern) {
			if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == Item.jar) {

				world.playSoundAtEntity(player, "random.pop", 0.2f, 0.5f);
				world.setBlockWithNotify(x, y, z, ModBlocks.saltpan.id);
				player.inventory.getCurrentItem().consumeItem(player);
				player.inventory.insertItem(new ItemStack(ModItems.bittern_jar), false);
				return true;
			}
		}
		return super.blockActivated(world, x, y, z, player);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (dropCause != EnumDropCause.IMPROPER_TOOL) {
			return new ItemStack[]{new ItemStack(ModBlocks.saltpan)};
		}
		return null;
	}
}
