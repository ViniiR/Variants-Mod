package com.vinii.v2m.client.renderer;

import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.client.model.PaleSnowGolemHeadLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.animal.golem.SnowGolemModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import org.jspecify.annotations.NonNull;

import static net.minecraft.client.renderer.entity.SnowGolemRenderer.BLOCK_DISPLAY_CONTEXT;

@Environment(EnvType.CLIENT)
public class PaleSnowGolemRenderer extends MobRenderer<SnowGolem, SnowGolemRenderState, SnowGolemModel> {
    public PaleSnowGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new SnowGolemModel(context.bakeLayer(ModelLayers.SNOW_GOLEM)), 0.5F);
        this.blockModelResolver = context.getBlockModelResolver();
        this.addLayer(new PaleSnowGolemHeadLayer(this));
    }

    private static final Identifier SNOW_GOLEM_LOCATION = Identifier.withDefaultNamespace("textures/entity/snow_golem/snow_golem.png");
    private final BlockModelResolver blockModelResolver;

    public @NonNull Identifier getTextureLocation(SnowGolemRenderState snowGolemRenderState) {
        return SNOW_GOLEM_LOCATION;
    }

    public SnowGolemRenderState createRenderState() {
        return new SnowGolemRenderState();
    }

    public void extractRenderState(SnowGolem snowGolem, SnowGolemRenderState snowGolemRenderState, float f) {
        super.extractRenderState(snowGolem, snowGolemRenderState, f);

        if (snowGolem.hasPumpkin()) {
            this.blockModelResolver.update(snowGolemRenderState.headBlock, ModBlocks.CARVED_PALE_PUMPKIN.defaultBlockState(), BLOCK_DISPLAY_CONTEXT);
        } else {
            snowGolemRenderState.headBlock.clear();
        }
    }
}
