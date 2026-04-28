package com.vinii.v2m.block.entities;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.blocks.ModChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ModChestBlockEntity extends ChestBlockEntity {
    public ModChestBlockEntity(
        BlockPos blockPos,
        BlockState blockState
    ) {
        super(ModBlockEntities.MOD_CHEST_BLOCK_ENTITY, blockPos, blockState);
    }

    public ModChestBlockEntity(
        Boolean useTheAssFuckingTrappedChest,
        BlockPos blockPos,
        BlockState blockState
    ) {
        super(ModBlockEntities.MOD_TRAPPED_CHEST_BLOCK_ENTITY, blockPos, blockState);
    }

    @Override
    public @NonNull BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_CHEST_BLOCK_ENTITY;
    }

    @Override
    public @NonNull Component getName() {
        return Component.translatable("container." + ViniisVariantsMod.MOD_ID + "." + getChestBlock().variant);
    }

    public ModChestBlock getChestBlock() {
        if (getBlockState().getBlock() instanceof ModChestBlock) {
            return (ModChestBlock) getBlockState().getBlock();
        } else {
            return null;
        }
    }
}
