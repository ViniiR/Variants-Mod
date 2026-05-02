package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.block.blocks.CarvedPalePumpkinBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public abstract class CarvedPumpkinBlockMixin {
    @Unique
    private static final Predicate<BlockState> MOD_PUMPKIN_PREDICATE =
        (blockState) -> blockState.is(ModBlocks.CARVED_PALE_PUMPKIN) || blockState.is(ModBlocks.PALE_JACK_O_LANTERN);

    @WrapOperation(
        method = "getOrCreateIronGolemFull",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/level/block/CarvedPumpkinBlock;PUMPKINS_PREDICATE:Ljava/util/function/Predicate;",
            opcode = Opcodes.GETSTATIC
        )
    )
    private Predicate<BlockState> patchPalePumpkinIronGolemSpawn(Operation<Predicate<BlockState>> original) {
        if (((Object) this) instanceof CarvedPalePumpkinBlock) {
            return MOD_PUMPKIN_PREDICATE;
        }
        return original.call();
    }

    @WrapOperation(
        method = "getOrCreateCopperGolemFull",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/level/block/CarvedPumpkinBlock;PUMPKINS_PREDICATE:Ljava/util/function/Predicate;",
            opcode = Opcodes.GETSTATIC
        )
    )
    private Predicate<BlockState> patchPalePumpkinCopperGolemSpawn(Operation<Predicate<BlockState>> original) {
        if (((Object) this) instanceof CarvedPalePumpkinBlock) {
            return MOD_PUMPKIN_PREDICATE;
        }
        return original.call();
    }
}
