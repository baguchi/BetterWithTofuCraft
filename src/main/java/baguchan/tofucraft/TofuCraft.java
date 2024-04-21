package baguchan.tofucraft;

import baguchan.tofucraft.achievement.ModAchievement;
import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.entity.EntityTofunian;
import baguchan.tofucraft.item.ModItems;
import baguchan.tofucraft.util.IDUtils;
import baguchan.tofucraft.world.WorldTypeTofu;
import baguchan.tofucraft.world.biome.ModBiomes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.AchievementHelper;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.achievements.AchievementPage;

import java.util.Properties;


public class TofuCraft implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "tofucraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static AchievementPage tofu_page;

	public static Dimension tofuDimension;
	public static WorldType tofuWorld;
	public static int tofuWorldID;
	public static int entityID;

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id", "2200");
		prop.setProperty("starting_item_id", "30000");
		prop.setProperty("starting_entity_id", "2000");
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
	}


	@Override
	public void beforeGameStart() {
		ModBlocks.createBlocks();
		ModItems.createItems();
		ModBiomes.initializeBiomes();
		EntityHelper.Core.createEntity(EntityTofunian.class, entityID, "Tofunian");

		tofuWorld = WorldTypes.register("tofucraft.worldtype.tofu", new WorldTypeTofu("tofucraft.worldtype.tofu"));
		tofuDimension = new Dimension("tofucraft.dimension.tofu", Dimension.overworld, 1.0f, ModBlocks.tofu_portal.id);
		tofuDimension.setDefaultWorldType(tofuWorld);
		Dimension.registerDimension(tofuWorldID, tofuDimension);

		tofu_page = new ModAchievement();
		AchievementHelper.addPage(tofu_page);
	}

	@Override
	public void afterGameStart() {

	}
}
