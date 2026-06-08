package com.vinii.v2m.datagen.tag;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagsProvider<Biome> {
    public ModBiomeTagProvider(
        FabricPackOutput output,
        CompletableFuture<HolderLookup.Provider> registriesFuture
    ) {
        super(output, Registries.BIOME, registriesFuture);
    }

    public static TagKey<Biome> SNOWY_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "snowy_biomes"));

    public static TagKey<Biome> OAK_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "oak_variant_biomes"));
    public static TagKey<Biome> BIRCH_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "birch_variant_biomes"));
    public static TagKey<Biome> SPRUCE_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "spruce_variant_biomes"));
    public static TagKey<Biome> ACACIA_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "acacia_variant_biomes"));
    public static TagKey<Biome> JUNGLE_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "jungle_variant_biomes"));
    public static TagKey<Biome> BAMBOO_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "bamboo_variant_biomes"));
    public static final TagKey<Biome> DARK_OAK_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "dark_oak_variant_biomes"));
    public static final TagKey<Biome> MANGROVE_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "mangrove_variant_biomes"));
    public static final TagKey<Biome> CHERRY_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "cherry_variant_biomes"));
    public static final TagKey<Biome> PALE_OAK_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "pale_oak_variant_biomes"));
    public static final TagKey<Biome> CRIMSON_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "crimson_variant_biomes"));
    public static final TagKey<Biome> WARPED_VARIANT_BIOMES = TagKey.create(Registries.BIOME,
        Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "warped_variant_biomes"));

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

        this.getOrCreateRawBuilder(SPRUCE_VARIANT_BIOMES)
            .addElement(Biomes.TAIGA.identifier())
            .addElement(Biomes.OLD_GROWTH_SPRUCE_TAIGA.identifier())
            .addElement(Biomes.OLD_GROWTH_PINE_TAIGA.identifier())

            .addElement(Biomes.WINDSWEPT_FOREST.identifier())
            .addElement(Biomes.WINDSWEPT_HILLS.identifier())
            .addElement(Biomes.WINDSWEPT_GRAVELLY_HILLS.identifier())

            .addElement(Biomes.SNOWY_SLOPES.identifier())
            .addElement(Biomes.SNOWY_PLAINS.identifier())
            .addElement(Biomes.SNOWY_TAIGA.identifier())
            .addElement(Biomes.ICE_SPIKES.identifier())
            .addElement(Biomes.GROVE.identifier())

            .addElement(Biomes.FROZEN_PEAKS.identifier())
            .addElement(Biomes.JAGGED_PEAKS.identifier())

            .addElement(Biomes.SNOWY_BEACH.identifier())

            .addElement(Biomes.COLD_OCEAN.identifier())
            .addElement(Biomes.DEEP_COLD_OCEAN.identifier())
            .addElement(Biomes.FROZEN_OCEAN.identifier())
            .addElement(Biomes.DEEP_FROZEN_OCEAN.identifier())
            .addElement(Biomes.FROZEN_RIVER.identifier())
        ;

        this.getOrCreateRawBuilder(BIRCH_VARIANT_BIOMES)
            .addElement(Biomes.BIRCH_FOREST.identifier())
            .addElement(Biomes.OLD_GROWTH_BIRCH_FOREST.identifier())
            .addElement(Biomes.MEADOW.identifier())
        ;

        this.getOrCreateRawBuilder(JUNGLE_VARIANT_BIOMES)
            .addElement(Biomes.JUNGLE.identifier())
            .addElement(Biomes.SPARSE_JUNGLE.identifier())

            .addElement(Biomes.WARM_OCEAN.identifier())
        ;

        this.getOrCreateRawBuilder(BAMBOO_VARIANT_BIOMES)
            .addElement(Biomes.BAMBOO_JUNGLE.identifier())
        ;

        this.getOrCreateRawBuilder(ACACIA_VARIANT_BIOMES)
            .addElement(Biomes.SAVANNA.identifier())
            .addElement(Biomes.SAVANNA_PLATEAU.identifier())
            .addElement(Biomes.WINDSWEPT_SAVANNA.identifier())
            .addElement(Biomes.DESERT.identifier())
        ;

        this.getOrCreateRawBuilder(DARK_OAK_VARIANT_BIOMES)
            // NOTE: maybe add badlands biomes here but natural trees there are oak
            .addElement(Biomes.DARK_FOREST.identifier())
        ;

        this.getOrCreateRawBuilder(MANGROVE_VARIANT_BIOMES)
            .addElement(Biomes.MANGROVE_SWAMP.identifier())
        ;

        this.getOrCreateRawBuilder(CHERRY_VARIANT_BIOMES)
            .addElement(Biomes.CHERRY_GROVE.identifier())
        ;

        this.getOrCreateRawBuilder(PALE_OAK_VARIANT_BIOMES)
            .addElement(Biomes.PALE_GARDEN.identifier())
        ;

        this.getOrCreateRawBuilder(CRIMSON_VARIANT_BIOMES)
            .addElement(Biomes.CRIMSON_FOREST.identifier())
            .addElement(Biomes.NETHER_WASTES.identifier())
            .addElement(Biomes.BASALT_DELTAS.identifier())
        ;

        this.getOrCreateRawBuilder(WARPED_VARIANT_BIOMES)
            .addElement(Biomes.WARPED_FOREST.identifier())
            .addElement(Biomes.SOUL_SAND_VALLEY.identifier())
        ;
    }
}
