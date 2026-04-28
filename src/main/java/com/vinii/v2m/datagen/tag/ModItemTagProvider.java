package com.vinii.v2m.datagen.tag;

import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    public static String namespace = ViniisVariantsMod.MOD_ID;

    public static final TagKey<Item> MOD_CRAFTING_TABLES = create(Registries.ITEM, "mod_crafting_tables");
    public static final TagKey<Item> MOD_CHESTS = create(Registries.ITEM, "mod_chests");
    public static final TagKey<Item> MOD_TRAPPED_CHESTS = create(Registries.ITEM, "mod_trapped_chests");
    public static final TagKey<Item> MOD_BARRELS = create(Registries.ITEM, "mod_barrels");
    public static final TagKey<Item> MOD_FURNACES = create(Registries.ITEM, "mod_furnaces");

    public static final TagKey<Item> ALL_CRAFTING_TABLES = create(Registries.ITEM, "all_crafting_tables");
    public static final TagKey<Item> ALL_CHESTS = create(Registries.ITEM, "all_chests");
    public static final TagKey<Item> ALL_TRAPPED_CHESTS = create(Registries.ITEM, "all_trapped_chests");
    public static final TagKey<Item> ALL_BARRELS = create(Registries.ITEM, "all_barrels");
    public static final TagKey<Item> ALL_FURNACES = create(Registries.ITEM, "all_furnaces");

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        copy(ModBlockTagProvider.MOD_CRAFTING_TABLES, MOD_CRAFTING_TABLES);
        copy(ModBlockTagProvider.MOD_CHESTS, MOD_CHESTS);
        copy(ModBlockTagProvider.MOD_TRAPPED_CHESTS, MOD_TRAPPED_CHESTS);
        copy(ModBlockTagProvider.MOD_BARRELS, MOD_BARRELS);
        copy(ModBlockTagProvider.MOD_FURNACES, MOD_FURNACES);

        copy(ModBlockTagProvider.ALL_CRAFTING_TABLES, ALL_CRAFTING_TABLES);
        copy(ModBlockTagProvider.ALL_CHESTS, ALL_CHESTS);
        copy(ModBlockTagProvider.ALL_TRAPPED_CHESTS, ALL_TRAPPED_CHESTS);
        copy(ModBlockTagProvider.ALL_BARRELS, ALL_BARRELS);
        copy(ModBlockTagProvider.ALL_FURNACES, ALL_FURNACES);

    }

    public static <T> TagKey<T> create(ResourceKey<? extends Registry<T>> key, String identifier) {
        return TagKey.create(key, Identifier.fromNamespaceAndPath(namespace, identifier));
    }
}
