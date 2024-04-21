package baguchan.tofucraft.item;

import baguchan.tofucraft.achievement.ModAchievement;
import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.HitResult;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

public class ItemBitternJar extends Item {
	public ItemBitternJar(String name, int openIds) {
		super(name, openIds);
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		super.onCraftedBy(itemstack, world, entityplayer);
		entityplayer.addStat(ModAchievement.MAKE_BITTERN, 1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		float f9;
		float f6;
		float f8;
		double d3;
		float f5;
		float f = 1.0f;
		float f1 = entityplayer.xRotO + (entityplayer.xRot - entityplayer.xRotO) * f;
		float f2 = entityplayer.yRotO + (entityplayer.yRot - entityplayer.yRotO) * f;
		double d = entityplayer.xo + (entityplayer.x - entityplayer.xo) * (double) f;
		double d1 = entityplayer.yo + (entityplayer.y - entityplayer.yo) * (double) f + 1.62 - (double) entityplayer.heightOffset;
		double d2 = entityplayer.zo + (entityplayer.z - entityplayer.zo) * (double) f;
		Vec3d vec3d = Vec3d.createVector(d, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.01745329f - 3.141593f);
		float f4 = MathHelper.sin(-f2 * 0.01745329f - 3.141593f);
		float f7 = f4 * (f5 = -MathHelper.cos(-f1 * 0.01745329f));
		Vec3d vec3d1 = vec3d.addVector((double) f7 * (d3 = 5.0), (double) (f8 = (f6 = MathHelper.sin(-f1 * 0.01745329f))) * d3, (double) (f9 = f3 * f5) * d3);
		HitResult movingobjectposition = world.checkBlockCollisionBetweenPoints(vec3d, vec3d1, true);
		if (movingobjectposition == null) {
			return itemstack;
		}
		if (movingobjectposition.hitType == HitResult.HitType.TILE) {
			int i = movingobjectposition.x;
			int j = movingobjectposition.y;
			int k = movingobjectposition.z;
			if (world.getBlockId(i, j, k) != ModBlocks.soymilk.id) {
				return itemstack;
			}

			if (world.getBlockMetadata(i, j, k) != 0) {
				return itemstack;
			}
			Block block = Block.blocksList[ModBlocks.kinu_tofu.id];
			if (itemstack.consumeItem(entityplayer) && world.setBlockAndMetadataWithNotify(i, j, k, ModBlocks.kinu_tofu.id, 0)) {
				block.onBlockPlaced(world, i, j, k, null, entityplayer, 0.0);
				world.playBlockSoundEffect(entityplayer, (float) i + 0.5f, (float) j + 0.5f, (float) k + 0.5f, block, EnumBlockSoundEffectType.PLACE);
				entityplayer.swingItem();
				entityplayer.inventory.insertItem(new ItemStack(Item.jar), false);
				entityplayer.addStat(ModAchievement.HARDEN_TO_TOFU, 1);
			}
		}
		return itemstack;
	}
}
