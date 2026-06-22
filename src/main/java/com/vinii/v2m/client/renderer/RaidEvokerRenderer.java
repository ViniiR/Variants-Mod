package com.vinii.v2m.client.renderer;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.entity.entities.illagers.RaidEvoker;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EvokerRenderer;
import net.minecraft.client.renderer.entity.state.EvokerRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class RaidEvokerRenderer extends EvokerRenderer<RaidEvoker> {
    public RaidEvokerRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static final Identifier RAID_EVOKER_ILLAGER = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/illager/raid_evoker.png");

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull EvokerRenderState state) {
        return RAID_EVOKER_ILLAGER;
    }
}
