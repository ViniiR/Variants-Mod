package com.vinii.v2m.block.blocks;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.entities.ModChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

import java.util.function.Supplier;

public class ModChestBlock extends ChestBlock {
    public ModChestBlock(
        SoundEvent soundEvent,
        SoundEvent soundEvent2,
        Properties properties,
        String woodVariant
    ) {
        super(
            () -> ModBlockEntities.MOD_CHEST_BLOCK_ENTITY,
            soundEvent,
            soundEvent2,
            properties
        );
        this.variant = woodVariant;
    }

    @Override
    public @NonNull BlockEntity newBlockEntity(@NonNull BlockPos blockPos, @NonNull BlockState blockState) {
        return new ModChestBlockEntity(blockPos, blockState);
    }

    // Item register name e.g. "acacia_chest"
    public String variant;
}
