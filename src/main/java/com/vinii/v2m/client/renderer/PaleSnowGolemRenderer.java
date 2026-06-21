package com.vinii.v2m.client.renderer;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.block.BlockModelResolver;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SnowGolemRenderer;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class PaleSnowGolemRenderer extends SnowGolemRenderer {
    public PaleSnowGolemRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.blockModelResolver = context.getBlockModelResolver();
    }

    private final BlockModelResolver blockModelResolver;

    @Override
    public void extractRenderState(@NonNull SnowGolem snowGolem, @NonNull SnowGolemRenderState snowGolemRenderState, float f) {
        super.extractRenderState(snowGolem, snowGolemRenderState, f);

        if (snowGolem.hasPumpkin()) {
            this.blockModelResolver.update(snowGolemRenderState.headBlock, ModBlocks.CARVED_PALE_PUMPKIN.defaultBlockState(), BLOCK_DISPLAY_CONTEXT);
        } else {
            snowGolemRenderState.headBlock.clear();
        }
    }
}
