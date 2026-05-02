package com.vinii.v2m.datagen.loot_table;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        otherWhenSilkTouch(ModBlocks.FROSTED_GLASS_PANE, Blocks.GLASS_PANE);
        otherWhenSilkTouch(ModBlocks.SANDY_GLASS_PANE, Blocks.GLASS_PANE);

        dropSelf(ModBlocks.PALE_PUMPKIN);
        dropSelf(ModBlocks.CARVED_PALE_PUMPKIN);
        dropSelf(ModBlocks.PALE_JACK_O_LANTERN);

        dropSelf(ModBlocks.SPRUCE_CRAFTING_TABLE);
        dropSelf(ModBlocks.BIRCH_CRAFTING_TABLE);
        dropSelf(ModBlocks.ACACIA_CRAFTING_TABLE);
        dropSelf(ModBlocks.DARK_OAK_CRAFTING_TABLE);
        dropSelf(ModBlocks.PALE_OAK_CRAFTING_TABLE);
        dropSelf(ModBlocks.JUNGLE_CRAFTING_TABLE);
        dropSelf(ModBlocks.CHERRY_CRAFTING_TABLE);
        dropSelf(ModBlocks.BAMBOO_CRAFTING_TABLE);
        dropSelf(ModBlocks.MANGROVE_CRAFTING_TABLE);
        dropSelf(ModBlocks.CRIMSON_CRAFTING_TABLE);
        dropSelf(ModBlocks.WARPED_CRAFTING_TABLE);

        dropSelf(ModBlocks.SPRUCE_CHEST);
        dropSelf(ModBlocks.BIRCH_CHEST);
        dropSelf(ModBlocks.ACACIA_CHEST);
        dropSelf(ModBlocks.DARK_OAK_CHEST);
        dropSelf(ModBlocks.PALE_OAK_CHEST);
        dropSelf(ModBlocks.JUNGLE_CHEST);
        dropSelf(ModBlocks.CHERRY_CHEST);
        dropSelf(ModBlocks.BAMBOO_CHEST);
        dropSelf(ModBlocks.MANGROVE_CHEST);
        dropSelf(ModBlocks.CRIMSON_CHEST);
        dropSelf(ModBlocks.WARPED_CHEST);

        dropSelf(ModBlocks.TRAPPED_SPRUCE_CHEST);
        dropSelf(ModBlocks.TRAPPED_BIRCH_CHEST);
        dropSelf(ModBlocks.TRAPPED_ACACIA_CHEST);
        dropSelf(ModBlocks.TRAPPED_DARK_OAK_CHEST);
        dropSelf(ModBlocks.TRAPPED_PALE_OAK_CHEST);
        dropSelf(ModBlocks.TRAPPED_JUNGLE_CHEST);
        dropSelf(ModBlocks.TRAPPED_CHERRY_CHEST);
        dropSelf(ModBlocks.TRAPPED_BAMBOO_CHEST);
        dropSelf(ModBlocks.TRAPPED_MANGROVE_CHEST);
        dropSelf(ModBlocks.TRAPPED_CRIMSON_CHEST);
        dropSelf(ModBlocks.TRAPPED_WARPED_CHEST);

        dropSelf(ModBlocks.OAK_BARREL);
        dropSelf(ModBlocks.BIRCH_BARREL);
        dropSelf(ModBlocks.ACACIA_BARREL);
        dropSelf(ModBlocks.DARK_OAK_BARREL);
        dropSelf(ModBlocks.PALE_OAK_BARREL);
        dropSelf(ModBlocks.JUNGLE_BARREL);
        dropSelf(ModBlocks.CHERRY_BARREL);
        dropSelf(ModBlocks.BAMBOO_BARREL);
        dropSelf(ModBlocks.MANGROVE_BARREL);
        dropSelf(ModBlocks.CRIMSON_BARREL);
        dropSelf(ModBlocks.WARPED_BARREL);

        dropSelf(ModBlocks.BLACKSTONE_FURNACE);
        dropSelf(ModBlocks.DEEPSLATE_FURNACE);
    }
}
