package baguchan.tofucraft.entity;

import net.minecraft.client.render.model.Cube;
import net.minecraft.core.entity.EntityLiving;
import useless.dragonfly.helper.AnimationHelper;
import useless.dragonfly.model.entity.BenchEntityModel;
import useless.dragonfly.model.entity.animation.Animation;

import static baguchan.tofucraft.TofuCraft.MOD_ID;

public class ModelTofunian extends BenchEntityModel {
	public static EntityTofunian tofunian;

	@Override
	public void setLivingAnimations(EntityLiving entityliving, float limbSwing, float limbYaw, float renderPartialTicks) {
		super.setLivingAnimations(entityliving, limbSwing, limbYaw, renderPartialTicks);
		if (entityliving instanceof EntityTofunian) {
			tofunian = (EntityTofunian) entityliving;
		}
	}

	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		this.getIndexBones().forEach((s, benchEntityBones) -> benchEntityBones.resetPose());
		super.setRotationAngles(limbSwing, limbYaw, ticksExisted, headYaw, headPitch, scale);
		if (this.getIndexBones().containsKey("Head")) {
			this.getIndexBones().get("Head").setRotationAngle((float) Math.toRadians(headPitch), (float) Math.toRadians(headYaw), 0);
		}
		if (this.tofunian != null) {
			Animation animation = AnimationHelper.getOrCreateEntityAnimation(MOD_ID, "tofunian.animation");
			animateWalk(animation.getAnimations().get("walk"), limbSwing, limbYaw, 2.0F, 0.5F);

			Animation sit = AnimationHelper.getOrCreateEntityAnimation(MOD_ID, "tofunian.animation");
			animate(tofunian.sitAnimation, animation.getAnimations().get("sit_down"), ticksExisted, 1F);
		}
	}

	public void setRotationAngle(Cube modelRenderer, Cube cube) {
		modelRenderer.rotateAngleX = cube.rotateAngleX;
		modelRenderer.rotateAngleY = cube.rotateAngleY;
		modelRenderer.rotateAngleZ = cube.rotateAngleZ;
	}

}
