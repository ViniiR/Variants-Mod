package com.vinii.v2m.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.client.model.PaleSnowGolemHeadLayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.layers.SnowGolemHeadLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(SnowGolemHeadLayer.class)
public abstract class SnowGolemHeadLayerMixin {
    @WrapOperation(
        method = "submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;ILnet/minecraft/client/renderer/entity/state/SnowGolemRenderState;FF)V",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/level/block/Blocks;CARVED_PUMPKIN:Lnet/minecraft/world/level/block/Block;",
            opcode = Opcodes.GETSTATIC
        )
    )
    private Block patchPaleSnowGolemHead(Operation<Block> original) {
        if (((SnowGolemHeadLayer) (Object) this) instanceof PaleSnowGolemHeadLayer) {
            return ModBlocks.CARVED_PALE_PUMPKIN;
        }
        return original.call();
    }
}
