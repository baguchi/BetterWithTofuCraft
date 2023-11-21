package baguchan.tofucraft.entity;

import com.mojang.nbt.CompoundTag;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

import javax.annotation.Nullable;

public class EntityTofunian extends EntityAnimal {
	@Nullable
	private Vec3d homePos;
	public EntityTofunian(World world) {
		super(world);
		this.scoreValue = 0;
		this.health = 20;
		this.heightOffset = 0.0F;
		this.footSize = 0.5F;
		this.moveSpeed = 0.85F;
		this.highestSkinVariant = -1;
		this.setSize(0.6F, 1.15F);
		this.setPos(this.x, this.y, this.z);
		this.skinName = "tofunian";
	}

	public void setHomePos(@Nullable Vec3d homePos) {
		this.homePos = homePos;
	}

	@Nullable
	public Vec3d getHomePos() {
		return homePos;
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
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.containsKey("homeX") && tag.containsKey("homeY") && tag.containsKey("homeZ")) {
			this.setHomePos(Vec3d.createVector(tag.getDouble("homeX"), tag.getDouble("homeY"), tag.getDouble("homeZ")));
		}
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
	protected String getLivingSound() {
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
