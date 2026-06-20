package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import net.minecraft.client.renderer.entity.BlazeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class SoulBlazeRenderer extends BlazeRenderer {
    public SoulBlazeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier SOUL_BLAZE_LOCATION = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/blaze/soul_blaze.png");

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull LivingEntityRenderState state) {
        return SOUL_BLAZE_LOCATION;
    }
}
