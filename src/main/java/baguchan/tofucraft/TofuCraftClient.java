package baguchan.tofucraft;

import baguchan.tofucraft.block.ModBlocks;
import baguchan.tofucraft.entity.EntityTofunian;
import baguchan.tofucraft.entity.ModelTofunian;
import baguchan.tofucraft.entity.RenderTofunian;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.entity.BenchEntityModel;

import static baguchan.tofucraft.TofuCraft.MOD_ID;


public class TofuCraftClient implements ClientStartEntrypoint {
	public static final BenchEntityModel modelTofunian = ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/tofunian.geo.json", ModelTofunian.class);


	@Override
	public void beforeClientStart() {
		EntityHelper.Client.assignEntityRenderer(EntityTofunian.class, new RenderTofunian(modelTofunian, 0.3F));
		SoundHelper.Client.addSound(MOD_ID, "block/soul_breath.wav");
		SoundHelper.Client.addSound(MOD_ID, "item/soybean/soy_bean_cracking.wav");
		SoundHelper.Client.addSound(MOD_ID, "item/soybean/soy_bean_cracking2.wav");
		SoundHelper.Client.addSound(MOD_ID, "mob/tofunian/tofunian_ambient.wav");
		SoundHelper.Client.addSound(MOD_ID, "mob/tofunian/tofunian_death.wav");
		SoundHelper.Client.addSound(MOD_ID, "mob/tofunian/tofunian_hurt.wav");
		SoundHelper.Client.addSound(MOD_ID, "mob/tofunian/tofunian_no.wav");
		SoundHelper.Client.addSound(MOD_ID, "mob/tofunian/tofunian_yes.wav");

		SoundHelper.Client.addMusic(MOD_ID, "tofu_world/green_branch.wav");
		SoundHelper.Client.addMusic(MOD_ID, "tofu_world/milky_earth.wav");
		SoundHelper.Client.addMusic(MOD_ID, "tofu_world/rough_ground.wav");
		SoundHelper.Client.addMusic(MOD_ID, "tofu_world/soft.wav");
		SoundHelper.Client.addMusic(MOD_ID, "tofu_world/tofu_road.wav");
	}

	@Override
	public void afterClientStart() {
		BlockModelDispatcher dispatcher = BlockModelDispatcher.getInstance();

		dispatcher.addDispatch(ModBlocks.soymilk_flow, new BlockModelRenderBlocks(4));
		dispatcher.addDispatch(ModBlocks.soymilk, new BlockModelRenderBlocks(4));
		dispatcher.addDispatch(ModBlocks.soybean, new BlockModelRenderBlocks(6));
		dispatcher.addDispatch(ModBlocks.wild_soybean, new BlockModelRenderBlocks(6));

	}
}
