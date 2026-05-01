package com.vinii.v2m.block.blocks;

import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.mixin.interfaces.PaleSnowGolem;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import org.jspecify.annotations.NonNull;

public class CarvedPalePumpkinBlock extends CarvedPumpkinBlock {
    public CarvedPalePumpkinBlock(Properties properties) {
        super(properties);
        PUMPKINS_PREDICATE = (blockState) -> blockState.is(ModBlocks.CARVED_PALE_PUMPKIN) || blockState.is(ModBlocks.PALE_JACK_O_LANTERN);
    }

    @Override
    protected void onPlace(BlockState blockState, @NonNull Level level, @NonNull BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState2.is(blockState.getBlock())) {
            this.trySpawnPaleSnowGolem(level, blockPos);
        }
    }

    void trySpawnPaleSnowGolem(Level level, BlockPos blockPos) {
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getOrCreateSnowGolemFull().find(level, blockPos);
        if (blockPatternMatch != null) {
            SnowGolem snowGolem = EntityType.SNOW_GOLEM.create(level, EntitySpawnReason.TRIGGERED);
            if (snowGolem != null) {
//              TODO: spawn custom golem
                spawnGolemInWorld(level, blockPatternMatch, snowGolem, blockPatternMatch.getBlock(0, 2, 0).getPos());
                return;
            }
        }
        // Original call
        this.trySpawnGolem(level, blockPos);
    }
}
