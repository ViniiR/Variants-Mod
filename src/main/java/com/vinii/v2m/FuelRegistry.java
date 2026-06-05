package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FuelValueEvents;

public class FuelRegistry {
    static void initialize() {
        FuelValueEvents.BUILD.register((builder, ctx) -> {
                final int CRAFTING_TABLE_BURN_TIME = 300;
                final int CHEST_BURN_TIME = 300;
                final int BARREL_BURN_TIME = 300;

                builder.add(ModBlocks.SPRUCE_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.BIRCH_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.DARK_OAK_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.PALE_OAK_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.ACACIA_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.JUNGLE_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.MANGROVE_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.CHERRY_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.BAMBOO_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.CRIMSON_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ModBlocks.WARPED_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);

                builder.add(ModBlocks.SPRUCE_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.BIRCH_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.DARK_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.PALE_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.ACACIA_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.JUNGLE_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.MANGROVE_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.CHERRY_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.BAMBOO_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.CRIMSON_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.WARPED_CHEST, CHEST_BURN_TIME);

                builder.add(ModBlocks.TRAPPED_SPRUCE_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_BIRCH_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_DARK_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_PALE_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_ACACIA_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_JUNGLE_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_MANGROVE_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_CHERRY_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_BAMBOO_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_CRIMSON_CHEST, CHEST_BURN_TIME);
                builder.add(ModBlocks.TRAPPED_WARPED_CHEST, CHEST_BURN_TIME);

                builder.add(ModBlocks.OAK_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.BIRCH_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.DARK_OAK_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.PALE_OAK_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.ACACIA_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.JUNGLE_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.MANGROVE_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.CHERRY_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.BAMBOO_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.CRIMSON_BARREL, BARREL_BURN_TIME);
                builder.add(ModBlocks.WARPED_BARREL, BARREL_BURN_TIME);
            }
        );
    }
}
