package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EndermanRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class WarpedEndermanRenderer extends EndermanRenderer {
    public WarpedEndermanRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier WARPED_ENDERMAN_LOCATION = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/enderman/warped_enderman.png");

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull EndermanRenderState state) {
        return WARPED_ENDERMAN_LOCATION;
    }
}
