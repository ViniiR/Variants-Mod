package com.vinii.v2m.block.blocks;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.entities.ModChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ModChestBlock extends ChestBlock {
    // WHY THE  F U C K  DOES PASSING AN  U N U S E D  ARGUMENT TO THIS FUCKING FUNCTION  B R E A K  THE  W H O L E  FUCKING MOD???????????????????????????????????
    public ModChestBlock(
        SoundEvent soundEvent,
        SoundEvent soundEvent2,
        Properties properties,
        String woodVariant
    ) {
        super(() -> ModBlockEntities.MOD_CHEST_BLOCK_ENTITY,
            soundEvent,
            soundEvent2,
            properties
        );
        this.variant = woodVariant;
    }

    public ModChestBlock(
        boolean useTheAssFuckingTrappedChest,
        SoundEvent soundEvent,
        SoundEvent soundEvent2,
        Properties properties,
        String woodVariant
    ) {
        super(() -> ModBlockEntities.MOD_TRAPPED_CHEST_BLOCK_ENTITY,
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
