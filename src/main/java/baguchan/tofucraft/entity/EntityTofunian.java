package baguchan.tofucraft.entity;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;
import useless.dragonfly.model.entity.AnimationState;

import javax.annotation.Nullable;

public class EntityTofunian extends EntityAnimal {

	public AnimationState sitAnimation = new AnimationState();
	@Nullable
	private Vec3d homePos;
	public EntityTofunian(World world) {
		super(world);
		this.scoreValue = 0;
		this.heightOffset = 0.0F;
		this.footSize = 0.5F;
		this.moveSpeed = 0.85F;
		this.setSize(0.6F, 1.15F);
		this.setPos(this.x, this.y, this.z);
		this.skinName = "tofunian";
	}

	@Override
	public int getMaxHealth() {
		return 20;
	}

	@Override
	protected void init() {
		super.init();
		this.entityData.define(16, (byte) 0);
	}

	public boolean isSit() {
		return (this.entityData.getByte(16) & 4) != 0;
	}

	public void setSit(boolean flag) {
		byte byte0 = this.entityData.getByte(16);
		if (flag) {
			this.entityData.set(16, (byte) (byte0 | 4));
		} else {
			this.entityData.set(16, (byte) (byte0 & 0xFFFFFFFB));
		}
	}

	public void setHomePos(@Nullable Vec3d homePos) {
		this.homePos = homePos;
	}

	@Nullable
	public Vec3d getHomePos() {
		return homePos;
	}

	@Override
	protected void updatePlayerActionState() {
		if (!this.isSit() && (this.isInWater() || this.onGround)) {
			super.updatePlayerActionState();
			if (random.nextInt(400) == 0) {
				this.setSit(true);
			}
		} else {
			if (random.nextInt(400) == 0 || (this.isInWater() || this.onGround)) {
				this.setSit(false);
			}
		}
		sitAnimation.animateWhen(this.isSit(), this.tickCount);
	}

	@Override
	public boolean hurt(Entity entity, int damage, DamageType type) {
		boolean flag = super.hurt(entity, damage, type);
		if (flag && this.isSit()) {
			this.setSit(false);
		}
		return flag;
	}

	@Override
	protected void jump() {
		if (!this.isSit()) {
			super.jump();
		}
	}

	@Override
	protected void roamRandomPath() {
		super.roamRandomPath();
		if (this.homePos != null) {
			if (this.homePos.squareDistanceTo(Vec3d.createVector(this.x, this.y, this.z)) > 32 * 32) {
				this.pathToEntity = this.world.getEntityPathToXYZ(this, (int) (this.homePos.xCoord), (int) this.homePos.yCoord, (int) (this.homePos.zCoord), 10.0f);
			}
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (this.homePos != null) {
			tag.putDouble("homeX", this.homePos.xCoord);
			tag.putDouble("homeY", this.homePos.yCoord);
			tag.putDouble("homeZ", this.homePos.zCoord);
		}
		tag.putBoolean("Sitting", this.isSit());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.containsKey("homeX") && tag.containsKey("homeY") && tag.containsKey("homeZ")) {
			this.setHomePos(Vec3d.createVector(tag.getDouble("homeX"), tag.getDouble("homeY"), tag.getDouble("homeZ")));
		}
		this.setSit(tag.getBoolean("Sitting"));
	}

	@Override
	public String getEntityTexture() {
		return "/assets/tofucraft/entity/tofunian/tofunian.png";
	}

	@Override
	public String getDefaultEntityTexture() {
		return "/assets/tofucraft/entity/tofunian/tofunian.png";
	}

	@Override
	public String getLivingSound() {
		return "tofucraft.mob.tofunian.tofunian_ambient";
	}

	@Override
	protected String getHurtSound() {
		return "tofucraft.mob.tofunian.tofunian_hurt";
	}

	@Override
	protected String getDeathSound() {
		return "tofucraft.mob.tofunian.tofunian_death";
	}

	protected boolean canDespawn() {
		return false;
	}
}
