package com.vinii.v2m.tools;

import com.vinii.v2m.ViniisVariantsMod;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.ChestType;

public abstract class ChestRendererTools {
    public static SpriteId getModChestMaterial(ChestType type, String variant) {
        return switch (type) {
            case LEFT -> getModChestMaterialPath(variant + "_left");
            case RIGHT -> getModChestMaterialPath(variant + "_right");
            default -> getModChestMaterialPath(variant);
        };
    }
    public static SpriteId getModChestMaterial(ChestType type, String variant, String prefix) {
        return switch (type) {
            case LEFT -> getModChestMaterialPath(variant + "_left", prefix);
            case RIGHT -> getModChestMaterialPath(variant + "_right", prefix);
            default -> getModChestMaterialPath(variant, prefix);
        };
    }

    private static SpriteId getModChestMaterialPath(String fileName) {
        return new SpriteId(Sheets.CHEST_SHEET,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "entity/chest/" + fileName)
        );
    }
    private static SpriteId getModChestMaterialPath(String fileName, String prefix) {
        return new SpriteId(Sheets.CHEST_SHEET,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "entity/chest/" + prefix + fileName)
        );
    }
}
