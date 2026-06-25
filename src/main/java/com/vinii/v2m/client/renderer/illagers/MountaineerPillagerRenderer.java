package com.vinii.v2m.client.renderer.illagers;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.entity.entities.illagers.MountaineerPillager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.illager.IllagerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.IllagerRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class MountaineerPillagerRenderer extends IllagerRenderer<MountaineerPillager, IllagerRenderState> {
    public MountaineerPillagerRenderer(final EntityRendererProvider.Context context) {
        super(context, new IllagerModel<>(context.bakeLayer(ModelLayers.ILLUSIONER)), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this));
        this.model.getHat().visible = true;
    }

    private static final Identifier MOUNTAINEER_PILLAGER = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "textures/entity/illager/snow_pillager.png");

    public IllagerRenderState createRenderState() {
        return new IllagerRenderState();
    }

    public @NonNull Identifier getTextureLocation(@NonNull IllagerRenderState state) {
        return MOUNTAINEER_PILLAGER;
    }
}
