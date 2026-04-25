package com.vinii.v2m.block.blocks;

import com.vinii.v2m.block.entities.ModBarrelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ModBarrelBlock extends BarrelBlock {
    public ModBarrelBlock(Properties properties, String woodVariant) {
        super(properties);
        this.variant = woodVariant;
    }

    @Override
    public @NonNull BlockEntity newBlockEntity(@NonNull BlockPos blockPos, @NonNull BlockState blockState) {
        return new ModBarrelBlockEntity(blockPos, blockState);
    }

    public String variant;
}
