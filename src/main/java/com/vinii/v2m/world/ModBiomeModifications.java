package com.vinii.v2m.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeModifications {
    public static void initialize() {
        // TODO: replace zombie spawn on snow biomes
//        BiomeModifications.addSpawn(
//            BiomeSelectors.tag(ModBiomeTagProvider.SNOWY_BIOMES),
//            MobCategory.MONSTER,
//            ModEntities.ICID,
//            95,
//            4,
//            4
//        );
        BiomeModifications.addFeature(
            (biomeSelectionContext -> biomeSelectionContext.getBiomeKey() == Biomes.PALE_GARDEN),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            ModVegetationPlacements.PATCH_PALE_PUMPKIN
        );
    }
}
