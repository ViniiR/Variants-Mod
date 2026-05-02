package com.vinii.v2m.datagen;

import com.vinii.v2m.datagen.loot_table.ModBlockLootTableProvider;
import com.vinii.v2m.datagen.loot_table.ModEntityLootTableProvider;
import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.datagen.tag.ModBlockTagProvider;
import com.vinii.v2m.datagen.tag.ModItemTagProvider;
import com.vinii.v2m.datagen.translation.EnglishUSLangProvider;
import com.vinii.v2m.datagen.translation.PortugueseBRLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

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
        FabricTagProvider.BlockTagProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(((output, registries) -> new ModItemTagProvider(output, registries, blockTagProvider)));

        pack.addProvider((ModBiomeTagProvider::new));
    }
}
