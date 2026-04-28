package com.vinii.v2m.mixin;

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
    Material patchChestTexture(
        ChestRenderState.ChestMaterialType chestMaterialType,
        ChestType chestType,
        Operation<Material> original,
        @Local(argsOnly = true) ChestRenderState chestRenderState
    ) {
        return switch (chestRenderState.blockState.getBlock()) {
            case ModTrappedChestBlock modTrappedChestBlock -> //
                getModChestMaterial(chestType, modTrappedChestBlock.variant, "trapped/");
            case ModChestBlock modChestBlock -> //
                getModChestMaterial(chestType, modChestBlock.variant);
            case TrappedChestBlock ignored -> //
                getModChestMaterial(chestType, "trapped_oak_chest", "trapped/");
            case ChestBlock ignored -> //
                getModChestMaterial(chestType, "oak_chest");
            default -> //
                original.call(chestMaterialType, chestType);
        };
    }

    @Unique
    private static Material getModChestMaterial(ChestType type, String variant) {
        return switch (type) {
            case LEFT -> getModChestMaterialPath(variant + "_left");
            case RIGHT -> getModChestMaterialPath(variant + "_right");
            default -> getModChestMaterialPath(variant);
        };
    }

    @Unique
    private static Material getModChestMaterial(ChestType type, String variant, String prefix) {
        return switch (type) {
            case LEFT -> getModChestMaterialPath(variant + "_left", prefix);
            case RIGHT -> getModChestMaterialPath(variant + "_right", prefix);
            default -> getModChestMaterialPath(variant, prefix);
        };
    }

    @Unique
    private static Material getModChestMaterialPath(String fileName) {
        return new Material(Sheets.CHEST_SHEET,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "entity/chest/" + fileName)
        );
    }

    @Unique
    private static Material getModChestMaterialPath(String fileName, String prefix) {
        return new Material(Sheets.CHEST_SHEET,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "entity/chest/" + prefix + fileName)
        );
    }
}
