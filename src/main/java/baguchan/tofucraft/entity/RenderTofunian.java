package baguchan.tofucraft.entity;

import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;

public class RenderTofunian extends LivingRenderer<EntityTofunian> {

	public RenderTofunian(ModelBase modelbase, float shadowSize) {
		super(modelbase, shadowSize);
		//setRenderPassModel(new ModelTofunian());
	}

	/*@Override
	protected boolean shouldRenderPass(EntityTofunian entity, int renderPass, float renderPartialTicks) {
		return setEyeBrightness(entity, renderPass, renderPartialTicks);
	}*/
}
