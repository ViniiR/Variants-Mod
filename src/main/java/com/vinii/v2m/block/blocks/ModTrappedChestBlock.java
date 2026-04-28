package com.vinii.v2m.block.blocks;

import com.mojang.serialization.MapCodec;
import com.vinii.v2m.block.entities.ModTrappedChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ModTrappedChestBlock extends ModChestBlock {
    public ModTrappedChestBlock(
        BlockBehaviour.Properties properties,
        String woodVariant
    ) {
        super(
            true,
            SoundEvents.CHEST_OPEN,
            SoundEvents.CHEST_CLOSE,
            properties,
            woodVariant
        );
    }

    public static final MapCodec<TrappedChestBlock> CODEC = simpleCodec(TrappedChestBlock::new);

    @Override
    public @NonNull MapCodec<TrappedChestBlock> codec() {
        return CODEC;
    }

    @Override
    public @NonNull BlockEntity newBlockEntity(@NonNull BlockPos blockPos, @NonNull BlockState blockState) {
        return new ModTrappedChestBlockEntity(blockPos, blockState);
    }

    @Override
    protected boolean isSignalSource(@NonNull BlockState blockState) {
        return true;
    }

    @Override
    protected int getSignal(@NonNull BlockState blockState, @NonNull BlockGetter blockGetter, @NonNull BlockPos blockPos, @NonNull Direction direction) {
        return Mth.clamp(ChestBlockEntity.getOpenCount(blockGetter, blockPos), 0, 15);
    }

    @Override
    protected int getDirectSignal(@NonNull BlockState blockState, @NonNull BlockGetter blockGetter, @NonNull BlockPos blockPos, @NonNull Direction direction) {
        return direction == Direction.UP ?
            blockState.getSignal(blockGetter, blockPos, direction) :
            0;
    }

    @Override
    protected @NonNull Stat<Identifier> getOpenChestStat() {
        return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
    }
}
