package com.vinii.v2m.client.renderer.illagers;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitchRenderer;
import net.minecraft.client.renderer.entity.state.WitchRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class RaidWitchRenderer  extends WitchRenderer {
    public RaidWitchRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier RAID_WITCH = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/illager/raid_witch.png");

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull WitchRenderState state) {
        return RAID_WITCH;
    }
}
