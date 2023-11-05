package baguchan.tofucraft.entity;

import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.model.ModelBiped;

public class RenderTofunian extends MobRenderer<EntityTofunian> {

	public RenderTofunian(ModelBiped modelbase, float shadowSize) {
		super(modelbase, shadowSize);
		//setRenderPassModel(new ModelTofunian());
	}

	/*@Override
	protected boolean shouldRenderPass(EntityTofunian entity, int renderPass, float renderPartialTicks) {
		return setEyeBrightness(entity, renderPass, renderPartialTicks);
	}*/
}
