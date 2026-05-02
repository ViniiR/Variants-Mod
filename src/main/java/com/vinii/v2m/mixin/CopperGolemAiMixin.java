package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.datagen.tag.ModBlockTagProvider;
import net.minecraft.world.entity.animal.golem.CopperGolemAi;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Predicate;

@Mixin(CopperGolemAi.class)
public abstract class CopperGolemAiMixin {
    @WrapOperation(
        method = "initIdleActivity",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/entity/animal/golem/CopperGolemAi;TRANSPORT_ITEM_DESTINATION_BLOCK:Ljava/util/function/Predicate;",
            opcode = Opcodes.GETSTATIC
        )
    )
    private static Predicate<BlockState> patchCopperGolemAi(Operation<Predicate<BlockState>> original) {
        return (blockState) -> blockState.is(Blocks.CHEST) || blockState.is(Blocks.TRAPPED_CHEST) || blockState.is(ModBlockTagProvider.MOD_CHESTS);
    }
}
