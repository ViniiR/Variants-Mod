package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.entities.ModChestBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/world/level/block/ChestBlock$2$1")
public abstract class ChestBlockDoubleBlockCombinerCombinerMenuProviderMixin {
    @WrapOperation(
        method = "getDisplayName",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;)Lnet/minecraft/network/chat/MutableComponent;"
        )
    )
    MutableComponent patchLargeChestName(String string, Operation<MutableComponent> original) {
        if (
            // If somehow two different chests connect, should probably never happen
            // even if it does, minecraft's code might catch it before this
            getFirst().getClass().equals(getSecond().getClass()) &&
                getFirst() instanceof ModChestBlockEntity chestEntity
        ) {
//            if (getFirst() instanceof ModTrappedChestBlockEntity trappedChestBlockEntity){
//                String translatableKey = getTranslatableComponent(trappedChestBlockEntity.getTrappedChestBlock().variant);
//                return Component.translatable(translatableKey);
//            }
            String translatableKey = getTranslatableComponent(chestEntity.getChestBlock().variant);
            return Component.translatable(translatableKey);
        }
        return original.call(string);
    }

    @Unique
    private String getTranslatableComponent(String variant) {
        // variant format is "<woodType>_chest"

        // Following v2m's format <large>_<woodType>_chest
        String value = "large_" + variant;

        return "container." + ViniisVariantsMod.MOD_ID + "." + value;
    }

    @Accessor("val$first")
    public abstract ChestBlockEntity getFirst();

    @Accessor("val$second")
    public abstract ChestBlockEntity getSecond();
}
