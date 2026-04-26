package com.vinii.v2m.block.entities;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.blocks.ModBarrelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ModBarrelBlockEntity extends BarrelBlockEntity {
    public ModBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NonNull BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_BARREL_BLOCK_ENTITY;
    }

    @Override
    public @NonNull Component getName() {
        return Component.translatable("container." + ViniisVariantsMod.MOD_ID + "." + getBarrelBlock().variant);
    }

    public ModBarrelBlock getBarrelBlock() {
        if (getBlockState().getBlock() instanceof ModBarrelBlock) {
            return (ModBarrelBlock) getBlockState().getBlock();
        } else {
            return null;
        }
    }
}