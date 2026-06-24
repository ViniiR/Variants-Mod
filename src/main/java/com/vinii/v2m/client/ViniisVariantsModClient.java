package com.vinii.v2m.client;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.client.renderer.*;
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
            ModEntities.MUDDY_ZOMBIE,
            MuddyZombieRenderer::new
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
        EntityRenderers.register(
            ModEntities.FROZEN_GUARDIAN,
            FrozenGuardianRenderer::new
        );
        EntityRenderers.register(
            ModEntities.SOUL_BLAZE,
            SoulBlazeRenderer::new
        );
        EntityRenderers.register(ModEntities.RAID_VINDICATOR, RaidVindicatorRenderer::new);
        EntityRenderers.register(ModEntities.RAID_WITCH, RaidWitchRenderer::new);
        EntityRenderers.register(ModEntities.RAID_EVOKER, RaidEvokerRenderer::new);
        EntityRenderers.register(ModEntities.MOUNTAINEER_PILLAGER, MountaineerPillagerRenderer::new);

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
