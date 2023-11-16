package baguchan.tofucraft.achievement;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.item.ModItems;
import net.minecraft.client.render.TextureFX;
import net.minecraft.core.Global;
import net.minecraft.core.achievement.Achievement;
import net.minecraft.core.achievement.AchievementList;
import net.minecraft.core.achievement.stat.StatBase;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
import org.lwjgl.opengl.GL11;
import turniplabs.halplibe.util.achievements.AchievementPage;
import turniplabs.halplibe.util.achievements.GuiAchievements;

import java.util.Random;

public class ModAchievement extends AchievementPage {
	public static Achievement MAKE_BITTERN = new Achievement(AchievementList.achievementList.size() + 1, "tofucraft.make_bittern", 0, 0, ModItems.bittern_bucket, null);
	public static Achievement HARDEN_TO_TOFU = new Achievement(AchievementList.achievementList.size() + 1, "tofucraft.harden_to_tofu", 3, 0, ModItems.bittern_jar, MAKE_BITTERN);

	public ModAchievement() {
		super("TofuCraft", "achievements.page.tofucraft");
		((StatBase) MAKE_BITTERN).registerStat();
		achievementList.add(MAKE_BITTERN);
		achievementList.add(HARDEN_TO_TOFU);
	}

	@Override
	public void getBackground(GuiAchievements guiAchievements, Random random, int iOffset, int jOffset, int blockX1, int blockY1, int blockX2, int blockY2) {
		int l7 = 0;
		while (l7 * 16 - blockY2 < 155) {
			float f5 = 0.6f - (float) (blockY1 + l7) / 25.0f * 0.3f;
			GL11.glColor4f(f5, f5, f5, 1.0f);
			int i8 = 0;
			while (i8 * 16 - blockX2 < 224) {
				random.setSeed(1234 + blockX1 + i8);
				random.nextInt();
				int j8 = random.nextInt(1 + blockY1 + l7) + (blockY1 + l7) / 2;
				int k8 = ModBlocks.momen_tofu.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				if (j8 > 37 || blockY1 + l7 == 35) {
					k8 = Block.bedrock.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				} else if (j8 == 22) {
					//k8 = random.nextInt(2) == 0 ? Block.oreDiamondStone.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0) : Block.oreRedstoneStone.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				} else if (j8 == 10) {
					//k8 = Block.oreIronStone.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				} else if (j8 == 8) {
					//k8 = Block.oreCoalStone.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				} else if (j8 > 4) {
					k8 = ModBlocks.ishi_tofu.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				} else if (j8 > 0) {
					//k8 = Block.dirt.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
				}
				guiAchievements.drawTexturedModalRect(iOffset + i8 * 16 - blockX2, jOffset + l7 * 16 - blockY2, k8 % Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain, k8 / Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain, 16, 16, TextureFX.tileWidthTerrain, 1.0f / (float) (Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain));
				++i8;
			}
			++l7;
		}
	}
}
