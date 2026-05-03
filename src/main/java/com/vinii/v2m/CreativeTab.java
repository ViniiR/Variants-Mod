package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class CreativeTab {
    static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
            .register((group -> {
                group.addAfter(Items.CRAFTING_TABLE, ModBlocks.SPRUCE_CRAFTING_TABLE);
                group.addAfter(ModBlocks.SPRUCE_CRAFTING_TABLE, ModBlocks.BIRCH_CRAFTING_TABLE);
                group.addAfter(ModBlocks.BIRCH_CRAFTING_TABLE, ModBlocks.JUNGLE_CRAFTING_TABLE);
                group.addAfter(ModBlocks.JUNGLE_CRAFTING_TABLE, ModBlocks.ACACIA_CRAFTING_TABLE);
                group.addAfter(ModBlocks.ACACIA_CRAFTING_TABLE, ModBlocks.DARK_OAK_CRAFTING_TABLE);
                group.addAfter(ModBlocks.DARK_OAK_CRAFTING_TABLE, ModBlocks.MANGROVE_CRAFTING_TABLE);
                group.addAfter(ModBlocks.MANGROVE_CRAFTING_TABLE, ModBlocks.CHERRY_CRAFTING_TABLE);
                group.addAfter(ModBlocks.CHERRY_CRAFTING_TABLE, ModBlocks.PALE_OAK_CRAFTING_TABLE);
                group.addAfter(ModBlocks.PALE_OAK_CRAFTING_TABLE, ModBlocks.BAMBOO_CRAFTING_TABLE);
                group.addAfter(ModBlocks.BAMBOO_CRAFTING_TABLE, ModBlocks.CRIMSON_CRAFTING_TABLE);
                group.addAfter(ModBlocks.CRIMSON_CRAFTING_TABLE, ModBlocks.WARPED_CRAFTING_TABLE);

                group.addAfter(Items.CHEST, ModBlocks.SPRUCE_CHEST);
                group.addAfter(ModBlocks.SPRUCE_CHEST, ModBlocks.BIRCH_CHEST);
                group.addAfter(ModBlocks.BIRCH_CHEST, ModBlocks.JUNGLE_CHEST);
                group.addAfter(ModBlocks.JUNGLE_CHEST, ModBlocks.ACACIA_CHEST);
                group.addAfter(ModBlocks.ACACIA_CHEST, ModBlocks.DARK_OAK_CHEST);
                group.addAfter(ModBlocks.DARK_OAK_CHEST, ModBlocks.MANGROVE_CHEST);
                group.addAfter(ModBlocks.MANGROVE_CHEST, ModBlocks.CHERRY_CHEST);
                group.addAfter(ModBlocks.CHERRY_CHEST, ModBlocks.PALE_OAK_CHEST);
                group.addAfter(ModBlocks.PALE_OAK_CHEST, ModBlocks.BAMBOO_CHEST);
                group.addAfter(ModBlocks.BAMBOO_CHEST, ModBlocks.CRIMSON_CHEST);
                group.addAfter(ModBlocks.CRIMSON_CHEST, ModBlocks.WARPED_CHEST);

                group.addBefore(Items.BARREL, ModBlocks.OAK_BARREL);
                group.addAfter(Items.BARREL, ModBlocks.BIRCH_BARREL);
                group.addAfter(ModBlocks.BIRCH_BARREL, ModBlocks.JUNGLE_BARREL);
                group.addAfter(ModBlocks.JUNGLE_BARREL, ModBlocks.ACACIA_BARREL);
                group.addAfter(ModBlocks.ACACIA_BARREL, ModBlocks.DARK_OAK_BARREL);
                group.addAfter(ModBlocks.DARK_OAK_BARREL, ModBlocks.MANGROVE_BARREL);
                group.addAfter(ModBlocks.MANGROVE_BARREL, ModBlocks.CHERRY_BARREL);
                group.addAfter(ModBlocks.CHERRY_BARREL, ModBlocks.PALE_OAK_BARREL);
                group.addAfter(ModBlocks.PALE_OAK_BARREL, ModBlocks.BAMBOO_BARREL);
                group.addAfter(ModBlocks.BAMBOO_BARREL, ModBlocks.CRIMSON_BARREL);
                group.addAfter(ModBlocks.CRIMSON_BARREL, ModBlocks.WARPED_BARREL);

                group.addAfter(Items.FURNACE, ModBlocks.BLACKSTONE_FURNACE);
                group.addAfter(ModBlocks.BLACKSTONE_FURNACE, ModBlocks.DEEPSLATE_FURNACE);
            }));

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS)
            .register((group -> {
                group.addAfter(Items.TRAPPED_CHEST, ModBlocks.TRAPPED_SPRUCE_CHEST);
                group.addAfter(ModBlocks.TRAPPED_SPRUCE_CHEST, ModBlocks.TRAPPED_BIRCH_CHEST);
                group.addAfter(ModBlocks.TRAPPED_BIRCH_CHEST, ModBlocks.TRAPPED_JUNGLE_CHEST);
                group.addAfter(ModBlocks.TRAPPED_JUNGLE_CHEST, ModBlocks.TRAPPED_ACACIA_CHEST);
                group.addAfter(ModBlocks.TRAPPED_ACACIA_CHEST, ModBlocks.TRAPPED_DARK_OAK_CHEST);
                group.addAfter(ModBlocks.TRAPPED_DARK_OAK_CHEST, ModBlocks.TRAPPED_MANGROVE_CHEST);
                group.addAfter(ModBlocks.TRAPPED_MANGROVE_CHEST, ModBlocks.TRAPPED_CHERRY_CHEST);
                group.addAfter(ModBlocks.TRAPPED_CHERRY_CHEST, ModBlocks.TRAPPED_PALE_OAK_CHEST);
                group.addAfter(ModBlocks.TRAPPED_PALE_OAK_CHEST, ModBlocks.TRAPPED_BAMBOO_CHEST);
                group.addAfter(ModBlocks.TRAPPED_BAMBOO_CHEST, ModBlocks.TRAPPED_CRIMSON_CHEST);
                group.addAfter(ModBlocks.TRAPPED_CRIMSON_CHEST, ModBlocks.TRAPPED_WARPED_CHEST);
            }));

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS)
            .register((group -> {
                group.addAfter(Items.JACK_O_LANTERN, ModBlocks.PALE_PUMPKIN);
                group.addAfter(ModBlocks.PALE_PUMPKIN, ModBlocks.CARVED_PALE_PUMPKIN);
                group.addAfter(ModBlocks.CARVED_PALE_PUMPKIN, ModBlocks.PALE_JACK_O_LANTERN);
            }));
    }
}
