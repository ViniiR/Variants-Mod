package com.vinii.v2m.datagen.tag;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModBiomeTagProvider(
        FabricDataOutput output,
        CompletableFuture<HolderLookup.Provider> registriesFuture
    ) {
        super(output, Registries.BIOME, registriesFuture);
    }

    public static TagKey<Biome> SNOWY_BIOMES = TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "snowy_biomes"));

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        this.getOrCreateRawBuilder(SNOWY_BIOMES)
            .addElement(Biomes.JAGGED_PEAKS.identifier())
            .addElement(Biomes.FROZEN_PEAKS.identifier())

            .addElement(Biomes.GROVE.identifier())
            .addElement(Biomes.SNOWY_SLOPES.identifier())

            .addElement(Biomes.SNOWY_TAIGA.identifier())

            .addElement(Biomes.SNOWY_PLAINS.identifier())
            .addElement(Biomes.ICE_SPIKES.identifier())

            .addElement(Biomes.FROZEN_RIVER.identifier())
        ;
    }
}
