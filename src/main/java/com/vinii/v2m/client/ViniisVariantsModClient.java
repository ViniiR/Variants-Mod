package com.vinii.v2m.client;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.client.renderer.IcidRenderer;
import com.vinii.v2m.client.renderer.PaleSnowGolemRenderer;
import com.vinii.v2m.client.renderer.SoulSkeletonRenderer;
import com.vinii.v2m.client.renderer.WarpedEndermanRenderer;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ViniisVariantsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Entities
        EntityRenderers.register(
            ModEntities.ICID,
            IcidRenderer::new
        );
        EntityRenderers.register(
            ModEntities.SOUL_SKELETON,
            SoulSkeletonRenderer::new
        );
        EntityRenderers.register(
            ModEntities.PALE_SNOW_GOLEM,
            PaleSnowGolemRenderer::new
        );
        EntityRenderers.register(
            ModEntities.WARPED_ENDERMAN,
            WarpedEndermanRenderer::new
        );

        // Block entities
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
