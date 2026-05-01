package com.vinii.v2m;

import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;

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
    }
}
