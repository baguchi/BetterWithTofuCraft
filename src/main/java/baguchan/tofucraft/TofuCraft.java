package baguchan.tofucraft;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.crafting.ModCraftings;
import baguchan.tofucraft.entity.EntityTofunian;
import baguchan.tofucraft.entity.ModelTofunian;
import baguchan.tofucraft.entity.RenderTofunian;
import baguchan.tofucraft.item.ModItems;
import baguchan.tofucraft.util.IDUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;


public class TofuCraft implements ModInitializer {
	public static final String MOD_ID = "tofucraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private void handleConfig() {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id", "600");
		prop.setProperty("starting_item_id", "3000");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);
		IDUtils.initIds(
			config.getInt("starting_block_id"),
			config.getInt("starting_item_id"));
		config.updateConfig();
	}

	@Override
    public void onInitialize() {
		handleConfig();
		EntityHelper.createEntity(EntityTofunian.class, new RenderTofunian(new ModelTofunian(), 0.5F), 1001, "Tofunian");
		SoundHelper.addSound(MOD_ID, "block/soul_breath.wav");
		SoundHelper.addSound(MOD_ID, "item/soybean/soy_bean_cracking.wav");
		SoundHelper.addSound(MOD_ID, "item/soybean/soy_bean_cracking2.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_ambient.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_death.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_hurt.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_no.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_yes.wav");
		ModBlocks.createBlocks();
		ModItems.createItems();
		ModCraftings.register();
    }
}
