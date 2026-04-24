package com.vinii.v2m.datagen;

import com.vinii.v2m.datagen.translation.EnglishUSLangProvider;
import com.vinii.v2m.datagen.translation.PortugueseBRLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.world.level.SpawnData;

public class ViniisVariantsModDataGenerator implements DataGeneratorEntrypoint {
    // TODO: datagen glass panes and icid files too
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModModelProvider::new);

        pack.addProvider(EnglishUSLangProvider::new);
        pack.addProvider(PortugueseBRLangProvider::new);
    }
}
