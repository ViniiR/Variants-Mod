package com.vinii.v2m.datagen;

import com.vinii.v2m.datagen.loot_table.ModBlockLootTableProvider;
import com.vinii.v2m.datagen.loot_table.ModEntityLootTableProvider;
import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.datagen.tag.ModBlockTagProvider;
import com.vinii.v2m.datagen.tag.ModEntityTypeTagProvider;
import com.vinii.v2m.datagen.tag.ModItemTagProvider;
import com.vinii.v2m.datagen.translation.EnglishUSLangProvider;
import com.vinii.v2m.datagen.translation.PortugueseBRLangProvider;
import com.vinii.v2m.world.ModVegetationFeatures;
import com.vinii.v2m.world.ModVegetationPlacements;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jspecify.annotations.NonNull;

public class ViniisVariantsModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // Recipes
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);

        // Languages
        pack.addProvider(EnglishUSLangProvider::new);
        pack.addProvider(PortugueseBRLangProvider::new);

        // Loot Tables
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModEntityLootTableProvider::new);

        // Tags
        FabricTagsProvider.BlockTagsProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(((output, registries) -> new ModItemTagProvider(output, registries, blockTagProvider)));
        pack.addProvider(ModEntityTypeTagProvider::new);
        pack.addProvider(ModBiomeTagProvider::new);

        // Registry (related to buildRegistry)
        pack.addProvider(ModRegistryProvider::new);
    }

    @Override
    public void buildRegistry(@NonNull RegistrySetBuilder registryBuilder) {
        DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModVegetationFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModVegetationPlacements::bootstrap);
    }
}
