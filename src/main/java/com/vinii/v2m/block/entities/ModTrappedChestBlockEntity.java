package com.vinii.v2m.block.entities;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.blocks.ModTrappedChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.ExperimentalRedstoneUtils;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.NonNull;

public class ModTrappedChestBlockEntity extends ModChestBlockEntity {
    public ModTrappedChestBlockEntity(
        BlockPos blockPos,
        BlockState blockState
    ) {
        super(true, blockPos, blockState);
    }

    @Override
    public @NonNull BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_TRAPPED_CHEST_BLOCK_ENTITY;
    }

    @Override
    public @NonNull Component getName() {
        String variant = getTrappedChestBlock().variant;
        if (variant.contains("trapped_")) {
            variant = variant.substring(8);
        }
        return Component.translatable("container." + ViniisVariantsMod.MOD_ID + "." + variant);
    }

    public ModTrappedChestBlock getTrappedChestBlock() {
        if (getBlockState().getBlock() instanceof ModTrappedChestBlock) {
            return (ModTrappedChestBlock) getBlockState().getBlock();
        } else {
            return null;
        }
    }

    @Override
    protected void signalOpenCount(
        @NonNull Level level,
        @NonNull BlockPos blockPos,
        @NonNull BlockState blockState,
        int oldViewerCount,
        int newViewerCount
    ) {
        super.signalOpenCount(level, blockPos, blockState, oldViewerCount, newViewerCount);

        if (oldViewerCount != newViewerCount) {
            Block block = blockState.getBlock();

            // Compatibility with redstone experiment
            Orientation orientation = ExperimentalRedstoneUtils.initialOrientation(
                level,
                blockState.getValue(TrappedChestBlock.FACING).getOpposite(),
                Direction.UP
            );

            // Update neighbors (send redstone signal)
            level.updateNeighborsAt(blockPos, block, orientation);
            level.updateNeighborsAt(blockPos.below(), block, orientation);
        }
    }
}
