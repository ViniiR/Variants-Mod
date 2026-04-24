package com.vinii.v2m.datagen;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemRegistryLookup = registries.lookupOrThrow(Registries.ITEM);

                craftingTableBuilder(ModBlocks.SPRUCE_CRAFTING_TABLE, Items.SPRUCE_PLANKS);
                craftingTableBuilder(ModBlocks.BIRCH_CRAFTING_TABLE, Items.BIRCH_PLANKS);
                craftingTableBuilder(ModBlocks.DARK_OAK_CRAFTING_TABLE, Items.DARK_OAK_PLANKS);
                craftingTableBuilder(ModBlocks.PALE_OAK_CRAFTING_TABLE, Items.PALE_OAK_PLANKS);
                craftingTableBuilder(ModBlocks.JUNGLE_CRAFTING_TABLE, Items.JUNGLE_PLANKS);
                craftingTableBuilder(ModBlocks.MANGROVE_CRAFTING_TABLE, Items.MANGROVE_PLANKS);
                craftingTableBuilder(ModBlocks.CHERRY_CRAFTING_TABLE, Items.CHERRY_PLANKS);
                craftingTableBuilder(ModBlocks.ACACIA_CRAFTING_TABLE, Items.ACACIA_PLANKS);
                craftingTableBuilder(ModBlocks.BAMBOO_CRAFTING_TABLE, Items.BAMBOO_PLANKS);
                craftingTableBuilder(ModBlocks.WARPED_CRAFTING_TABLE, Items.WARPED_PLANKS);
                craftingTableBuilder(ModBlocks.CRIMSON_CRAFTING_TABLE, Items.CRIMSON_PLANKS);

                barrelBuilder(ModBlocks.OAK_BARREL, Items.OAK_PLANKS, Items.OAK_SLAB);
                barrelBuilder(ModBlocks.BIRCH_BARREL, Items.BIRCH_PLANKS, Items.BIRCH_SLAB);
                barrelBuilder(ModBlocks.DARK_OAK_BARREL, Items.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB);
                barrelBuilder(ModBlocks.PALE_OAK_BARREL, Items.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB);
                barrelBuilder(ModBlocks.JUNGLE_BARREL, Items.JUNGLE_PLANKS, Items.JUNGLE_SLAB);
                barrelBuilder(ModBlocks.MANGROVE_BARREL, Items.MANGROVE_PLANKS, Items.MANGROVE_SLAB);
                barrelBuilder(ModBlocks.CHERRY_BARREL, Items.CHERRY_PLANKS, Items.CHERRY_SLAB);
                barrelBuilder(ModBlocks.ACACIA_BARREL, Items.ACACIA_PLANKS, Items.ACACIA_SLAB);
                barrelBuilder(ModBlocks.BAMBOO_BARREL, Items.BAMBOO_PLANKS, Items.BAMBOO_SLAB);
                barrelBuilder(ModBlocks.WARPED_BARREL, Items.WARPED_PLANKS, Items.WARPED_SLAB);
                barrelBuilder(ModBlocks.CRIMSON_BARREL, Items.CRIMSON_PLANKS, Items.CRIMSON_SLAB);

                chestBuilder(ModBlocks.SPRUCE_CHEST, Items.SPRUCE_PLANKS);
                chestBuilder(ModBlocks.BIRCH_CHEST, Items.BIRCH_PLANKS);
                chestBuilder(ModBlocks.DARK_OAK_CHEST, Items.DARK_OAK_PLANKS);
                chestBuilder(ModBlocks.PALE_OAK_CHEST, Items.PALE_OAK_PLANKS);
                chestBuilder(ModBlocks.JUNGLE_CHEST, Items.JUNGLE_PLANKS);
                chestBuilder(ModBlocks.MANGROVE_CHEST, Items.MANGROVE_PLANKS);
                chestBuilder(ModBlocks.CHERRY_CHEST, Items.CHERRY_PLANKS);
                chestBuilder(ModBlocks.ACACIA_CHEST, Items.ACACIA_PLANKS);
                chestBuilder(ModBlocks.BAMBOO_CHEST, Items.BAMBOO_PLANKS);
                chestBuilder(ModBlocks.WARPED_CHEST, Items.WARPED_PLANKS);
                chestBuilder(ModBlocks.CRIMSON_CHEST, Items.CRIMSON_PLANKS);

//                trappedChestBuilder(ModBlocks.SPRUCE_CHEST, Items.SPRUCE_PLANKS);
//                trappedChestBuilder(ModBlocks.BIRCH_CHEST, Items.BIRCH_PLANKS);
//                trappedChestBuilder(ModBlocks.DARK_OAK_CHEST, Items.DARK_OAK_PLANKS);
//                trappedChestBuilder(ModBlocks.PALE_OAK_CHEST, Items.PALE_OAK_PLANKS);
//                trappedChestBuilder(ModBlocks.JUNGLE_CHEST, Items.JUNGLE_PLANKS);
//                trappedChestBuilder(ModBlocks.MANGROVE_CHEST, Items.MANGROVE_PLANKS);
//                trappedChestBuilder(ModBlocks.CHERRY_CHEST, Items.CHERRY_PLANKS);
//                trappedChestBuilder(ModBlocks.ACACIA_CHEST, Items.ACACIA_PLANKS);
//                trappedChestBuilder(ModBlocks.BAMBOO_CHEST, Items.BAMBOO_PLANKS);
//                trappedChestBuilder(ModBlocks.WARPED_CHEST, Items.WARPED_PLANKS);
//                trappedChestBuilder(ModBlocks.CRIMSON_CHEST, Items.CRIMSON_PLANKS);

                // Yes furnaces are just stone chests :P
                chestBuilder(ModBlocks.BLACKSTONE_FURNACE, Items.BLACKSTONE);
                chestBuilder(ModBlocks.DEEPSLATE_FURNACE, Items.DEEPSLATE);
            }

            public void craftingTableBuilder(ItemLike itemLike, Item ingredient) {
                this
                    .shaped(RecipeCategory.MISC, itemLike, 1)
                    .define('w', ingredient)
                    .pattern("ww")
                    .pattern("ww")
                    .group("crafting_table")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(recipeOutput);
            }

            public void chestBuilder(ItemLike itemLike, Item ingredient) {
                this
                    .shaped(RecipeCategory.MISC, itemLike, 1)
                    .define('w', ingredient)
                    .pattern("www")
                    .pattern("w w")
                    .pattern("www")
                    .group("chest")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(recipeOutput);
                ;
            }

            public void trappedChestBuilder(ItemLike itemLike, Item ingredient) {
                this
                    .shapeless(RecipeCategory.REDSTONE, itemLike, 1)
                    .requires(ingredient)
                    .requires(Items.TRIPWIRE_HOOK)
                    .group("trapped_chest")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(recipeOutput);
            }

            public void barrelBuilder(ItemLike itemLike, Item ingredient, Item slab) {
                this
                    .shaped(RecipeCategory.MISC, itemLike, 1)
                    .define('w', ingredient)
                    .define('s', slab)
                    .pattern("wsw")
                    .pattern("w w")
                    .pattern("wsw")
                    .group("barrel")
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .unlockedBy(getHasName(slab), has(slab))
                    .save(recipeOutput);
            }
        };
    }


    @Override
    public @NonNull String getName() {
        return "ViniisVariantsModRecipeProvider";
    }
}
