package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.blocks.ModChestBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
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
        if (chestRenderState.blockState.getBlock() instanceof ModChestBlock chestBlock) {
            // TODO: check if it's trapped chest
            Material material = getModChestMaterial(chestType, chestBlock.variant);
            ViniisVariantsMod.LOGGER.info("Material {}", material);
            return material;
        }
        return original.call(chestMaterialType, chestType);
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
