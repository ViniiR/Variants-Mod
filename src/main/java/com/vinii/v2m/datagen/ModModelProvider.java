package com.vinii.v2m.datagen;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.block.blocks.ModChestBlock;
import com.vinii.v2m.block.blocks.ModTrappedChestBlock;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jspecify.annotations.NonNull;

import static net.minecraft.client.data.models.BlockModelGenerators.createBooleanModelDispatch;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;
import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
//        createChestItem(itemModelGenerators, ModBlocks.SPRUCE_CHEST.asItem());
    }
//
//    public void createChestItem(ItemModelGenerators generators, Item item) {
//        generators.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
//    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        createGlassPane(blockModelGenerators, ModBlocks.FROSTED_GLASS_PANE);
        // TODO: see how to include sandy glass pane properly
        // createGlassPane(blockModelGenerators, ModBlocks.SANDY_GLASS_PANE);

        createCraftingTable(blockModelGenerators, ModBlocks.SPRUCE_CRAFTING_TABLE, Blocks.SPRUCE_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.BIRCH_CRAFTING_TABLE, Blocks.BIRCH_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.ACACIA_CRAFTING_TABLE, Blocks.ACACIA_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.DARK_OAK_CRAFTING_TABLE, Blocks.DARK_OAK_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.PALE_OAK_CRAFTING_TABLE, Blocks.PALE_OAK_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.JUNGLE_CRAFTING_TABLE, Blocks.JUNGLE_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.CHERRY_CRAFTING_TABLE, Blocks.CHERRY_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.BAMBOO_CRAFTING_TABLE, Blocks.BAMBOO_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.MANGROVE_CRAFTING_TABLE, Blocks.MANGROVE_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.CRIMSON_CRAFTING_TABLE, Blocks.CRIMSON_PLANKS);
        createCraftingTable(blockModelGenerators, ModBlocks.WARPED_CRAFTING_TABLE, Blocks.WARPED_PLANKS);

        createChest(blockModelGenerators, ModBlocks.SPRUCE_CHEST, Blocks.SPRUCE_PLANKS);
        createChest(blockModelGenerators, ModBlocks.BIRCH_CHEST, Blocks.BIRCH_PLANKS);
        createChest(blockModelGenerators, ModBlocks.ACACIA_CHEST, Blocks.ACACIA_PLANKS);
        createChest(blockModelGenerators, ModBlocks.DARK_OAK_CHEST, Blocks.DARK_OAK_PLANKS);
        createChest(blockModelGenerators, ModBlocks.PALE_OAK_CHEST, Blocks.PALE_OAK_PLANKS);
        createChest(blockModelGenerators, ModBlocks.JUNGLE_CHEST, Blocks.JUNGLE_PLANKS);
        createChest(blockModelGenerators, ModBlocks.CHERRY_CHEST, Blocks.CHERRY_PLANKS);
        createChest(blockModelGenerators, ModBlocks.BAMBOO_CHEST, Blocks.BAMBOO_PLANKS);
        createChest(blockModelGenerators, ModBlocks.MANGROVE_CHEST, Blocks.MANGROVE_PLANKS);
        createChest(blockModelGenerators, ModBlocks.CRIMSON_CHEST, Blocks.CRIMSON_PLANKS);
        createChest(blockModelGenerators, ModBlocks.WARPED_CHEST, Blocks.WARPED_PLANKS);

        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_SPRUCE_CHEST, Blocks.SPRUCE_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_BIRCH_CHEST, Blocks.BIRCH_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_ACACIA_CHEST, Blocks.ACACIA_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_DARK_OAK_CHEST, Blocks.DARK_OAK_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_PALE_OAK_CHEST, Blocks.PALE_OAK_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_JUNGLE_CHEST, Blocks.JUNGLE_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_CHERRY_CHEST, Blocks.CHERRY_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_BAMBOO_CHEST, Blocks.BAMBOO_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_MANGROVE_CHEST, Blocks.MANGROVE_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_CRIMSON_CHEST, Blocks.CRIMSON_PLANKS);
        createTrappedChest(blockModelGenerators, ModBlocks.TRAPPED_WARPED_CHEST, Blocks.WARPED_PLANKS);

        createBarrel(blockModelGenerators, ModBlocks.OAK_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.BIRCH_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.ACACIA_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.DARK_OAK_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.PALE_OAK_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.JUNGLE_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.CHERRY_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.BAMBOO_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.MANGROVE_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.CRIMSON_BARREL);
        createBarrel(blockModelGenerators, ModBlocks.WARPED_BARREL);

        createFurnace(blockModelGenerators, ModBlocks.BLACKSTONE_FURNACE);
        createFurnace(blockModelGenerators, ModBlocks.DEEPSLATE_FURNACE);
    }

    public Identifier makePathableIdentifier(Block block, String pathPrefix, String suffix) {
        // Does not remove "_pane" from _glass_pane because it has a suffix like "_top" which does exist
        return BuiltInRegistries.BLOCK.getKey(block)
            .withPath(str -> "block/" + pathPrefix + str + suffix);
    }

    public Identifier makePathableIdentifier(Block block, String pathPrefix) {
        // Removes "_pane" from _glass_pane, it uses "glass" texture
        String name = block.getName().getString();
        if (name.contains("_glass_pane")) {
            return BuiltInRegistries.BLOCK.getKey(block)
                .withPath(str -> "block/" + pathPrefix + str.replace("_pane", ""));
        }

        return BuiltInRegistries.BLOCK.getKey(block)
            .withPath(str -> "block/" + pathPrefix + str);
    }

    public void createGlassPane(BlockModelGenerators generators, Block block) {
        TextureMapping textureMapping = new TextureMapping()
            .put(TextureSlot.PANE, makePathableIdentifier(block, "glass/"))
            .put(TextureSlot.EDGE, makePathableIdentifier(block, "glass/", "_top")
            );

        MultiVariant multiVariant = plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST
            .create(
                block,
                textureMapping,
                generators.modelOutput
            )
        );
        MultiVariant multiVariant2 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE
            .create(block, textureMapping, generators.modelOutput));
        MultiVariant multiVariant3 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT
            .create(block, textureMapping, generators.modelOutput));
        MultiVariant multiVariant4 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE
            .create(block, textureMapping, generators.modelOutput));
        MultiVariant multiVariant5 = plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT
            .create(block, textureMapping, generators.modelOutput));

        generators.blockStateOutput
            .accept(
                MultiPartGenerator.multiPart(block)
                    .with(multiVariant)
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.NORTH, true), multiVariant2)
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.EAST, true), multiVariant2.with(BlockModelGenerators.Y_ROT_90))
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.SOUTH, true), multiVariant3)
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.WEST, true), multiVariant3.with(BlockModelGenerators.Y_ROT_90))
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.NORTH, false), multiVariant4)
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.EAST, false), multiVariant5)
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.SOUTH, false), multiVariant5.with(BlockModelGenerators.Y_ROT_90))
                    .with(BlockModelGenerators.condition()
                        .term(BlockStateProperties.WEST, false), multiVariant4.with(BlockModelGenerators.Y_ROT_270))
            );
    }

    public void createCraftingTable(BlockModelGenerators generators, Block block, Block planks) {
        generators.createCraftingTableLike(
            block,
            planks,
            (craftingTable, planksBlock) ->
                new TextureMapping()
                    .put(TextureSlot.PARTICLE, makePathableIdentifier(craftingTable, "crafting_table/", "_front"))
                    .put(TextureSlot.DOWN, getBlockTexture(planksBlock))
                    .put(TextureSlot.UP, makePathableIdentifier(craftingTable, "crafting_table/", "_top"))
                    .put(TextureSlot.NORTH, makePathableIdentifier(craftingTable, "crafting_table/", "_front"))
                    .put(TextureSlot.EAST, makePathableIdentifier(craftingTable, "crafting_table/", "_side"))
                    .put(TextureSlot.SOUTH, makePathableIdentifier(craftingTable, "crafting_table/", "_side"))
                    .put(TextureSlot.WEST, makePathableIdentifier(craftingTable, "crafting_table/", "_front"))
        );
    }

    public void createFurnace(BlockModelGenerators generators, Block block) {
        TexturedModel.Provider provider = TexturedModel.ORIENTABLE_ONLY_TOP;

        // Normal furnace texture
        MultiVariant multiVariantOff = plainVariant(provider
            .get(block)
            .updateTextures(textureMapping -> {
                textureMapping.put(TextureSlot.TOP, makePathableIdentifier(block, "furnace/", "_top"));
                textureMapping.put(TextureSlot.FRONT, makePathableIdentifier(block, "furnace/", "_front"));
                textureMapping.put(TextureSlot.SIDE, makePathableIdentifier(block, "furnace/", "_side"));
                // Furnaces don't actually have a bottom texture huh, but they should!!!
                // textureMapping.put(TextureSlot.BOTTOM, makePathableIdentifier(block, "furnace/", "_bottom"));
            })
            .create(block, generators.modelOutput)
        );

        // Lit/On furnace texture
        MultiVariant multiVariantLit = plainVariant(provider
            .get(block)
            .updateTextures(textureMapping -> {
                textureMapping.put(TextureSlot.TOP, makePathableIdentifier(block, "furnace/", "_top"));
                textureMapping.put(TextureSlot.FRONT, makePathableIdentifier(block, "furnace/", "_front_on"));
                textureMapping.put(TextureSlot.SIDE, makePathableIdentifier(block, "furnace/", "_side"));
                // Furnaces don't actually have a bottom texture huh, but they should!!!
                // textureMapping.put(TextureSlot.BOTTOM, makePathableIdentifier(block, "furnace/", "_bottom"));
            })
            // File name suffix
            .createWithSuffix(block, "_on", generators.modelOutput)
        );

        // Creates the files
        generators.blockStateOutput
            .accept(
                MultiVariantGenerator.dispatch(block)
                    .with(createBooleanModelDispatch(
                        BlockStateProperties.LIT,
                        multiVariantLit,
                        multiVariantOff)
                    )
                    .with(PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.EAST, BlockModelGenerators.Y_ROT_90)
                        .select(Direction.SOUTH, BlockModelGenerators.Y_ROT_180)
                        .select(Direction.WEST, BlockModelGenerators.Y_ROT_270)
                        .select(Direction.NORTH, BlockModelGenerators.NOP)
                    )
            );
    }

    public void createBarrel(BlockModelGenerators generators, Block block) {
        TexturedModel.Provider provider = TexturedModel.CUBE_TOP_BOTTOM;

        // Standard barrel texture
        MultiVariant closedMultiVariant = plainVariant(provider
            .get(block)
            .updateTextures(textureMapping -> {
                textureMapping.put(TextureSlot.TOP, makePathableIdentifier(block, "barrel/", "_top"));
                textureMapping.put(TextureSlot.SIDE, makePathableIdentifier(block, "barrel/", "_side"));
                textureMapping.put(TextureSlot.BOTTOM, makePathableIdentifier(block, "barrel/", "_bottom"));
            })
            .create(block, generators.modelOutput)
        );

        // Open barrel texture
        MultiVariant openMultiVariant = plainVariant(provider
            // weirdly enough .get(block) doesn't really get closedMultiVariant, seems to create a new one
            .get(block)
            .updateTextures(textureMapping -> {
                    textureMapping.put(TextureSlot.TOP, makePathableIdentifier(block, "barrel/", "_top_open"));
                    textureMapping.put(TextureSlot.SIDE, makePathableIdentifier(block, "barrel/", "_side"));
                    textureMapping.put(TextureSlot.BOTTOM, makePathableIdentifier(block, "barrel/", "_bottom"));
                }
            )
            // File name suffix
            .createWithSuffix(block, "_open", generators.modelOutput)
        );

        // Creates the files
        generators.blockStateOutput
            .accept(
                MultiVariantGenerator.dispatch(block)
                    .with(PropertyDispatch.initial(BlockStateProperties.OPEN)
                        .select(false, closedMultiVariant)
                        .select(true, openMultiVariant)
                    )
                    .with(PropertyDispatch.modify(BlockStateProperties.FACING)
                        .select(Direction.DOWN, BlockModelGenerators.X_ROT_180)
                        .select(Direction.UP, BlockModelGenerators.NOP)
                        .select(Direction.NORTH, BlockModelGenerators.X_ROT_90)
                        .select(Direction.SOUTH, BlockModelGenerators.X_ROT_90.then(BlockModelGenerators.Y_ROT_180))
                        .select(Direction.WEST, BlockModelGenerators.X_ROT_90.then(BlockModelGenerators.Y_ROT_270))
                        .select(Direction.EAST, BlockModelGenerators.X_ROT_90.then(BlockModelGenerators.Y_ROT_90)
                        )
                    )
            );
    }

    public void createChest(BlockModelGenerators generators, Block block, Block particles) {
        Identifier identifier = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, block.getName().getString());
        if (block instanceof ModChestBlock chestBlock) {
            identifier = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, chestBlock.variant);
        }
        generators.createChest(
            block,
            particles,
            identifier,
            true
        );
    }

    public void createTrappedChest(BlockModelGenerators generators, Block block, Block particles) {
        Identifier identifier = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, block.getName().getString());
        if (block instanceof ModTrappedChestBlock chestBlock) {
            identifier = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "trapped/" + chestBlock.variant);
        }
        generators.createChest(
            block,
            particles,
            identifier,
            true
        );
    }

    @Override
    public @NonNull String getName() {
        return "ViniisVariantsModModelProvider";
    }
}
