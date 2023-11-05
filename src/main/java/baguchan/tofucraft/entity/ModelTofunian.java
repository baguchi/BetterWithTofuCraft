package baguchan.tofucraft.entity;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBiped;
import net.minecraft.core.util.helper.MathHelper;

public class ModelTofunian extends ModelBiped {

	public Cube bipedleek;

	public ModelTofunian() {
		bipedLeftLeg = new Cube(0, 16, 64, 64);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.setRotationPoint(1.5F, -6.0F + 25.0F, 0.0F);
		bipedLeftLeg.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false);

		bipedRightLeg = new Cube(0, 16, 64, 64);
		bipedRightLeg.setRotationPoint(-1.5F, -6.0F + 25.0F, 0.0F);
		bipedRightLeg.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false);

		bipedHead = new Cube(0, 0, 64, 64);
		bipedHead.setRotationPoint(0.0F, -12.0F + 25.0F, 0.0F);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false);

		bipedleek = new Cube(0, 0, 64, 64);
		bipedleek.setRotationPoint(0.0F, -12.0F + 25.0F, 0.0F);
		bipedleek.addBox(-1.5F, -11.0F, 0.0F, 3, 3, 0, 0.0F, false);

		bipedHeadOverlay = new Cube(32, 0, 64, 64);
		bipedHeadOverlay.setRotationPoint(0.0F, 0.0F + 25.0F, 0.0F);
		bipedHeadOverlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false);

		bipedBody = new Cube(8, 16, 64, 64);
		bipedBody.setRotationPoint(0.0F, -12.0F + 25.0F, 0.0F);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 6, 4, 0.0F, false);

		bipedRightArm = new Cube(28, 16, 64, 64);
		bipedRightArm.setRotationPoint(-3.0F, -11.5F + 25.0F, 0.0F);
		bipedRightArm.addBox(-2.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false);

		bipedLeftArm = new Cube(28, 16, 64, 64);
		bipedLeftArm.setRotationPoint(3.0F, -11.5F + 25.0F, 0.0F);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(0.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false);
	}


	public void render(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbYaw, ticksExisted, headYaw, headPitch, scale);
		this.bipedHead.render(scale);
		this.bipedBody.render(scale);
		this.bipedRightArm.render(scale);
		this.bipedLeftArm.render(scale);
		this.bipedRightLeg.render(scale);
		this.bipedLeftLeg.render(scale);
		this.bipedHeadOverlay.render(scale);
		this.bipedleek.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbYaw, float ticksExisted, float headYaw, float headPitch, float scale) {
		this.bipedHead.rotateAngleY = headYaw / 57.29578F;
		this.bipedHead.rotateAngleX = headPitch / 57.29578F;
		this.bipedHeadOverlay.rotateAngleY = this.bipedHead.rotateAngleY;
		this.bipedHeadOverlay.rotateAngleX = this.bipedHead.rotateAngleX;
		this.bipedleek.rotateAngleY = this.bipedHead.rotateAngleY;
		this.bipedleek.rotateAngleX = this.bipedHead.rotateAngleX;
		this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 2.0F * limbYaw * 0.5F;
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbYaw * 0.5F;
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbYaw;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbYaw;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		Cube var10000;
		if (this.isRiding) {
			var10000 = this.bipedRightArm;
			var10000.rotateAngleX += -0.6283185F;
			var10000 = this.bipedLeftArm;
			var10000.rotateAngleX += -0.6283185F;
			this.bipedRightLeg.rotateAngleX = -1.256637F;
			this.bipedLeftLeg.rotateAngleX = -1.256637F;
			this.bipedRightLeg.rotateAngleY = 0.3141593F;
			this.bipedLeftLeg.rotateAngleY = -0.3141593F;
		}

		if (this.field_1279_h) {
			this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F;
		}

		if (this.field_1278_i) {
			this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.3141593F;
		}

		this.bipedRightArm.rotateAngleY = 0.0F;
		this.bipedLeftArm.rotateAngleY = 0.0F;
		if (this.onGround > -9990.0F) {
			float f6 = this.onGround;
			this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
			var10000 = this.bipedRightArm;
			var10000.rotateAngleY += this.bipedBody.rotateAngleY;
			var10000 = this.bipedLeftArm;
			var10000.rotateAngleY += this.bipedBody.rotateAngleY;
			var10000 = this.bipedLeftArm;
			var10000.rotateAngleX += this.bipedBody.rotateAngleY;
			f6 = 1.0F - this.onGround;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			float f7 = MathHelper.sin(f6 * 3.141593F);
			float f8 = MathHelper.sin(this.onGround * 3.141593F) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
			var10000 = this.bipedRightArm;
			var10000.rotateAngleX = (float) ((double) var10000.rotateAngleX - ((double) f7 * 1.2 + (double) f8));
			var10000 = this.bipedRightArm;
			var10000.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * 3.141593F) * -0.4F;
		}


		var10000 = this.bipedRightArm;
		var10000.rotateAngleZ += MathHelper.cos(ticksExisted * 0.09F) * 0.05F + 0.05F;
		var10000 = this.bipedLeftArm;
		var10000.rotateAngleZ -= MathHelper.cos(ticksExisted * 0.09F) * 0.05F + 0.05F;
		var10000 = this.bipedRightArm;
		var10000.rotateAngleX += MathHelper.sin(ticksExisted * 0.067F) * 0.05F;
		var10000 = this.bipedLeftArm;
		var10000.rotateAngleX -= MathHelper.sin(ticksExisted * 0.067F) * 0.05F;
	}

	public void setRotationAngle(Cube modelRenderer, Cube cube) {
		modelRenderer.rotateAngleX = cube.rotateAngleX;
		modelRenderer.rotateAngleY = cube.rotateAngleY;
		modelRenderer.rotateAngleZ = cube.rotateAngleZ;
	}

}
