package com.vinii.v2m.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public abstract class TranslationProvider extends FabricLanguageProvider {
    protected TranslationProvider(FabricDataOutput dataOutput, String languageCode, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, languageCode, registryLookup);
    }

    // WARNING: vanilla keys must be added manually with JSON

    protected String ICID = "Icid";

    protected String SPRUCE_CRAFTING_TABLE = "Spruce Crafting Table";
    protected String BIRCH_CRAFTING_TABLE = "Birch Crafting Table";
    protected String DARK_OAK_CRAFTING_TABLE = "Dark Oak Crafting Table";
    protected String PALE_OAK_CRAFTING_TABLE = "Pale Oak Crafting Table";
    protected String ACACIA_CRAFTING_TABLE = "Acacia Crafting Table";
    protected String JUNGLE_CRAFTING_TABLE = "Jungle Crafting Table";
    protected String MANGROVE_CRAFTING_TABLE = "Mangrove Crafting Table";
    protected String CHERRY_CRAFTING_TABLE = "Cherry Crafting Table";
    protected String BAMBOO_CRAFTING_TABLE = "Bamboo Crafting Table";
    protected String CRIMSON_CRAFTING_TABLE = "Crimson Crafting Table";
    protected String WARPED_CRAFTING_TABLE = "Warped Crafting Table";

    protected String SPRUCE_CHEST = "Spruce Chest";
    protected String BIRCH_CHEST = "Birch Chest";
    protected String DARK_OAK_CHEST = "Dark Oak Chest";
    protected String PALE_OAK_CHEST = "Pale Oak Chest";
    protected String ACACIA_CHEST = "Acacia Chest";
    protected String JUNGLE_CHEST = "Jungle Chest";
    protected String MANGROVE_CHEST = "Mangrove Chest";
    protected String CHERRY_CHEST = "Cherry Chest";
    protected String BAMBOO_CHEST = "Bamboo Chest";
    protected String CRIMSON_CHEST = "Crimson Chest";
    protected String WARPED_CHEST = "Warped Chest";

    protected String LARGE_SPRUCE_CHEST = "Large " + SPRUCE_CHEST;
    protected String LARGE_BIRCH_CHEST = "Large " + BIRCH_CHEST;
    protected String LARGE_DARK_OAK_CHEST = "Large " + DARK_OAK_CHEST;
    protected String LARGE_PALE_OAK_CHEST = "Large " + PALE_OAK_CHEST;
    protected String LARGE_ACACIA_CHEST = "Large " + ACACIA_CHEST;
    protected String LARGE_JUNGLE_CHEST = "Large " + JUNGLE_CHEST;
    protected String LARGE_MANGROVE_CHEST = "Large " + MANGROVE_CHEST;
    protected String LARGE_CHERRY_CHEST = "Large " + CHERRY_CHEST;
    protected String LARGE_BAMBOO_CHEST = "Large " + BAMBOO_CHEST;
    protected String LARGE_CRIMSON_CHEST = "Large " + CRIMSON_CHEST;
    protected String LARGE_WARPED_CHEST = "Large " + WARPED_CHEST;

    protected String TRAPPED_SPRUCE_CHEST = "Trapped " + SPRUCE_CHEST;
    protected String TRAPPED_BIRCH_CHEST = "Trapped " + BIRCH_CHEST;
    protected String TRAPPED_DARK_OAK_CHEST = "Trapped " + DARK_OAK_CHEST;
    protected String TRAPPED_PALE_OAK_CHEST = "Trapped " + PALE_OAK_CHEST;
    protected String TRAPPED_ACACIA_CHEST = "Trapped " + ACACIA_CHEST;
    protected String TRAPPED_JUNGLE_CHEST = "Trapped " + JUNGLE_CHEST;
    protected String TRAPPED_MANGROVE_CHEST = "Trapped " + MANGROVE_CHEST;
    protected String TRAPPED_CHERRY_CHEST = "Trapped " + CHERRY_CHEST;
    protected String TRAPPED_BAMBOO_CHEST = "Trapped " + BAMBOO_CHEST;
    protected String TRAPPED_CRIMSON_CHEST = "Trapped " + CRIMSON_CHEST;
    protected String TRAPPED_WARPED_CHEST = "Trapped " + WARPED_CHEST;

    protected String OAK_BARREL = "Oak Barrel";
    protected String BIRCH_BARREL = "Birch Barrel";
    protected String DARK_OAK_BARREL = "Dark Oak Barrel";
    protected String PALE_OAK_BARREL = "Pale Oak Barrel";
    protected String ACACIA_BARREL = "Acacia Barrel";
    protected String JUNGLE_BARREL = "Jungle Barrel";
    protected String MANGROVE_BARREL = "Mangrove Barrel";
    protected String CHERRY_BARREL = "Cherry Barrel";
    protected String BAMBOO_BARREL = "Bamboo Barrel";
    protected String CRIMSON_BARREL = "Crimson Barrel";
    protected String WARPED_BARREL = "Warped Barrel";

    protected String BLACKSTONE_FURNACE = "Blackstone Furnace";
    protected String DEEPSLATE_FURNACE = "Deepslate Furnace";

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider provider, @NonNull TranslationBuilder translationBuilder) {
        // Zombies
        translationBuilder.add("entity.v2m.icid", ICID);

        // Crafting Tables
        translationBuilder.add("container.v2m.spruce_crafting_table", SPRUCE_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.birch_crafting_table", BIRCH_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.dark_oak_crafting_table", DARK_OAK_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.pale_oak_crafting_table", PALE_OAK_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.acacia_crafting_table", ACACIA_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.jungle_crafting_table", JUNGLE_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.mangrove_crafting_table", MANGROVE_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.cherry_crafting_table", CHERRY_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.bamboo_crafting_table", BAMBOO_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.crimson_crafting_table", CRIMSON_CRAFTING_TABLE);
        translationBuilder.add("container.v2m.warped_crafting_table", WARPED_CRAFTING_TABLE);
        // Item
        translationBuilder.add("block.v2m.spruce_crafting_table", SPRUCE_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.birch_crafting_table", BIRCH_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.dark_oak_crafting_table", DARK_OAK_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.pale_oak_crafting_table", PALE_OAK_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.acacia_crafting_table", ACACIA_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.jungle_crafting_table", JUNGLE_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.mangrove_crafting_table", MANGROVE_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.cherry_crafting_table", CHERRY_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.bamboo_crafting_table", BAMBOO_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.crimson_crafting_table", CRIMSON_CRAFTING_TABLE);
        translationBuilder.add("block.v2m.warped_crafting_table", WARPED_CRAFTING_TABLE);

        // Chests
        translationBuilder.add("container.v2m.spruce_chest", SPRUCE_CHEST);
        translationBuilder.add("container.v2m.birch_chest", BIRCH_CHEST);
        translationBuilder.add("container.v2m.dark_oak_chest", DARK_OAK_CHEST);
        translationBuilder.add("container.v2m.pale_oak_chest", PALE_OAK_CHEST);
        translationBuilder.add("container.v2m.acacia_chest", ACACIA_CHEST);
        translationBuilder.add("container.v2m.jungle_chest", JUNGLE_CHEST);
        translationBuilder.add("container.v2m.mangrove_chest", MANGROVE_CHEST);
        translationBuilder.add("container.v2m.cherry_chest", CHERRY_CHEST);
        translationBuilder.add("container.v2m.bamboo_chest", BAMBOO_CHEST);
        translationBuilder.add("container.v2m.crimson_chest", CRIMSON_CHEST);
        translationBuilder.add("container.v2m.warped_chest", WARPED_CHEST);
        // Item
        translationBuilder.add("block.v2m.spruce_chest", SPRUCE_CHEST);
        translationBuilder.add("block.v2m.birch_chest", BIRCH_CHEST);
        translationBuilder.add("block.v2m.dark_oak_chest", DARK_OAK_CHEST);
        translationBuilder.add("block.v2m.pale_oak_chest", PALE_OAK_CHEST);
        translationBuilder.add("block.v2m.acacia_chest", ACACIA_CHEST);
        translationBuilder.add("block.v2m.jungle_chest", JUNGLE_CHEST);
        translationBuilder.add("block.v2m.mangrove_chest", MANGROVE_CHEST);
        translationBuilder.add("block.v2m.cherry_chest", CHERRY_CHEST);
        translationBuilder.add("block.v2m.bamboo_chest", BAMBOO_CHEST);
        translationBuilder.add("block.v2m.crimson_chest", CRIMSON_CHEST);
        translationBuilder.add("block.v2m.warped_chest", WARPED_CHEST);
        // Large
        translationBuilder.add("container.v2m.large_spruce_chest", LARGE_SPRUCE_CHEST);
        translationBuilder.add("container.v2m.large_birch_chest", LARGE_BIRCH_CHEST);
        translationBuilder.add("container.v2m.large_dark_oak_chest", LARGE_DARK_OAK_CHEST);
        translationBuilder.add("container.v2m.large_pale_oak_chest", LARGE_PALE_OAK_CHEST);
        translationBuilder.add("container.v2m.large_acacia_chest", LARGE_ACACIA_CHEST);
        translationBuilder.add("container.v2m.large_jungle_chest", LARGE_JUNGLE_CHEST);
        translationBuilder.add("container.v2m.large_mangrove_chest", LARGE_MANGROVE_CHEST);
        translationBuilder.add("container.v2m.large_cherry_chest", LARGE_CHERRY_CHEST);
        translationBuilder.add("container.v2m.large_bamboo_chest", LARGE_BAMBOO_CHEST);
        translationBuilder.add("container.v2m.large_crimson_chest", LARGE_CRIMSON_CHEST);
        translationBuilder.add("container.v2m.large_warped_chest", LARGE_WARPED_CHEST);

        // Trapped Chests
        // Item
        translationBuilder.add("block.v2m.spruce_trapped_chest", TRAPPED_SPRUCE_CHEST);
        translationBuilder.add("block.v2m.birch_trapped_chest", TRAPPED_BIRCH_CHEST);
        translationBuilder.add("block.v2m.dark_oak_trapped_chest", TRAPPED_DARK_OAK_CHEST);
        translationBuilder.add("block.v2m.pale_oak_trapped_chest", TRAPPED_PALE_OAK_CHEST);
        translationBuilder.add("block.v2m.acacia_trapped_chest", TRAPPED_ACACIA_CHEST);
        translationBuilder.add("block.v2m.jungle_trapped_chest", TRAPPED_JUNGLE_CHEST);
        translationBuilder.add("block.v2m.mangrove_trapped_chest", TRAPPED_MANGROVE_CHEST);
        translationBuilder.add("block.v2m.cherry_trapped_chest", TRAPPED_CHERRY_CHEST);
        translationBuilder.add("block.v2m.bamboo_trapped_chest", TRAPPED_BAMBOO_CHEST);
        translationBuilder.add("block.v2m.crimson_trapped_chest", TRAPPED_CRIMSON_CHEST);
        translationBuilder.add("block.v2m.warped_trapped_chest", TRAPPED_WARPED_CHEST);

        // Barrels
        translationBuilder.add("container.v2m.oak_barrel", OAK_BARREL);
        translationBuilder.add("container.v2m.birch_barrel", BIRCH_BARREL);
        translationBuilder.add("container.v2m.dark_oak_barrel", DARK_OAK_BARREL);
        translationBuilder.add("container.v2m.pale_oak_barrel", PALE_OAK_BARREL);
        translationBuilder.add("container.v2m.acacia_barrel", ACACIA_BARREL);
        translationBuilder.add("container.v2m.jungle_barrel", JUNGLE_BARREL);
        translationBuilder.add("container.v2m.mangrove_barrel", MANGROVE_BARREL);
        translationBuilder.add("container.v2m.cherry_barrel", CHERRY_BARREL);
        translationBuilder.add("container.v2m.bamboo_barrel", BAMBOO_BARREL);
        translationBuilder.add("container.v2m.crimson_barrel", CRIMSON_BARREL);
        translationBuilder.add("container.v2m.warped_barrel", WARPED_BARREL);
        // Item
        translationBuilder.add("block.v2m.oak_barrel", OAK_BARREL);
        translationBuilder.add("block.v2m.birch_barrel", BIRCH_BARREL);
        translationBuilder.add("block.v2m.dark_oak_barrel", DARK_OAK_BARREL);
        translationBuilder.add("block.v2m.pale_oak_barrel", PALE_OAK_BARREL);
        translationBuilder.add("block.v2m.acacia_barrel", ACACIA_BARREL);
        translationBuilder.add("block.v2m.jungle_barrel", JUNGLE_BARREL);
        translationBuilder.add("block.v2m.mangrove_barrel", MANGROVE_BARREL);
        translationBuilder.add("block.v2m.cherry_barrel", CHERRY_BARREL);
        translationBuilder.add("block.v2m.bamboo_barrel", BAMBOO_BARREL);
        translationBuilder.add("block.v2m.crimson_barrel", CRIMSON_BARREL);
        translationBuilder.add("block.v2m.warped_barrel", WARPED_BARREL);

        // Furnaces
        translationBuilder.add("container.v2m.blackstone_furnace", BLACKSTONE_FURNACE);
        translationBuilder.add("container.v2m.deepslate_furnace", DEEPSLATE_FURNACE);
        // Item
        translationBuilder.add("block.v2m.blackstone_furnace", BLACKSTONE_FURNACE);
        translationBuilder.add("block.v2m.deepslate_furnace", DEEPSLATE_FURNACE);
    }
}
