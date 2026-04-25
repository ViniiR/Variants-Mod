package com.vinii.v2m.block.blocks;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.entities.ModFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ModFurnaceBlock extends FurnaceBlock {
    public ModFurnaceBlock(Properties properties, String stoneVariant) {
        super(properties);
        this.variant = stoneVariant;
    }

    @Override
    public @NonNull BlockEntity newBlockEntity(@NonNull BlockPos blockPos, @NonNull BlockState blockState) {
        return new ModFurnaceBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
        @NonNull Level level,
        @NonNull BlockState blockState,
        @NonNull BlockEntityType<T> blockEntityType
    ) {
        return ModFurnaceBlock.createFurnaceTicker(level, blockEntityType, ModBlockEntities.MOD_FURNACE_BLOCK_ENTITY);
    }

    public String variant;
}
