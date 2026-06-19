package com.vinii.v2m.world;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
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
                ctx ->
                    replaceSpawn(ctx, EntityType.ZOMBIE, MobCategory.MONSTER, ModEntities.ICID, 1, 4, 95)
            );

        BiomeModifications.create(Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "soul_skeleton_spawn"))
            .add(ModificationPhase.REPLACEMENTS,
                BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY),
                ctx ->
                    replaceSpawn(ctx, EntityType.SKELETON, MobCategory.MONSTER, ModEntities.SOUL_SKELETON, 1, 5, 20)
            );

        BiomeModifications.create(Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "warped_enderman_spawn"))
            .add(ModificationPhase.REPLACEMENTS,
                BiomeSelectors.includeByKey(Biomes.WARPED_FOREST),
                ctx ->
                    replaceSpawn(ctx, EntityType.ENDERMAN, MobCategory.MONSTER, ModEntities.WARPED_ENDERMAN, 1, 4, 1)
            );

        BiomeModifications.addFeature(
            (biomeSelectionContext -> biomeSelectionContext.getBiomeKey() == Biomes.PALE_GARDEN),
            GenerationStep.Decoration.VEGETAL_DECORATION,
            ModVegetationPlacements.PATCH_PALE_PUMPKIN
        );
    }

    protected static void replaceSpawn(
        BiomeModificationContext ctx,
        EntityType<?> type,
        MobCategory category,
        EntityType<?> newType,
        int min, int max, int weight
    ) {
        ctx.getMobSpawnSettings()
            .removeSpawnsOfEntityType(type);
        ctx.getMobSpawnSettings()
            .addSpawn(category,
                new MobSpawnSettings.SpawnerData(
                    newType,
                    min, max
                ),
                weight
            );
    }
}
