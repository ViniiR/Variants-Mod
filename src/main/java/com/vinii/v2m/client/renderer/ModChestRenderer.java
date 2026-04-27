package com.vinii.v2m.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import org.jspecify.annotations.NonNull;

public class ModChestRenderer<T extends BlockEntity & LidBlockEntity> extends ChestRenderer<@NonNull T> {
    public ModChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }
}
