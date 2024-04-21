package baguchan.tofucraft.item;

import baguchan.tofucraft.block.ModBlocks;
import net.minecraft.core.HitResult;
import net.minecraft.core.block.BlockPortal;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

public class ItemTofuStick extends Item {
	public ItemTofuStick(String name, int openIds) {
		super(name, openIds);
		this.setMaxStackSize(1);
		this.setMaxDamage(64);
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		super.onCraftedBy(itemstack, world, entityplayer);
		//entityplayer.addStat(ModAchievement.MAKE_BITTERN, 1);
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
		HitResult movingobjectposition = world.checkBlockCollisionBetweenPoints(vec3d, vec3d1, false);
		if (movingobjectposition == null) {
			return itemstack;
		}
		if (movingobjectposition.hitType == HitResult.HitType.TILE) {
			int i = movingobjectposition.x;
			int j = movingobjectposition.y;
			int k = movingobjectposition.z;

			if (world.getBlockId(i, j, k) == ((BlockPortal) ModBlocks.tofu_portal).portalFrameId && !world.isClientSide) {
				if (((BlockPortal) ModBlocks.tofu_portal).tryToCreatePortal(world, i, j + 1, k)) {
					world.playSoundEffect(entityplayer, SoundCategory.WORLD_SOUNDS, (double) i + 0.5, (double) j + 0.5, (double) k + 0.5, "fire.ignite", 1.0f, itemRand.nextFloat() * 0.4f + 0.8f);
					itemstack.damageItem(1, entityplayer);
					return itemstack;
				}
			}
		}
		return itemstack;
	}
}
