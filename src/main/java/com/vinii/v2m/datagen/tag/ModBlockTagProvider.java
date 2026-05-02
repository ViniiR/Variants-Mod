package com.vinii.v2m.datagen.tag;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static String namespace = ViniisVariantsMod.MOD_ID;

    public static final TagKey<Block> MOD_CRAFTING_TABLES = create(Registries.BLOCK, "mod_crafting_tables");
    public static final TagKey<Block> MOD_CHESTS = create(Registries.BLOCK, "mod_chests");
    public static final TagKey<Block> MOD_TRAPPED_CHESTS = create(Registries.BLOCK, "mod_trapped_chests");
    public static final TagKey<Block> MOD_BARRELS = create(Registries.BLOCK, "mod_barrels");
    public static final TagKey<Block> MOD_FURNACES = create(Registries.BLOCK, "mod_furnaces");

    public static final TagKey<Block> ALL_CRAFTING_TABLES = create(Registries.BLOCK, "all_crafting_tables");
    public static final TagKey<Block> ALL_CHESTS = create(Registries.BLOCK, "all_chests");
    public static final TagKey<Block> ALL_TRAPPED_CHESTS = create(Registries.BLOCK, "all_trapped_chests");
    public static final TagKey<Block> ALL_BARRELS = create(Registries.BLOCK, "all_barrels");
    public static final TagKey<Block> ALL_FURNACES = create(Registries.BLOCK, "all_furnaces");

    public static final TagKey<Block> MOD_PUMPKINS = create(Registries.BLOCK, "mod_pumpkins");

//    public static final TagKey<Entity> MOD_ZOMBIES = create(Registries., "mod_zombies");

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        valueLookupBuilder(MOD_PUMPKINS)
            .add(ModBlocks.PALE_PUMPKIN)
            .add(ModBlocks.CARVED_PALE_PUMPKIN)
            .add(ModBlocks.PALE_JACK_O_LANTERN);

        valueLookupBuilder(ALL_CRAFTING_TABLES)
            .addTag(MOD_CRAFTING_TABLES)
            .add(Blocks.CRAFTING_TABLE);

        valueLookupBuilder(ALL_CHESTS)
            .addTag(MOD_CHESTS)
            .add(Blocks.CHEST);

        valueLookupBuilder(ALL_TRAPPED_CHESTS)
            .addTag(MOD_TRAPPED_CHESTS)
            .add(Blocks.TRAPPED_CHEST);

        valueLookupBuilder(ALL_BARRELS)
            .addTag(MOD_BARRELS)
            .add(Blocks.BARREL);

        valueLookupBuilder(ALL_FURNACES)
            .addTag(MOD_FURNACES)
            .add(Blocks.FURNACE);


        valueLookupBuilder(MOD_CRAFTING_TABLES)
            .add(ModBlocks.SPRUCE_CRAFTING_TABLE)
            .add(ModBlocks.BIRCH_CRAFTING_TABLE)
            .add(ModBlocks.DARK_OAK_CRAFTING_TABLE)
            .add(ModBlocks.PALE_OAK_CRAFTING_TABLE)
            .add(ModBlocks.JUNGLE_CRAFTING_TABLE)
            .add(ModBlocks.MANGROVE_CRAFTING_TABLE)
            .add(ModBlocks.CHERRY_CRAFTING_TABLE)
            .add(ModBlocks.ACACIA_CRAFTING_TABLE)
            .add(ModBlocks.BAMBOO_CRAFTING_TABLE)
            .add(ModBlocks.WARPED_CRAFTING_TABLE)
            .add(ModBlocks.CRIMSON_CRAFTING_TABLE);

        valueLookupBuilder(MOD_CHESTS)
            .add(ModBlocks.SPRUCE_CHEST)
            .add(ModBlocks.BIRCH_CHEST)
            .add(ModBlocks.DARK_OAK_CHEST)
            .add(ModBlocks.PALE_OAK_CHEST)
            .add(ModBlocks.JUNGLE_CHEST)
            .add(ModBlocks.MANGROVE_CHEST)
            .add(ModBlocks.CHERRY_CHEST)
            .add(ModBlocks.ACACIA_CHEST)
            .add(ModBlocks.BAMBOO_CHEST)
            .add(ModBlocks.WARPED_CHEST)
            .add(ModBlocks.CRIMSON_CHEST);

        valueLookupBuilder(MOD_TRAPPED_CHESTS)
            .add(ModBlocks.TRAPPED_SPRUCE_CHEST)
            .add(ModBlocks.TRAPPED_BIRCH_CHEST)
            .add(ModBlocks.TRAPPED_DARK_OAK_CHEST)
            .add(ModBlocks.TRAPPED_PALE_OAK_CHEST)
            .add(ModBlocks.TRAPPED_JUNGLE_CHEST)
            .add(ModBlocks.TRAPPED_MANGROVE_CHEST)
            .add(ModBlocks.TRAPPED_CHERRY_CHEST)
            .add(ModBlocks.TRAPPED_ACACIA_CHEST)
            .add(ModBlocks.TRAPPED_BAMBOO_CHEST)
            .add(ModBlocks.TRAPPED_WARPED_CHEST)
            .add(ModBlocks.TRAPPED_CRIMSON_CHEST);

        valueLookupBuilder(MOD_BARRELS)
            .add(ModBlocks.OAK_BARREL)
            .add(ModBlocks.BIRCH_BARREL)
            .add(ModBlocks.DARK_OAK_BARREL)
            .add(ModBlocks.PALE_OAK_BARREL)
            .add(ModBlocks.JUNGLE_BARREL)
            .add(ModBlocks.MANGROVE_BARREL)
            .add(ModBlocks.CHERRY_BARREL)
            .add(ModBlocks.ACACIA_BARREL)
            .add(ModBlocks.BAMBOO_BARREL)
            .add(ModBlocks.WARPED_BARREL)
            .add(ModBlocks.CRIMSON_BARREL);

        valueLookupBuilder(MOD_FURNACES)
            .add(ModBlocks.BLACKSTONE_FURNACE)
            .add(ModBlocks.DEEPSLATE_FURNACE);

        // Vanilla

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .addTag(MOD_FURNACES)
            .setReplace(false)
        ;

        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
            .addTag(MOD_CRAFTING_TABLES)
            .addTag(MOD_CHESTS)
            .addTag(MOD_TRAPPED_CHESTS)
            .addTag(MOD_BARRELS)
            .addTag(MOD_PUMPKINS)
            .setReplace(false)
        ;

        valueLookupBuilder(BlockTags.SWORD_EFFICIENT)
            .addTag(MOD_PUMPKINS)
            .setReplace(false)
        ;

        valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
            .add(ModBlocks.PALE_JACK_O_LANTERN)
            .setReplace(false)
        ;

        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE)
            .addTag(MOD_PUMPKINS)
            .setReplace(false)
        ;
    }

    public static <T> TagKey<T> create(ResourceKey<? extends Registry<T>> key, String identifier) {
        return TagKey.create(key, Identifier.fromNamespaceAndPath(namespace, identifier));
    }
}
