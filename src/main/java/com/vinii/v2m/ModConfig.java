package com.vinii.v2m;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

public final class ModConfig {
    public static ConfigClassHandler<ModConfig> HANDLER = ConfigClassHandler.createBuilder(ModConfig.class)
        .id(Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "config"))
        .serializer(cfg -> GsonConfigSerializerBuilder.create(cfg)
            .setPath(FabricLoader.getInstance().getConfigDir().resolve("v2m.json5"))
            .setJson5(true)
            .build()
        ).build();

    public static boolean DEFAULT_TRUE = true;
    public static boolean DEFAULT_FALSE = false;

    @SerialEntry
    private static Boolean generateUtilityVariants = true;

    public static void setGenerateUtilityVariants(boolean val) {
        generateUtilityVariants = val;
        HANDLER.save();
    }

    public static Boolean getGenerateUtilityVariants() {
        return generateUtilityVariants;
    }

    @SerialEntry
    private static Boolean generateFrostedGlass = true;

    public static void setGenerateFrostedGlass(boolean val) {
        generateFrostedGlass = val;
        HANDLER.save();
    }

    public static Boolean getGenerateFrostedGlass() {
        return generateFrostedGlass;
    }

    @SerialEntry
    private static Boolean generatePaleMansion = true;

    public static void setGeneratePaleMansion(boolean val) {
        generatePaleMansion = val;
        HANDLER.save();
    }

    public static Boolean getGeneratePaleMansion() {
        return generatePaleMansion;
    }

    @SerialEntry
    private static Boolean enableRecipeCompatibility = false;

    public static void setEnableRecipeCompatibility(boolean val) {
        enableRecipeCompatibility = val;
        HANDLER.save();
    }

    public static Boolean getEnableRecipeCompatibility() {
        return enableRecipeCompatibility;
    }
}
