package com.vinii.v2m.client.renderer;

import com.vinii.v2m.entity.entities.MuddyZombie;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

@Environment(EnvType.CLIENT)
public class MuddyZombieRenderer extends AbstractDualLayeredZombieRenderer<MuddyZombie> {
    public MuddyZombieRenderer(EntityRendererProvider.Context context) {
        super(
            context,
            "textures/entity/zombie/muddy_zombie.png",
            "textures/entity/zombie/muddy_zombie_baby.png",
            "textures/entity/zombie/muddy_zombie_outer_layer.png",
            "textures/entity/zombie/muddy_zombie_outer_layer_baby.png"
        );
    }
}
