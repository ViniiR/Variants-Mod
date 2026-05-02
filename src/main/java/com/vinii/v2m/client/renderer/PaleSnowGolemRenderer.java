package com.vinii.v2m.client.renderer;

import com.vinii.v2m.client.model.PaleSnowGolemHeadLayer;
import net.minecraft.client.model.animal.golem.SnowGolemModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SnowGolemHeadLayer;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import org.jspecify.annotations.NonNull;

public class PaleSnowGolemRenderer extends MobRenderer<SnowGolem, SnowGolemRenderState, SnowGolemModel> {
    public PaleSnowGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new SnowGolemModel(context.bakeLayer(ModelLayers.SNOW_GOLEM)), 0.5F);
        this.addLayer(new PaleSnowGolemHeadLayer(this, context.getBlockRenderDispatcher()));
    }

    private static final Identifier SNOW_GOLEM_LOCATION = Identifier.withDefaultNamespace("textures/entity/snow_golem.png");

    public @NonNull Identifier getTextureLocation(SnowGolemRenderState snowGolemRenderState) {
        return SNOW_GOLEM_LOCATION;
    }

    public SnowGolemRenderState createRenderState() {
        return new SnowGolemRenderState();
    }

    public void extractRenderState(SnowGolem snowGolem, SnowGolemRenderState snowGolemRenderState, float f) {
        super.extractRenderState(snowGolem, snowGolemRenderState, f);
        snowGolemRenderState.hasPumpkin = snowGolem.hasPumpkin();
    }
}
