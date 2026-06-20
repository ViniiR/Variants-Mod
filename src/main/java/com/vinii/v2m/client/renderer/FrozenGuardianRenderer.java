package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.guardian.GuardianModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.GuardianRenderer;
import net.minecraft.client.renderer.entity.state.GuardianRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class FrozenGuardianRenderer extends GuardianRenderer {
    public FrozenGuardianRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier FROZEN_GUARDIAN_LOCATION =
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/guardian/frozen_guardian.png");

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull GuardianRenderState state) {
        return FROZEN_GUARDIAN_LOCATION;
    }
}
