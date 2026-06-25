package com.vinii.v2m.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public abstract class TranslationProvider extends FabricLanguageProvider {
    protected TranslationProvider(FabricPackOutput dataOutput, String languageCode, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, languageCode, registryLookup);
    }

    // WARNING: vanilla keys must be added manually with JSON

    protected String ICID = "Icid";
    protected String MUDDY_ZOMBIE = "Swamp Zombie";

    protected String SOUL_SKELETON = "Soul Skeleton";
    protected String WARPED_ENDERMAN = "Warped Enderman";
    protected String FROZEN_GUARDIAN = "Frozen Guardian";
    protected String SOUL_BLAZE = "Soul Blaze";

    protected String PALE_SNOW_GOLEM = "Pale Snow Golem";

    protected String RAID_VINDICATOR = "Raid Vindicator";
    protected String RAID_EVOKER = "Raid Evoker";
    protected String RAID_WITCH = "Raid Witch";
    protected String MOUNTAINEER_PILLAGER = "Mountaineer Pillager";

    //

    protected String PALE_PUMPKIN = "Pale Pumpkin";
    protected String CARVED_PALE_PUMPKIN = "Carved " + PALE_PUMPKIN;
    protected String PALE_JACK_O_LANTERN = "Pale Jack o' lantern";

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

    protected String COPPER_CHEST = "Copper Chest";
    protected String LARGE_COPPER_CHEST = "Large " + COPPER_CHEST;

    protected String OAK_CHEST = "Oak Chest";
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

    protected String LARGE_OAK_CHEST = "Large " + OAK_CHEST;
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

    protected String TRAPPED_OAK_CHEST = "Trapped " + OAK_CHEST;
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

    // Config keys
    protected String CONFIG_TITLE = "Vinii's Variants Mod Configuration";

    protected String CONFIG_MAIN_NAME = "Configuration";
    protected String CONFIG_MAIN_TOOLTIP = "Main configuration options";

    protected String CONFIG_MAIN_STRUCTURES_NAME = "Structure generation";
    protected String CONFIG_MAIN_STRUCTURES_DESC = "Structure generation options";

    protected String CONFIG_MAIN_STRUCTURES_GENERATE_NAME = "Generate mod utility blocks";
    protected String CONFIG_MAIN_STRUCTURES_GENERATE_DESC = "Whether or not to generate variant utility blocks (Chests, furnaces, etc) on structures";

    protected String CONFIG_MAIN_STRUCTURES_GENERATE_FROSTED_NAME = "Generate frosted glass pane";
    protected String CONFIG_MAIN_STRUCTURES_GENERATE_FROSTED_DESC = "Whether or not to generate frosted glass panes on snowy villages";

    protected String CONFIG_MAIN_STRUCTURES_GENERATE_PALE_MANSION_NAME = "Generate pale oak mansion (Experimental)";
    protected String CONFIG_MAIN_STRUCTURES_GENERATE_PALE_MANSION_DESC = """
        Whether or not to generate pale oak variant of the woodland mansion in pale gardens.
        Note: /place command does not work with it, and the spawn chances are vanilla, meaning it is unlikely it will ever spawn.
        
        Important: this is an experimental feature and may cause conflicts with other mods or performance issues.""";

    protected String CONFIG_MAIN_STRUCTURES_GENERATE_CRIMSON_FORTRESS_NAME = "Generate crimson fortress (Unfinished)";
    protected String CONFIG_MAIN_STRUCTURES_GENERATE_CRIMSON_FORTRESS_DESC = """
        Whether or not to generate red nether brick variant of the nether fortress in crimson forests.
        
        Important: this is an unfinished feature and you should not enable it.""";

    protected String CONFIG_COMPATIBILITY_NAME = "Compatibility";
    protected String CONFIG_COMPATIBILITY_TOOLTIP = "Compatibility options";

    protected String CONFIG_COMPATIBILITY_RECIPE_NAME = "Enable recipe compatibility";
    protected String CONFIG_COMPATIBILITY_RECIPE_DESC = """
        Whether or not to enable recipe compatibility with other mods,
        
        When to use it:
        It should only be enabled if you have some other mod with new wood or stone variants (that can craft chests, furnaces, etc).
        Enabling it leads to a slightly messier recipe book and crafting recipes but prevents them from being deleted,
        
        Using the chest as an example, but not limited to it:
        By messier it means exactly: Both the vanilla recipe (All plank variants craft the Oak chest), and the mod recipes
        coexist, meaning it solely relies on the recipe book to craft the modded chests since there will be two different recipes for each one of them.
        
        Do not enable this unless necessary, mods that may require it include, Wilder Wild, and Biomes O' Plenty.
        
        If you're enabling it while inside a world you need to either quit and rejoin the world or use the "/reload" command.""";

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider provider, @NonNull TranslationBuilder translationBuilder) {
        // Entities
        translationBuilder.add("entity.v2m.icid", ICID);
        translationBuilder.add("entity.v2m.muddy_zombie", MUDDY_ZOMBIE);
        translationBuilder.add("entity.v2m.soul_skeleton", SOUL_SKELETON);
        translationBuilder.add("entity.v2m.warped_enderman", WARPED_ENDERMAN);
        translationBuilder.add("entity.v2m.soul_blaze", SOUL_BLAZE);
        translationBuilder.add("entity.v2m.frozen_guardian", FROZEN_GUARDIAN);
        translationBuilder.add("entity.v2m.mountaineer_pillager", MOUNTAINEER_PILLAGER);
        translationBuilder.add("entity.v2m.raid_vindicator", RAID_VINDICATOR);
        translationBuilder.add("entity.v2m.raid_evoker", RAID_EVOKER);
        translationBuilder.add("entity.v2m.raid_witch", RAID_WITCH);

        // Pale Pumpkins
        translationBuilder.add("block.v2m.pale_pumpkin", PALE_PUMPKIN);
        translationBuilder.add("block.v2m.carved_pale_pumpkin", CARVED_PALE_PUMPKIN);
        translationBuilder.add("block.v2m.pale_jack_o_lantern", PALE_JACK_O_LANTERN);
        translationBuilder.add("entity.v2m.pale_snow_golem", PALE_SNOW_GOLEM);

        // Crafting Tables
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

        // NOTE: Oak Chests container names are defined here because copper chests are already overriden
        // Doing allows other mods' chests to use the vanilla key without issues
        // However Chest, Barrel, and Furnace blocks still get overridden
        // Chests
        translationBuilder.add("container.v2m.oak_chest", OAK_CHEST);
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
        // translationBuilder.add("block.v2m.oak_chest", OAK_CHEST); // Block names are overridden via json directly
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
        translationBuilder.add("container.v2m.large_oak_chest", LARGE_OAK_CHEST);
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
        translationBuilder.add("block.v2m.trapped_spruce_chest", TRAPPED_SPRUCE_CHEST);
        translationBuilder.add("block.v2m.trapped_birch_chest", TRAPPED_BIRCH_CHEST);
        translationBuilder.add("block.v2m.trapped_dark_oak_chest", TRAPPED_DARK_OAK_CHEST);
        translationBuilder.add("block.v2m.trapped_pale_oak_chest", TRAPPED_PALE_OAK_CHEST);
        translationBuilder.add("block.v2m.trapped_acacia_chest", TRAPPED_ACACIA_CHEST);
        translationBuilder.add("block.v2m.trapped_jungle_chest", TRAPPED_JUNGLE_CHEST);
        translationBuilder.add("block.v2m.trapped_mangrove_chest", TRAPPED_MANGROVE_CHEST);
        translationBuilder.add("block.v2m.trapped_cherry_chest", TRAPPED_CHERRY_CHEST);
        translationBuilder.add("block.v2m.trapped_bamboo_chest", TRAPPED_BAMBOO_CHEST);
        translationBuilder.add("block.v2m.trapped_crimson_chest", TRAPPED_CRIMSON_CHEST);
        translationBuilder.add("block.v2m.trapped_warped_chest", TRAPPED_WARPED_CHEST);
        // Container Large (Container regular is copied from normal chests (Internally from minecraft))
        translationBuilder.add("container.v2m.large_trapped_oak_chest", LARGE_OAK_CHEST);
        translationBuilder.add("container.v2m.large_trapped_spruce_chest", LARGE_SPRUCE_CHEST);
        translationBuilder.add("container.v2m.large_trapped_birch_chest", LARGE_BIRCH_CHEST);
        translationBuilder.add("container.v2m.large_trapped_dark_oak_chest", LARGE_DARK_OAK_CHEST);
        translationBuilder.add("container.v2m.large_trapped_pale_oak_chest", LARGE_PALE_OAK_CHEST);
        translationBuilder.add("container.v2m.large_trapped_acacia_chest", LARGE_ACACIA_CHEST);
        translationBuilder.add("container.v2m.large_trapped_jungle_chest", LARGE_JUNGLE_CHEST);
        translationBuilder.add("container.v2m.large_trapped_mangrove_chest", LARGE_MANGROVE_CHEST);
        translationBuilder.add("container.v2m.large_trapped_cherry_chest", LARGE_CHERRY_CHEST);
        translationBuilder.add("container.v2m.large_trapped_bamboo_chest", LARGE_BAMBOO_CHEST);
        translationBuilder.add("container.v2m.large_trapped_crimson_chest", LARGE_CRIMSON_CHEST);
        translationBuilder.add("container.v2m.large_trapped_warped_chest", LARGE_WARPED_CHEST);

        // Copper Chests
        translationBuilder.add("container.v2m.copper_chest", COPPER_CHEST);
        translationBuilder.add("container.v2m.large_copper_chest", LARGE_COPPER_CHEST);

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

        // Config
        translationBuilder.add("config.v2m.title", CONFIG_TITLE);

        translationBuilder.add("config.v2m.main.name", CONFIG_MAIN_NAME);
        translationBuilder.add("config.v2m.main.tooltip", CONFIG_MAIN_TOOLTIP);

        translationBuilder.add("config.v2m.structures.name", CONFIG_MAIN_STRUCTURES_NAME);
        translationBuilder.add("config.v2m.structures.desc", CONFIG_MAIN_STRUCTURES_DESC);

        translationBuilder.add("config.v2m.structures.generate.name", CONFIG_MAIN_STRUCTURES_GENERATE_NAME);
        translationBuilder.add("config.v2m.structures.generate.desc", CONFIG_MAIN_STRUCTURES_GENERATE_DESC);

        translationBuilder.add("config.v2m.structures.generate_frosted.name", CONFIG_MAIN_STRUCTURES_GENERATE_FROSTED_NAME);
        translationBuilder.add("config.v2m.structures.generate_frosted.desc", CONFIG_MAIN_STRUCTURES_GENERATE_FROSTED_DESC);

        translationBuilder.add("config.v2m.structures.pale_mansion.name", CONFIG_MAIN_STRUCTURES_GENERATE_PALE_MANSION_NAME);
        translationBuilder.add("config.v2m.structures.pale_mansion.desc", CONFIG_MAIN_STRUCTURES_GENERATE_PALE_MANSION_DESC);

        translationBuilder.add("config.v2m.structures.crimson_fortress.name", CONFIG_MAIN_STRUCTURES_GENERATE_CRIMSON_FORTRESS_NAME);
        translationBuilder.add("config.v2m.structures.crimson_fortress.desc", CONFIG_MAIN_STRUCTURES_GENERATE_CRIMSON_FORTRESS_DESC);

        translationBuilder.add("config.v2m.compatibility.name", CONFIG_COMPATIBILITY_NAME);
        translationBuilder.add("config.v2m.compatibility.tooltip", CONFIG_COMPATIBILITY_TOOLTIP);

        translationBuilder.add("config.v2m.recipe.name", CONFIG_COMPATIBILITY_RECIPE_NAME);
        translationBuilder.add("config.v2m.recipe.desc", CONFIG_COMPATIBILITY_RECIPE_DESC);
    }
}
