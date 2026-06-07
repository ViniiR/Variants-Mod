package com.vinii.v2m.world;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomeModifications {
    public static void initialize() {
        BiomeModifications.create(Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "icid_spawn"))
            .add(ModificationPhase.REPLACEMENTS,
                BiomeSelectors.tag(ModBiomeTagProvider.SNOWY_BIOMES),
                ctx -> {
                    ctx.getMobSpawnSettings()
                        .removeSpawnsOfEntityType(EntityType.ZOMBIE);
                    ctx.getMobSpawnSettings()
                        .addSpawn(MobCategory.MONSTER,
                            new MobSpawnSettings.SpawnerData(
                                ModEntities.ICID,
                                1, 4
                            ),
                            95
                        );
                }
            );

        BiomeModifications.addFeature(
            (biomeSelectionContext -> biomeSelectionContext.getBiomeKey() == Biomes.PALE_GARDEN),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            ModVegetationPlacements.PATCH_PALE_PUMPKIN
        );
    }
}
