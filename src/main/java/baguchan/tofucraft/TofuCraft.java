package baguchan.tofucraft;

import baguchan.tofucraft.achievement.ModAchievement;
import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.crafting.ModCraftings;
import baguchan.tofucraft.entity.EntityTofunian;
import baguchan.tofucraft.entity.ModelTofunian;
import baguchan.tofucraft.entity.RenderTofunian;
import baguchan.tofucraft.item.ModItems;
import baguchan.tofucraft.util.IDUtils;
import baguchan.tofucraft.world.WorldTypeTofu;
import baguchan.tofucraft.world.biome.ModBiomes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.AchievementHelper;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.achievements.AchievementPage;

import java.util.Properties;


public class TofuCraft implements ModInitializer, PreLaunchEntrypoint {
	static {
		// DO NOT TOUCH THIS! It's an error prevention method. Thanks Useless!
		try {
			Class.forName("turniplabs.halplibe.HalpLibe");
			Class.forName("net.minecraft.core.block.Block");
			Class.forName("net.minecraft.core.item.Item");
			Class.forName("net.minecraft.core.world.Dimension");
		} catch (ClassNotFoundException ignored) {
		}
	}

	public static final String MOD_ID = "tofucraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static AchievementPage tofu_page;

	public static Dimension tofuDimension;
	public static WorldType tofuWorld;
	public static int tofuWorldID;
	public static int entityID;

	private void handleConfig() {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id", "600");
		prop.setProperty("starting_item_id", "3000");
		prop.setProperty("starting_entity_id", "1000");
		prop.setProperty("tofu_world_id", "3");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);
		IDUtils.initIds(
			config.getInt("starting_block_id"),
			config.getInt("starting_item_id"));
		entityID = config.getInt("starting_entity_id");
		tofuWorldID = config.getInt("tofu_world_id");
		config.updateConfig();
	}

	@Override
    public void onInitialize() {
		EntityHelper.createEntity(EntityTofunian.class, new RenderTofunian(new ModelTofunian(), 0.5F), entityID + 1, "Tofunian");
		SoundHelper.addSound(MOD_ID, "block/soul_breath.wav");
		SoundHelper.addSound(MOD_ID, "item/soybean/soy_bean_cracking.wav");
		SoundHelper.addSound(MOD_ID, "item/soybean/soy_bean_cracking2.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_ambient.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_death.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_hurt.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_no.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_yes.wav");

		SoundHelper.addMusic(MOD_ID, "tofu_world/green_branch.wav");
		SoundHelper.addMusic(MOD_ID, "tofu_world/milky_earth.wav");
		SoundHelper.addMusic(MOD_ID, "tofu_world/rough_ground.wav");
		SoundHelper.addMusic(MOD_ID, "tofu_world/soft.wav");
		SoundHelper.addMusic(MOD_ID, "tofu_world/tofu_road.wav");
    }

	@Override
	public void onPreLaunch() {
		handleConfig();
		ModBlocks.createBlocks();
		ModItems.createItems();
		ModCraftings.register();
		ModBiomes.initializeBiomes();

		tofuWorld = WorldTypes.register("tofucraft.worldtype.tofu", new WorldTypeTofu("tofucraft.worldtype.tofu"));
		tofuDimension = new Dimension("tofucraft.dimension.tofu", Dimension.overworld, 1.0f, ModBlocks.tofu_portal.id);
		tofuDimension.setDefaultWorldType(tofuWorld);
		Dimension.registerDimension(tofuWorldID, tofuDimension);

		tofu_page = new ModAchievement();
		AchievementHelper.addPage(tofu_page);
	}
}
