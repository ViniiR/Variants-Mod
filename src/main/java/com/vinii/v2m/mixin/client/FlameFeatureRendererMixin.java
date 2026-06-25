package com.vinii.v2m.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.entity.ModEntities;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.feature.FlameFeatureRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.sprite.AtlasManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FlameFeatureRenderer.class)
public abstract class FlameFeatureRendererMixin {
    @ModifyVariable(
        method = "renderFlame",
        at = @At("STORE"),
        name = "fire1"
    )
    private TextureAtlasSprite patchSoulBlazeFireTexture1(
        TextureAtlasSprite fire1,
        @Local(argsOnly = true, name = "state") EntityRenderState state,
        @Local(argsOnly = true, name = "atlasManager") AtlasManager atlasManager
    ) {
        if (state.entityType == ModEntities.SOUL_BLAZE) {
            return atlasManager.get(
                Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_0")
            );
        }
        return fire1;
    }

    @ModifyVariable(
        method = "renderFlame",
        at = @At("STORE"),
        name = "fire2"
    )
    private TextureAtlasSprite patchSoulBlazeFireTexture2(
        TextureAtlasSprite fire2,
        @Local(argsOnly = true, name = "state") EntityRenderState state,
        @Local(argsOnly = true, name = "atlasManager") AtlasManager atlasManager
    ) {
        if (state.entityType == ModEntities.SOUL_BLAZE) {
            return atlasManager.get(
                Sheets.BLOCKS_MAPPER.defaultNamespaceApply("soul_fire_1")
            );
        }
        return fire2;
    }
}
