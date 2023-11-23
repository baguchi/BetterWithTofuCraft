package baguchan.tofucraft.entity;

import net.minecraft.client.render.model.Cube;
import net.minecraft.core.entity.EntityLiving;
import useless.dragonfly.helper.AnimationHelper;
import useless.dragonfly.model.entity.AnimationState;
import useless.dragonfly.model.entity.BenchEntityModel;
import useless.dragonfly.model.entity.animation.Animation;
import useless.dragonfly.model.entity.animation.AnimationData;

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
		Animation animation = AnimationHelper.getOrCreateEntityAnimation(MOD_ID, "tofunian.animation");
		animateWalk(animation.getAnimations().get("walk"), limbSwing, limbYaw, 2.0F, 0.5F);
		if (this.tofunian != null) {
			Animation sit = AnimationHelper.getOrCreateEntityAnimation(MOD_ID, "tofunian.animation");
			animate(tofunian.sitAnimation, animation.getAnimations().get("sit_down"), ticksExisted, 1F);
		}
	}

	protected void animate(AnimationState animationState, AnimationData animationData, float p_233388_, float p_233389_) {
		animationState.updateTime(p_233388_, p_233389_);
		animationState.ifStarted((p_233392_) -> {
			AnimationHelper.animate(this, animationData, p_233392_.getAccumulatedTime(), 0.5F, this.VEC_ANIMATION);
		});
	}

	public void setRotationAngle(Cube modelRenderer, Cube cube) {
		modelRenderer.rotateAngleX = cube.rotateAngleX;
		modelRenderer.rotateAngleY = cube.rotateAngleY;
		modelRenderer.rotateAngleZ = cube.rotateAngleZ;
	}

}
