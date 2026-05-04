package com.vinii.v2m.world;

import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeModifications {
    public static void initialize() {
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(ModBiomeTagProvider.SNOWY_BIOMES),
            MobCategory.MONSTER,
            ModEntities.ICID,
            95,
            4,
            4
        );
        BiomeModifications.addFeature(
            (biomeSelectionContext -> biomeSelectionContext.getBiomeKey() == Biomes.PALE_GARDEN),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            ModVegetationPlacements.PATCH_PALE_PUMPKIN
        );
    }
}
