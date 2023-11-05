package baguchan.tofucraft;

import baguchan.tofucraft.entity.EntityTofunian;
import baguchan.tofucraft.entity.ModelTofunian;
import baguchan.tofucraft.entity.RenderTofunian;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;


public class TofuCraft implements ModInitializer {
	public static final String MOD_ID = "tofucraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
    public void onInitialize() {
		EntityHelper.createEntity(EntityTofunian.class, new RenderTofunian(new ModelTofunian(), 0.5F), 1001, "Tofunian");
		SoundHelper.addSound(MOD_ID, "block/soul_breath.wav");
		SoundHelper.addSound(MOD_ID, "item/soybean/soy_bean_cracking.wav");
		SoundHelper.addSound(MOD_ID, "item/soybean/soy_bean_cracking2.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_ambient.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_death.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_hurt.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_no.wav");
		SoundHelper.addSound(MOD_ID, "mob/tofunian/tofunian_yes.wav");
    }
}
