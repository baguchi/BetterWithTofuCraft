package baguchan.tofucraft.entity;

import net.minecraft.client.render.model.Cube;
import useless.dragonfly.helper.AnimationHelper;
import useless.dragonfly.model.entity.BenchEntityModel;
import useless.dragonfly.model.entity.animation.Animation;

import static baguchan.tofucraft.TofuCraft.MOD_ID;

public class ModelTofunian extends BenchEntityModel {

	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		this.getIndexBones().forEach((s, benchEntityBones) -> benchEntityBones.resetPose());
		super.setRotationAngles(limbSwing, limbYaw, ticksExisted, headYaw, headPitch, scale);
		if (this.getIndexBones().containsKey("Head")) {
			this.getIndexBones().get("Head").setRotationAngle((float) Math.toRadians(headPitch), (float) Math.toRadians(headYaw), 0);
		}
		Animation testAnimation = AnimationHelper.getOrCreateEntityAnimation(MOD_ID, "tofunian.animation");
		animateWalk(testAnimation.getAnimations().get("walk"), limbSwing, limbYaw, 2.0F, 0.5F);

	}

	public void setRotationAngle(Cube modelRenderer, Cube cube) {
		modelRenderer.rotateAngleX = cube.rotateAngleX;
		modelRenderer.rotateAngleY = cube.rotateAngleY;
		modelRenderer.rotateAngleZ = cube.rotateAngleZ;
	}

}
