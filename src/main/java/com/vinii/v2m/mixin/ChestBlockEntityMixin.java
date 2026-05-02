package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.blocks.ModChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestBlockEntity.class)
public abstract class ChestBlockEntityMixin extends BlockEntity {
    private ChestBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @WrapOperation(
        method = "getDefaultName",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/level/block/entity/ChestBlockEntity;DEFAULT_NAME:Lnet/minecraft/network/chat/Component;",
            opcode = Opcodes.GETSTATIC
        )
    )
    private Component patchCopperChestName(Operation<Component> original) {
        Block block = getBlockState().getBlock();

        if (block instanceof CopperChestBlock) {
            return Component.translatable("container." + ViniisVariantsMod.MOD_ID + ".copper_chest");
        }

        // May Affect vanilla chests in the future but shouldn't affect any modded chests
        if (block.getClass().equals(ChestBlock.class) || block.getClass().equals(TrappedChestBlock.class)) {
            return Component.translatable("container." + ViniisVariantsMod.MOD_ID + ".oak_chest");
        }
        return original.call();
    }
}
