package com.vinii.v2m.mixin.client;

import com.vinii.v2m.tools.ChestRendererTools;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheets.class)
public abstract class SheetsMixin {
    @Inject(
        method = "chooseSprite",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void patchVanillaChestsTexture(ChestRenderState.ChestMaterialType materialType, ChestType type, CallbackInfoReturnable<SpriteId> cir) {
        if (materialType == ChestRenderState.ChestMaterialType.REGULAR) {
            cir.setReturnValue(ChestRendererTools.getModChestMaterial(type, "oak_chest"));
        } else if (materialType == ChestRenderState.ChestMaterialType.TRAPPED) {
            cir.setReturnValue(ChestRendererTools.getModChestMaterial(type, "trapped_oak_chest", "trapped/"));
        }
    }
}
