package com.vinii.v2m.client;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.client.renderer.IcidRenderer;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ViniisVariantsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(
            ModBlocks.FROSTED_GLASS_PANE,
            ChunkSectionLayer.TRANSLUCENT
        );

        EntityRenderers.register(
            ModEntities.ICID,
            IcidRenderer::new
        );

        BlockEntityRenderers.register(
            ModBlockEntities.MOD_CHEST_BLOCK_ENTITY,
            ChestRenderer::new
        );

        BlockEntityRenderers.register(
            ModBlockEntities.MOD_TRAPPED_CHEST_BLOCK_ENTITY,
            ChestRenderer::new
        );
    }
}
