package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.VindicatorRenderer;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class RaidVindicatorRenderer extends VindicatorRenderer {
    public RaidVindicatorRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier RAID_VINDICATOR = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/illager/raid_vindicator.png");

    @Override
    public @NonNull Identifier getTextureLocation(final @NonNull IllagerRenderState state) {
        return RAID_VINDICATOR;
    }
}
