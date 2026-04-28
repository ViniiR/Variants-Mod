package com.vinii.v2m.datagen;

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
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);

        pack.addProvider(EnglishUSLangProvider::new);
        pack.addProvider(PortugueseBRLangProvider::new);

        pack.addProvider(ModBlockLootTableProvider::new);

        FabricTagProvider.BlockTagProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(((output, registries) -> new ModItemTagProvider(output, registries, blockTagProvider)));
    }
}
