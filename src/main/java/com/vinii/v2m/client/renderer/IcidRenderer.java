package com.vinii.v2m.client.renderer;

import com.vinii.v2m.entity.entities.Icid;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

@Environment(EnvType.CLIENT)
public class IcidRenderer extends AbstractDualLayeredZombieRenderer<Icid> {
    public IcidRenderer(EntityRendererProvider.Context context) {
        super(
            context,
            "textures/entity/zombie/icid.png",
            "textures/entity/zombie/icid_baby.png",
            "textures/entity/zombie/icid_outer_layer.png",
            "textures/entity/zombie/icid_outer_layer_baby.png"
        );
    }
}
