package com.vinii.v2m.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeModifications {
    public static void initialize() {
        BiomeModifications.addFeature(
            (biomeSelectionContext -> biomeSelectionContext.getBiomeKey() == Biomes.PALE_GARDEN),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            ModVegetationPlacements.PATCH_PALE_PUMPKIN
        );
    }

    // TODO: remove
    protected static void replaceSpawn(
        BiomeModificationContext ctx,
        EntityType<?> type,
        MobCategory category,
        EntityType<?> newType,
        int min, int max, int weight
    ) {
        var settings = ctx.getMobSpawnSettings();
        settings.removeSpawnsOfEntityType(type);
        settings.addSpawn(category,
            new MobSpawnSettings.SpawnerData(
                newType,
                min, max
            ),
            weight
        );
    }
}
