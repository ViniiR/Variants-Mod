package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PumpkinBlock.class)
public abstract class PumpkinBlockMixin {
    @WrapOperation(
        method = "useItemOn",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"
        )
    )
    private boolean carvePalePumpkin(
        Level instance, BlockPos blockPos, BlockState blockState, int i, Operation<Boolean> original,
        @Local(argsOnly = true) BlockHitResult blockHitResult,
        @Local(argsOnly = true) Player player
    ) {
        // TODO: set enderman grabbable block
        // ETC
        if (instance.getBlockState(blockPos).is(ModBlocks.PALE_PUMPKIN)) {
            Direction direction = blockHitResult.getDirection();
            Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;

            return original.call(instance, blockPos,
                ModBlocks.CARVED_PALE_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction2),
                i
            );
        }
        return original.call(instance, blockPos, blockState, i);
    }

    // TODO: create pale pumpkin seeds and crop
    private void patchPalePumpkinDrops() {
    }
}
