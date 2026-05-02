package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.entities.ModChestBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/world/level/block/ChestBlock$2$1")
public abstract class ChestBlockDoubleBlockCombinerCombinerMenuProviderMixin {
    @Shadow
    @Final
    private ChestBlockEntity val$first;

    @WrapOperation(
        method = "getDisplayName",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;"
        )
    )
    private MutableComponent patchLargeChestName(String string, Operation<MutableComponent> original) {
        Block first = getFirst().getBlockState().getBlock();

        if (first instanceof CopperChestBlock) {
            return Component.translatable("container." + ViniisVariantsMod.MOD_ID + ".large_copper_chest");
        }

        // May Affect vanilla chests in the future but shouldn't affect any modded chests
        if (first.getClass().equals(ChestBlock.class) || first.getClass().equals(TrappedChestBlock.class)) {
            return Component.translatable("container." + ViniisVariantsMod.MOD_ID + ".large_oak_chest");
        }

        if (
            // If somehow two different chests connect, should probably never happen
            // even if it does, minecraft's code might catch it before this
            getFirst().getClass().equals(getSecond().getClass()) &&
                getFirst() instanceof ModChestBlockEntity chestEntity
        ) {
            String translatableKey = v2m$getTranslatableComponent(chestEntity.getChestBlock().variant);
            return Component.translatable(translatableKey);
        }

        return original.call(string);
    }

    @Unique
    private static String v2m$getTranslatableComponent(String variant) {
        // variant format is "<woodType>_chest"

        // Following v2m's format <large>_<woodType>_chest
        String value = "large_" + variant;

        return "container." + ViniisVariantsMod.MOD_ID + "." + value;
    }

    @Accessor("val$first")
    protected abstract ChestBlockEntity getFirst();

    @Accessor("val$second")
    protected abstract ChestBlockEntity getSecond();
}
