package com.vinii.v2m.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.block.blocks.ModChestBlock;
import com.vinii.v2m.block.blocks.ModTrappedChestBlock;
import com.vinii.v2m.tools.ChestRendererTools;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestRenderer.class)
public abstract class ChestRendererMixin {
    @WrapOperation(
        method = "submit(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/Sheets;chooseSprite(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/sprite/SpriteId;"
        )
    )
    private SpriteId patchChestTexture(
        ChestRenderState.ChestMaterialType materialType,
        ChestType type,
        Operation<SpriteId> original,
        @Local(argsOnly = true, name = "state") ChestRenderState state
    ) {
        return switch (state.blockState.getBlock()) {
            case ModTrappedChestBlock modTrappedChestBlock -> //
                ChestRendererTools.getModChestMaterial(type, modTrappedChestBlock.variant, "trapped/");
            case ModChestBlock modChestBlock -> //
                ChestRendererTools.getModChestMaterial(type, modChestBlock.variant);
            case CopperChestBlock ignored -> //
                original.call(materialType, type);
            // Deprecated (Maybe?), moved to SheetsMixin
            case TrappedChestBlock ignored -> //
                ChestRendererTools.getModChestMaterial(type, "trapped_oak_chest", "trapped/");
            case ChestBlock ignored -> //
                ChestRendererTools.getModChestMaterial(type, "oak_chest");
            default -> //
                original.call(materialType, type);
        };
    }
}
