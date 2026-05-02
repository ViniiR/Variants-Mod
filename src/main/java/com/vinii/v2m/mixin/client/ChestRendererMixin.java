package com.vinii.v2m.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.blocks.ModChestBlock;
import com.vinii.v2m.block.blocks.ModTrappedChestBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestRenderer.class)
public abstract class ChestRendererMixin {
    @WrapOperation(
        method = "submit(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/CameraRenderState;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/Sheets;chooseMaterial(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/Material;"
        )
    )
    private Material patchChestTexture(
        ChestRenderState.ChestMaterialType chestMaterialType,
        ChestType chestType,
        Operation<Material> original,
        @Local(argsOnly = true) ChestRenderState chestRenderState
    ) {
        return switch (chestRenderState.blockState.getBlock()) {
            case ModTrappedChestBlock modTrappedChestBlock -> //
                v2m$getModChestMaterial(chestType, modTrappedChestBlock.variant, "trapped/");
            case ModChestBlock modChestBlock -> //
                v2m$getModChestMaterial(chestType, modChestBlock.variant);
            case CopperChestBlock ignored -> //
                original.call(chestMaterialType, chestType);
            case TrappedChestBlock ignored -> //
                v2m$getModChestMaterial(chestType, "trapped_oak_chest", "trapped/");
            case ChestBlock ignored -> //
                v2m$getModChestMaterial(chestType, "oak_chest");
            default -> //
                original.call(chestMaterialType, chestType);
        };
    }

    @Unique
    private static Material v2m$getModChestMaterial(ChestType type, String variant) {
        return switch (type) {
            case LEFT -> v2m$getModChestMaterialPath(variant + "_left");
            case RIGHT -> v2m$getModChestMaterialPath(variant + "_right");
            default -> v2m$getModChestMaterialPath(variant);
        };
    }

    @Unique
    private static Material v2m$getModChestMaterial(ChestType type, String variant, String prefix) {
        return switch (type) {
            case LEFT -> v2m$getModChestMaterialPath(variant + "_left", prefix);
            case RIGHT -> v2m$getModChestMaterialPath(variant + "_right", prefix);
            default -> v2m$getModChestMaterialPath(variant, prefix);
        };
    }

    @Unique
    private static Material v2m$getModChestMaterialPath(String fileName) {
        return new Material(Sheets.CHEST_SHEET,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "entity/chest/" + fileName)
        );
    }

    @Unique
    private static Material v2m$getModChestMaterialPath(String fileName, String prefix) {
        return new Material(Sheets.CHEST_SHEET,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "entity/chest/" + prefix + fileName)
        );
    }
}
