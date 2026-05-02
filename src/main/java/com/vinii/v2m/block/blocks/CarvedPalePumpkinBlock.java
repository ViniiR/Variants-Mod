package com.vinii.v2m.block.blocks;

import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class CarvedPalePumpkinBlock extends CarvedPumpkinBlock {
    public CarvedPalePumpkinBlock(Properties properties) {
        super(properties);
    }

    private @Nullable BlockPattern paleSnowGolemFull;

    @Override
    protected void onPlace(@NonNull BlockState blockState, @NonNull Level level, @NonNull BlockPos blockPos, @NonNull BlockState blockState2, boolean bl) {
        this.trySpawnPaleSnowGolem(level, blockPos);
    }

    private void trySpawnPaleSnowGolem(Level level, BlockPos blockPos) {
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getOrCreatePaleSnowGolemFull().find(level, blockPos);

        if (blockPatternMatch != null) {
            SnowGolem snowGolem = ModEntities.PALE_SNOW_GOLEM.create(level, EntitySpawnReason.TRIGGERED);
            if (snowGolem != null) {
                spawnGolemInWorld(level, blockPatternMatch, snowGolem, blockPatternMatch.getBlock(0, 2, 0).getPos());
            }
        }

        this.trySpawnGolem(level, blockPos);
    }

    private BlockPattern getOrCreatePaleSnowGolemFull() {
        if (this.paleSnowGolemFull == null) {
            this.paleSnowGolemFull = BlockPatternBuilder.start()
                .aisle("^", "#", "#")
                .where('^', BlockInWorld.hasState((blockState) ->
                    blockState.is(ModBlocks.CARVED_PALE_PUMPKIN) || blockState.is(ModBlocks.PALE_JACK_O_LANTERN)
                ))
                .where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.paleSnowGolemFull;
    }
}
