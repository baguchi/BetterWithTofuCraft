package baguchan.tofucraft;

import baguchan.tofucraft.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;


public class TofuCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockModelDispatcher dispatcher = BlockModelDispatcher.getInstance();
		dispatcher.addDispatch(ModBlocks.soymilk_flow, new BlockModelRenderBlocks(4));
		dispatcher.addDispatch(ModBlocks.soymilk, new BlockModelRenderBlocks(4));
		dispatcher.addDispatch(ModBlocks.soybean, new BlockModelRenderBlocks(6));
		dispatcher.addDispatch(ModBlocks.wild_soybean, new BlockModelRenderBlocks(6));
	}
}
