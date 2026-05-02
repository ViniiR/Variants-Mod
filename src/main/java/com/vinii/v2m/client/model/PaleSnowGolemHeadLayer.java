package com.vinii.v2m.client.model;

import net.minecraft.client.model.animal.golem.SnowGolemModel;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.SnowGolemHeadLayer;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;

public class PaleSnowGolemHeadLayer extends SnowGolemHeadLayer {
    public PaleSnowGolemHeadLayer(RenderLayerParent<SnowGolemRenderState, SnowGolemModel> renderLayerParent, BlockRenderDispatcher blockRenderDispatcher) {
        super(renderLayerParent, blockRenderDispatcher);
    }
}
