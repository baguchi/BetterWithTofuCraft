package baguchan.tofucraft.util;

import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.WorldSource;

public class FluidUtils {
	public static double getVector(WorldSource blockAccess, int x, int y, int z, Material material) {
		Vec3d vec3d = getFlowVector(blockAccess, x, y, z, material);

		if (vec3d.xCoord == 0.0 && vec3d.zCoord == 0.0) {
			return -1000.0;
		}
		return Math.atan2(vec3d.zCoord, vec3d.xCoord) - 1.5707963267948966;
	}

	public static Vec3d getFlowVector(WorldSource blockAccess, int x, int y, int z, Material material) {
		Vec3d flowVec = Vec3d.createVector(0.0, 0.0, 0.0);
		int l = getEffectiveFlowDecay(blockAccess, x, y, z, material);
		for (int i1 = 0; i1 < 4; ++i1) {
			int i2;
			int j1 = x;
			int k1 = y;
			int l1 = z;
			if (i1 == 0) {
				--j1;
			}
			if (i1 == 1) {
				--l1;
			}
			if (i1 == 2) {
				++j1;
			}
			if (i1 == 3) {
				++l1;
			}
			if ((i2 = getEffectiveFlowDecay(blockAccess, j1, k1, l1, material)) < 0) {
				if (blockAccess.getBlockMaterial(j1, k1, l1).blocksMotion() || (i2 = getEffectiveFlowDecay(blockAccess, j1, k1 - 1, l1, material)) < 0)
					continue;
				int j2 = i2 - (l - 8);
				flowVec = flowVec.addVector((j1 - x) * j2, (k1 - y) * j2, (l1 - z) * j2);
				continue;
			}
			if (i2 < 0) continue;
			int k2 = i2 - l;
			flowVec = flowVec.addVector((j1 - x) * k2, (k1 - y) * k2, (l1 - z) * k2);
		}
		flowVec = flowVec.normalize();
		return flowVec;
	}

	public static int getEffectiveFlowDecay(WorldSource blockAccess, int x, int y, int z, Material material) {
		if (blockAccess.getBlockMaterial(x, y, z) != material) {
			return -1;
		}
		int meta = blockAccess.getBlockMetadata(x, y, z);
		if (meta >= 8) {
			meta = 0;
		}
		return meta;
	}
}
