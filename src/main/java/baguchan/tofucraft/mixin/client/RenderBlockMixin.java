package baguchan.tofucraft.mixin.client;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.util.FluidUtils;
import net.minecraft.client.render.RenderBlocks;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.TextureFX;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.core.Global;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderBlocks.class, remap = false)
public class RenderBlockMixin {
	@Shadow
	private WorldSource blockAccess;
	@Shadow
	private World world;
	@Shadow
	private boolean renderAllFaces = false;

	@Inject(method = "renderBlockFluids", at = @At("HEAD"), cancellable = true)
	public void renderBlockFluids(Block block, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		if (block.id == ModBlocks.soymilk_flow.id || block.id == ModBlocks.soymilk.id) {
			Tessellator tessellator = Tessellator.instance;
			int color = BlockColorDispatcher.getInstance().getDispatch(block).getWorldColor(this.world, x, y, z);
			float colorRed = (float) (color >> 16 & 0xFF) / 255.0f;
			float colorGreen = (float) (color >> 8 & 0xFF) / 255.0f;
			float colorBlue = (float) (color & 0xFF) / 255.0f;
			boolean renderTop = block.shouldSideBeRendered(this.blockAccess, x, y + 1, z, 1);
			boolean flag1 = block.shouldSideBeRendered(this.blockAccess, x, y - 1, z, 0);
			boolean[] aflag = new boolean[]{block.shouldSideBeRendered(this.blockAccess, x, y, z - 1, 2), block.shouldSideBeRendered(this.blockAccess, x, y, z + 1, 3), block.shouldSideBeRendered(this.blockAccess, x - 1, y, z, 4), block.shouldSideBeRendered(this.blockAccess, x + 1, y, z, 5)};
			if (!(renderTop || flag1 || aflag[0] || aflag[1] || aflag[2] || aflag[3])) {
				cir.setReturnValue(false);
			}
			boolean flag2 = false;
			float f3 = 0.5f;
			float f4 = 1.0f;
			float f5 = 0.8f;
			float f6 = 0.6f;
			double d = 0.0;
			double d1 = 1.0;
			Material material = block.blockMaterial;
			int i1 = this.blockAccess.getBlockMetadata(x, y, z);
			float f7 = this.func_1224_a(x, y, z, material);
			float f8 = this.func_1224_a(x, y, z + 1, material);
			float f9 = this.func_1224_a(x + 1, y, z + 1, material);
			float f10 = this.func_1224_a(x + 1, y, z, material);
			if (this.renderAllFaces || renderTop) {
				flag2 = true;
				int j1 = block.getBlockTextureFromSideAndMetadata(Side.TOP, i1);
				float f12 = (float) FluidUtils.getVector(this.blockAccess, x, y, z, material);
				if (f12 > -999.0f) {
					j1 = block.getBlockTextureFromSideAndMetadata(Side.NORTH, i1);
				}
				int i2 = j1 % Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain;
				int k2 = j1 / Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain;
				double d2 = ((double) i2 + (double) (TextureFX.tileWidthTerrain / 2)) / (double) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				double d3 = ((double) k2 + (double) (TextureFX.tileWidthTerrain / 2)) / (double) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				if (f12 < -999.0f) {
					f12 = 0.0f;
				}
				float f14 = MathHelper.sin(f12) * (float) (TextureFX.tileWidthTerrain / 2) / (float) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				float f16 = MathHelper.cos(f12) * (float) (TextureFX.tileWidthTerrain / 2) / (float) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);

				f14 *= 0.5F;
				f16 *= 0.5F;

				float f18 = this.getBlockBrightness(this.blockAccess, x, y, z);
				tessellator.setColorOpaque_F(f4 * f18 * colorRed, f4 * f18 * colorGreen, f4 * f18 * colorBlue);
				tessellator.addVertexWithUV(x + 0, (float) y + f7, z + 0, d2 - (double) f16 - (double) f14, d3 - (double) f16 + (double) f14);
				tessellator.addVertexWithUV(x + 0, (float) y + f8, z + 1, d2 - (double) f16 + (double) f14, d3 + (double) f16 + (double) f14);
				tessellator.addVertexWithUV(x + 1, (float) y + f9, z + 1, d2 + (double) f16 + (double) f14, d3 + (double) f16 - (double) f14);
				tessellator.addVertexWithUV(x + 1, (float) y + f10, z + 0, d2 + (double) f16 - (double) f14, d3 - (double) f16 - (double) f14);
			}
			if (this.renderAllFaces || flag1) {
				float f11 = this.getBlockBrightness(this.blockAccess, x, y - 1, z);
				tessellator.setColorOpaque_F(f3 * f11 * colorRed, f3 * f11 * colorGreen, f3 * f11 * colorBlue);
				this.renderBottomFace(block, x, (float) y + 1.0E-4f, z, block.getBlockTextureFromSideAndMetadata(Side.BOTTOM, i1));
				flag2 = true;
			}
			for (int k1 = 0; k1 < 4; ++k1) {
				float f21;
				float f19;
				float f20;
				float f17;
				float f15;
				float f13;
				int l1 = x;
				int j2 = y;
				int l2 = z;
				if (k1 == 0) {
					--l2;
				}
				if (k1 == 1) {
					++l2;
				}
				if (k1 == 2) {
					--l1;
				}
				if (k1 == 3) {
					++l1;
				}
				int i3 = block.getBlockTextureFromSideAndMetadata(Side.getSideById(k1 + 2), i1);
				int j3 = i3 % Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain;
				int k3 = i3 / Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain;
				if (!this.renderAllFaces && !aflag[k1]) continue;
				if (k1 == 0) {
					f13 = f7;
					f15 = f10;
					f17 = (float) x + 1.0E-4f;
					f20 = (float) (x + 1) - 1.0E-4f;
					f19 = (float) z + 1.0E-4f;
					f21 = (float) z + 1.0E-4f;
				} else if (k1 == 1) {
					f13 = f9;
					f15 = f8;
					f17 = (float) (x + 1) - 1.0E-4f;
					f20 = (float) x + 1.0E-4f;
					f19 = (float) (z + 1) - 1.0E-4f;
					f21 = (float) (z + 1) - 0.001f;
				} else if (k1 == 2) {
					f13 = f8;
					f15 = f7;
					f17 = (float) x + 1.0E-4f;
					f20 = (float) x + 1.0E-4f;
					f19 = (float) (z + 1) - 1.0E-4f;
					f21 = (float) z + 1.0E-4f;
				} else {
					f13 = f10;
					f15 = f9;
					f17 = (float) (x + 1) - 1.0E-4f;
					f20 = (float) (x + 1) - 1.0E-4f;
					f19 = (float) z + 1.0E-4f;
					f21 = (float) (z + 1) - 1.0E-4f;
				}
				flag2 = true;
				double d4 = (float) (j3 + 0) / (float) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				double d5 = ((double) (j3 + TextureFX.tileWidthTerrain) - 0.01) / (double) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				double d6 = ((float) k3 + (1.0f - f13) * (float) TextureFX.tileWidthTerrain) / (float) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				double d7 = ((float) k3 + (1.0f - f15) * (float) TextureFX.tileWidthTerrain) / (float) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				double d8 = ((double) (k3 + TextureFX.tileWidthTerrain) - 0.01) / (double) (TextureFX.tileWidthTerrain * Global.TEXTURE_ATLAS_WIDTH_TILES);
				float f22 = this.getBlockBrightness(this.blockAccess, l1, j2, l2);
				f22 = k1 < 2 ? (f22 *= f5) : (f22 *= f6);
				tessellator.setColorOpaque_F(f4 * f22 * colorRed, f4 * f22 * colorGreen, f4 * f22 * colorBlue);
				tessellator.addVertexWithUV(f17, (float) y + f13, f19, d4, d6);
				tessellator.addVertexWithUV(f20, (float) y + f15, f21, d5, d7);
				tessellator.addVertexWithUV(f20, y + 0, f21, d5, d8);
				tessellator.addVertexWithUV(f17, y + 0, f19, d4, d8);
			}
			block.minY = d;
			block.maxY = d1;
			cir.setReturnValue(flag2);
		}
	}

	@Shadow
	public float getBlockBrightness(WorldSource blockAccess, int x, int y, int z) {
		return 0;
	}

	@Shadow
	private float func_1224_a(int i, int j, int k, Material material) {
		return 0;
	}

	@Shadow
	public void renderBottomFace(Block block, double d, double d1, double d2, int i) {

	}
}
