package com.vinii.v2m.mixin;

import com.vinii.v2m.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {
    @Inject(
        method = "placeBlock",
        at = @At(value = "HEAD"),
        cancellable = true
    )
    void handleGlassVariant(BlockPlaceContext blockPlaceContext, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if (!blockState.is(Blocks.GLASS_PANE)) {
            return;
        }
        if (blockPlaceContext.getPlayer() != null && blockPlaceContext.getPlayer().isCrouching()) {
            return;
        }

        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();

        Biome biome = level.getBiome(blockPos).value();
        BlockState customBlockState;

        if (biome.getPrecipitationAt(blockPos, level.getSeaLevel()) == Biome.Precipitation.SNOW) {
            customBlockState = ModBlocks.FROSTED_GLASS_PANE.defaultBlockState();
        } else if (biome.getPrecipitationAt(blockPos, level.getSeaLevel()) == Biome.Precipitation.NONE) {
            customBlockState = ModBlocks.SANDY_GLASS_PANE.defaultBlockState();
        } else {
            return;
        }
        customBlockState = customBlockState.setValue(IronBarsBlock.NORTH, blockState.getValue(IronBarsBlock.NORTH))
            .setValue(IronBarsBlock.SOUTH, blockState.getValue(IronBarsBlock.SOUTH))
            .setValue(IronBarsBlock.WEST, blockState.getValue(IronBarsBlock.WEST))
            .setValue(IronBarsBlock.EAST, blockState.getValue(IronBarsBlock.EAST))
            .setValue(IronBarsBlock.WATERLOGGED, blockState.getValue(IronBarsBlock.WATERLOGGED));

        cir.setReturnValue(blockPlaceContext.getLevel().setBlock(blockPlaceContext.getClickedPos(), customBlockState, 11));
        cir.cancel();
    }
}