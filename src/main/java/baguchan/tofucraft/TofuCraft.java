package baguchan.tofucraft;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.SoundHelper;


public class TofuCraft implements ModInitializer {
	public static final String MOD_ID = "tofucraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");
		SoundHelper.addSound(MOD_ID, "block/soul_breath");
		SoundHelper.addSound(MOD_ID, "item/soy_bean_cracking");
		SoundHelper.addSound(MOD_ID, "item/soy_bean_cracking2");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_ambient");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_death");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_hurt");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_no");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_yes");
    }
}
