package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class SoulSkeletonRenderer extends SkeletonRenderer {
    public SoulSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier SOUL_SKELETON_LOCATION = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/skeleton/soul_skeleton.png");

    public @NonNull Identifier getTextureLocation(final @NonNull SkeletonRenderState state) {
        return SOUL_SKELETON_LOCATION;
    }
}
