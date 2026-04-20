package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class ViniisVariantsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(
            ModBlocks.FROSTED_GLASS_PANE,
            ChunkSectionLayer.TRANSLUCENT
        );

    }
}
