package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class CreativeTab {
    static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
            .register((group -> {
                group.insertAfter(Items.CRAFTING_TABLE, ModBlocks.SPRUCE_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.SPRUCE_CRAFTING_TABLE, ModBlocks.BIRCH_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.BIRCH_CRAFTING_TABLE, ModBlocks.JUNGLE_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.JUNGLE_CRAFTING_TABLE, ModBlocks.ACACIA_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.ACACIA_CRAFTING_TABLE, ModBlocks.DARK_OAK_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.DARK_OAK_CRAFTING_TABLE, ModBlocks.MANGROVE_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.MANGROVE_CRAFTING_TABLE, ModBlocks.CHERRY_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.CHERRY_CRAFTING_TABLE, ModBlocks.PALE_OAK_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.PALE_OAK_CRAFTING_TABLE, ModBlocks.BAMBOO_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.BAMBOO_CRAFTING_TABLE, ModBlocks.CRIMSON_CRAFTING_TABLE);
                group.insertAfter(ModBlocks.CRIMSON_CRAFTING_TABLE, ModBlocks.WARPED_CRAFTING_TABLE);

                group.insertAfter(Items.CHEST, ModBlocks.SPRUCE_CHEST);
                group.insertAfter(ModBlocks.SPRUCE_CHEST, ModBlocks.BIRCH_CHEST);
                group.insertAfter(ModBlocks.BIRCH_CHEST, ModBlocks.JUNGLE_CHEST);
                group.insertAfter(ModBlocks.JUNGLE_CHEST, ModBlocks.ACACIA_CHEST);
                group.insertAfter(ModBlocks.ACACIA_CHEST, ModBlocks.DARK_OAK_CHEST);
                group.insertAfter(ModBlocks.DARK_OAK_CHEST, ModBlocks.MANGROVE_CHEST);
                group.insertAfter(ModBlocks.MANGROVE_CHEST, ModBlocks.CHERRY_CHEST);
                group.insertAfter(ModBlocks.CHERRY_CHEST, ModBlocks.PALE_OAK_CHEST);
                group.insertAfter(ModBlocks.PALE_OAK_CHEST, ModBlocks.BAMBOO_CHEST);
                group.insertAfter(ModBlocks.BAMBOO_CHEST, ModBlocks.CRIMSON_CHEST);
                group.insertAfter(ModBlocks.CRIMSON_CHEST, ModBlocks.WARPED_CHEST);

                group.insertBefore(Items.BARREL, ModBlocks.OAK_BARREL);
                group.insertAfter(Items.BARREL, ModBlocks.BIRCH_BARREL);
                group.insertAfter(ModBlocks.BIRCH_BARREL, ModBlocks.JUNGLE_BARREL);
                group.insertAfter(ModBlocks.JUNGLE_BARREL, ModBlocks.ACACIA_BARREL);
                group.insertAfter(ModBlocks.ACACIA_BARREL, ModBlocks.DARK_OAK_BARREL);
                group.insertAfter(ModBlocks.DARK_OAK_BARREL, ModBlocks.MANGROVE_BARREL);
                group.insertAfter(ModBlocks.MANGROVE_BARREL, ModBlocks.CHERRY_BARREL);
                group.insertAfter(ModBlocks.CHERRY_BARREL, ModBlocks.PALE_OAK_BARREL);
                group.insertAfter(ModBlocks.PALE_OAK_BARREL, ModBlocks.BAMBOO_BARREL);
                group.insertAfter(ModBlocks.BAMBOO_BARREL, ModBlocks.CRIMSON_BARREL);
                group.insertAfter(ModBlocks.CRIMSON_BARREL, ModBlocks.WARPED_BARREL);

                group.insertAfter(Items.FURNACE, ModBlocks.BLACKSTONE_FURNACE);
                group.insertAfter(ModBlocks.BLACKSTONE_FURNACE, ModBlocks.DEEPSLATE_FURNACE);
                group.insertAfter(ModBlocks.DEEPSLATE_FURNACE, ModBlocks.BRICK_FURNACE);
                group.insertAfter(ModBlocks.BRICK_FURNACE, ModBlocks.NETHER_BRICK_FURNACE);
                group.insertAfter(ModBlocks.NETHER_BRICK_FURNACE, ModBlocks.RED_NETHER_BRICK_FURNACE);
                group.insertAfter(ModBlocks.RED_NETHER_BRICK_FURNACE, ModBlocks.RESIN_BRICK_FURNACE);
            }));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
            .register((group -> {
                group.insertAfter(Items.TRAPPED_CHEST, ModBlocks.TRAPPED_SPRUCE_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_SPRUCE_CHEST, ModBlocks.TRAPPED_BIRCH_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_BIRCH_CHEST, ModBlocks.TRAPPED_JUNGLE_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_JUNGLE_CHEST, ModBlocks.TRAPPED_ACACIA_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_ACACIA_CHEST, ModBlocks.TRAPPED_DARK_OAK_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_DARK_OAK_CHEST, ModBlocks.TRAPPED_MANGROVE_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_MANGROVE_CHEST, ModBlocks.TRAPPED_CHERRY_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_CHERRY_CHEST, ModBlocks.TRAPPED_PALE_OAK_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_PALE_OAK_CHEST, ModBlocks.TRAPPED_BAMBOO_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_BAMBOO_CHEST, ModBlocks.TRAPPED_CRIMSON_CHEST);
                group.insertAfter(ModBlocks.TRAPPED_CRIMSON_CHEST, ModBlocks.TRAPPED_WARPED_CHEST);
            }));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
            .register((group -> {
                group.insertAfter(Items.JACK_O_LANTERN, ModBlocks.PALE_PUMPKIN);
                group.insertAfter(ModBlocks.PALE_PUMPKIN, ModBlocks.CARVED_PALE_PUMPKIN);
                group.insertAfter(ModBlocks.CARVED_PALE_PUMPKIN, ModBlocks.PALE_JACK_O_LANTERN);
            }));
    }
}
