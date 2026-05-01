package com.vinii.v2m.block;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.blocks.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.litBlockEmission;

public class ModBlocks {
    public static void initialize() {
        FuelRegistryEvents.BUILD.register((builder, ctx) -> {
                final int CRAFTING_TABLE_BURN_TIME = 300;
                final int CHEST_BURN_TIME = 300;
                final int BARREL_BURN_TIME = 300;

                builder.add(SPRUCE_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(BIRCH_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(DARK_OAK_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(PALE_OAK_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(ACACIA_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(JUNGLE_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(MANGROVE_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(CHERRY_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(BAMBOO_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(CRIMSON_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);
                builder.add(WARPED_CRAFTING_TABLE, CRAFTING_TABLE_BURN_TIME);

                builder.add(SPRUCE_CHEST, CHEST_BURN_TIME);
                builder.add(BIRCH_CHEST, CHEST_BURN_TIME);
                builder.add(DARK_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(PALE_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(ACACIA_CHEST, CHEST_BURN_TIME);
                builder.add(JUNGLE_CHEST, CHEST_BURN_TIME);
                builder.add(MANGROVE_CHEST, CHEST_BURN_TIME);
                builder.add(CHERRY_CHEST, CHEST_BURN_TIME);
                builder.add(BAMBOO_CHEST, CHEST_BURN_TIME);
                builder.add(CRIMSON_CHEST, CHEST_BURN_TIME);
                builder.add(WARPED_CHEST, CHEST_BURN_TIME);

                builder.add(TRAPPED_SPRUCE_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_BIRCH_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_DARK_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_PALE_OAK_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_ACACIA_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_JUNGLE_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_MANGROVE_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_CHERRY_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_BAMBOO_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_CRIMSON_CHEST, CHEST_BURN_TIME);
                builder.add(TRAPPED_WARPED_CHEST, CHEST_BURN_TIME);

                builder.add(OAK_BARREL, BARREL_BURN_TIME);
                builder.add(BIRCH_BARREL, BARREL_BURN_TIME);
                builder.add(DARK_OAK_BARREL, BARREL_BURN_TIME);
                builder.add(PALE_OAK_BARREL, BARREL_BURN_TIME);
                builder.add(ACACIA_BARREL, BARREL_BURN_TIME);
                builder.add(JUNGLE_BARREL, BARREL_BURN_TIME);
                builder.add(MANGROVE_BARREL, BARREL_BURN_TIME);
                builder.add(CHERRY_BARREL, BARREL_BURN_TIME);
                builder.add(BAMBOO_BARREL, BARREL_BURN_TIME);
                builder.add(CRIMSON_BARREL, BARREL_BURN_TIME);
                builder.add(WARPED_BARREL, BARREL_BURN_TIME);
            }
        );
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
            .register((group -> {
                group.addAfter(Items.CRAFTING_TABLE, SPRUCE_CRAFTING_TABLE);
                group.addAfter(SPRUCE_CRAFTING_TABLE, BIRCH_CRAFTING_TABLE);
                group.addAfter(BIRCH_CRAFTING_TABLE, JUNGLE_CRAFTING_TABLE);
                group.addAfter(JUNGLE_CRAFTING_TABLE, ACACIA_CRAFTING_TABLE);
                group.addAfter(ACACIA_CRAFTING_TABLE, DARK_OAK_CRAFTING_TABLE);
                group.addAfter(DARK_OAK_CRAFTING_TABLE, MANGROVE_CRAFTING_TABLE);
                group.addAfter(MANGROVE_CRAFTING_TABLE, CHERRY_CRAFTING_TABLE);
                group.addAfter(CHERRY_CRAFTING_TABLE, PALE_OAK_CRAFTING_TABLE);
                group.addAfter(PALE_OAK_CRAFTING_TABLE, BAMBOO_CRAFTING_TABLE);
                group.addAfter(BAMBOO_CRAFTING_TABLE, CRIMSON_CRAFTING_TABLE);
                group.addAfter(CRIMSON_CRAFTING_TABLE, WARPED_CRAFTING_TABLE);

                group.addAfter(Items.CHEST, SPRUCE_CHEST);
                group.addAfter(SPRUCE_CHEST, BIRCH_CHEST);
                group.addAfter(BIRCH_CHEST, JUNGLE_CHEST);
                group.addAfter(JUNGLE_CHEST, ACACIA_CHEST);
                group.addAfter(ACACIA_CHEST, DARK_OAK_CHEST);
                group.addAfter(DARK_OAK_CHEST, MANGROVE_CHEST);
                group.addAfter(MANGROVE_CHEST, CHERRY_CHEST);
                group.addAfter(CHERRY_CHEST, PALE_OAK_CHEST);
                group.addAfter(PALE_OAK_CHEST, BAMBOO_CHEST);
                group.addAfter(BAMBOO_CHEST, CRIMSON_CHEST);
                group.addAfter(CRIMSON_CHEST, WARPED_CHEST);

                group.addAfter(Items.TRAPPED_CHEST, TRAPPED_SPRUCE_CHEST);
                group.addAfter(TRAPPED_SPRUCE_CHEST, BIRCH_CRAFTING_TABLE);
                group.addAfter(TRAPPED_BIRCH_CHEST, JUNGLE_CRAFTING_TABLE);
                group.addAfter(JUNGLE_CRAFTING_TABLE, ACACIA_CRAFTING_TABLE);
                group.addAfter(ACACIA_CRAFTING_TABLE, DARK_OAK_CRAFTING_TABLE);
                group.addAfter(DARK_OAK_CRAFTING_TABLE, MANGROVE_CRAFTING_TABLE);
                group.addAfter(MANGROVE_CRAFTING_TABLE, CHERRY_CRAFTING_TABLE);
                group.addAfter(CHERRY_CRAFTING_TABLE, PALE_OAK_CRAFTING_TABLE);
                group.addAfter(PALE_OAK_CRAFTING_TABLE, BAMBOO_CRAFTING_TABLE);
                group.addAfter(BAMBOO_CRAFTING_TABLE, CRIMSON_CRAFTING_TABLE);
                group.addAfter(CRIMSON_CRAFTING_TABLE, WARPED_CRAFTING_TABLE);

                group.addBefore(Items.BARREL, OAK_BARREL);
                group.addAfter(Items.BARREL, BIRCH_BARREL);
                group.addAfter(BIRCH_BARREL, JUNGLE_BARREL);
                group.addAfter(JUNGLE_BARREL, ACACIA_BARREL);
                group.addAfter(ACACIA_BARREL, DARK_OAK_BARREL);
                group.addAfter(DARK_OAK_BARREL, MANGROVE_BARREL);
                group.addAfter(MANGROVE_BARREL, CHERRY_BARREL);
                group.addAfter(CHERRY_BARREL, PALE_OAK_BARREL);
                group.addAfter(PALE_OAK_BARREL, BAMBOO_BARREL);
                group.addAfter(BAMBOO_BARREL, CRIMSON_BARREL);
                group.addAfter(CRIMSON_BARREL, WARPED_BARREL);

                group.addAfter(Items.FURNACE, BLACKSTONE_FURNACE);
                group.addAfter(BLACKSTONE_FURNACE, DEEPSLATE_FURNACE);
            }));
    }

    // TODO: translucent pixels are glitchy when opens world, see how tinted glass does it
    public static final Block FROSTED_GLASS_PANE = glassPaneRegister("frosted_glass_pane");
    public static final Block SANDY_GLASS_PANE = glassPaneRegister("sandy_glass_pane");

    // TODO: create functions
    public static final Block PALE_PUMPKIN = register(
        "pale_pumpkin",
        PalePumpkinBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.QUARTZ)
            .instrument(NoteBlockInstrument.DIDGERIDOO)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .pushReaction(PushReaction.DESTROY),
        true
    );

    public static final Block CARVED_PALE_PUMPKIN = register(
        "carved_pale_pumpkin",
        CarvedPalePumpkinBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.QUARTZ)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .isValidSpawn(Blocks::always)
            .pushReaction(PushReaction.DESTROY),
        true
    );

    public static final Block PALE_JACK_O_LANTERN = register(
        "pale_jack_o_lantern",
        CarvedPalePumpkinBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(MapColor.QUARTZ)
            .strength(1.0F)
            .sound(SoundType.WOOD)
            .lightLevel((blockStatex) -> 15).isValidSpawn(Blocks::always).pushReaction(PushReaction.DESTROY),
        true
    );

    // OAK is vanilla but modified textures name and recipe
    public static final Block SPRUCE_CRAFTING_TABLE = craftingTableRegister("spruce_crafting_table", MapColor.PODZOL, true);
    public static final Block BIRCH_CRAFTING_TABLE = craftingTableRegister("birch_crafting_table", MapColor.SAND, true);
    public static final Block DARK_OAK_CRAFTING_TABLE = craftingTableRegister("dark_oak_crafting_table", MapColor.COLOR_BROWN, true);
    public static final Block PALE_OAK_CRAFTING_TABLE = craftingTableRegister("pale_oak_crafting_table", MapColor.QUARTZ, true);
    public static final Block ACACIA_CRAFTING_TABLE = craftingTableRegister("acacia_crafting_table", MapColor.COLOR_ORANGE, true);
    public static final Block JUNGLE_CRAFTING_TABLE = craftingTableRegister("jungle_crafting_table", MapColor.DIRT, true);
    public static final Block MANGROVE_CRAFTING_TABLE = craftingTableRegister("mangrove_crafting_table", MapColor.COLOR_RED, true);
    public static final Block CHERRY_CRAFTING_TABLE = craftingTableRegister("cherry_crafting_table", MapColor.TERRACOTTA_WHITE, true);
    public static final Block BAMBOO_CRAFTING_TABLE = craftingTableRegister("bamboo_crafting_table", MapColor.COLOR_YELLOW, true);
    public static final Block CRIMSON_CRAFTING_TABLE = craftingTableRegister("crimson_crafting_table", MapColor.CRIMSON_STEM, false);
    public static final Block WARPED_CRAFTING_TABLE = craftingTableRegister("warped_crafting_table", MapColor.WARPED_STEM, false);

    // OAK is vanilla but modified textures name and recipe
    public static final Block SPRUCE_CHEST = chestRegister("spruce_chest", MapColor.PODZOL, true);
    public static final Block BIRCH_CHEST = chestRegister("birch_chest", MapColor.SAND, true);
    public static final Block DARK_OAK_CHEST = chestRegister("dark_oak_chest", MapColor.COLOR_BROWN, true);
    public static final Block PALE_OAK_CHEST = chestRegister("pale_oak_chest", MapColor.QUARTZ, true);
    public static final Block ACACIA_CHEST = chestRegister("acacia_chest", MapColor.COLOR_ORANGE, true);
    public static final Block JUNGLE_CHEST = chestRegister("jungle_chest", MapColor.DIRT, true);
    public static final Block MANGROVE_CHEST = chestRegister("mangrove_chest", MapColor.COLOR_RED, true);
    public static final Block CHERRY_CHEST = chestRegister("cherry_chest", MapColor.TERRACOTTA_WHITE, true);
    public static final Block BAMBOO_CHEST = chestRegister("bamboo_chest", MapColor.COLOR_YELLOW, true);
    public static final Block CRIMSON_CHEST = chestRegister("crimson_chest", MapColor.CRIMSON_STEM, false);
    public static final Block WARPED_CHEST = chestRegister("warped_chest", MapColor.WARPED_STEM, false);

    // OAK is vanilla but modified textures name and recipe
    public static final Block TRAPPED_SPRUCE_CHEST = trappedChestRegister("trapped_spruce_chest", MapColor.PODZOL, true);
    public static final Block TRAPPED_BIRCH_CHEST = trappedChestRegister("trapped_birch_chest", MapColor.SAND, true);
    public static final Block TRAPPED_DARK_OAK_CHEST = trappedChestRegister("trapped_dark_oak_chest", MapColor.COLOR_BROWN, true);
    public static final Block TRAPPED_PALE_OAK_CHEST = trappedChestRegister("trapped_pale_oak_chest", MapColor.QUARTZ, true);
    public static final Block TRAPPED_ACACIA_CHEST = trappedChestRegister("trapped_acacia_chest", MapColor.COLOR_ORANGE, true);
    public static final Block TRAPPED_JUNGLE_CHEST = trappedChestRegister("trapped_jungle_chest", MapColor.DIRT, true);
    public static final Block TRAPPED_MANGROVE_CHEST = trappedChestRegister("trapped_mangrove_chest", MapColor.COLOR_RED, true);
    public static final Block TRAPPED_CHERRY_CHEST = trappedChestRegister("trapped_cherry_chest", MapColor.TERRACOTTA_WHITE, true);
    public static final Block TRAPPED_BAMBOO_CHEST = trappedChestRegister("trapped_bamboo_chest", MapColor.COLOR_YELLOW, true);
    public static final Block TRAPPED_CRIMSON_CHEST = trappedChestRegister("trapped_crimson_chest", MapColor.CRIMSON_STEM, false);
    public static final Block TRAPPED_WARPED_CHEST = trappedChestRegister("trapped_warped_chest", MapColor.WARPED_STEM, false);

    // SPRUCE is vanilla but modified textures name and recipe
    public static final Block OAK_BARREL = barrelRegister("oak_barrel", MapColor.WOOD, true);
    public static final Block BIRCH_BARREL = barrelRegister("birch_barrel", MapColor.SAND, true);
    public static final Block DARK_OAK_BARREL = barrelRegister("dark_oak_barrel", MapColor.COLOR_BROWN, true);
    public static final Block PALE_OAK_BARREL = barrelRegister("pale_oak_barrel", MapColor.QUARTZ, true);
    public static final Block ACACIA_BARREL = barrelRegister("acacia_barrel", MapColor.COLOR_ORANGE, true);
    public static final Block JUNGLE_BARREL = barrelRegister("jungle_barrel", MapColor.DIRT, true);
    public static final Block MANGROVE_BARREL = barrelRegister("mangrove_barrel", MapColor.COLOR_RED, true);
    public static final Block CHERRY_BARREL = barrelRegister("cherry_barrel", MapColor.TERRACOTTA_WHITE, true);
    public static final Block BAMBOO_BARREL = barrelRegister("bamboo_barrel", MapColor.COLOR_YELLOW, true);
    public static final Block CRIMSON_BARREL = barrelRegister("crimson_barrel", MapColor.CRIMSON_STEM, false);
    public static final Block WARPED_BARREL = barrelRegister("warped_barrel", MapColor.WARPED_STEM, false);

    // STONE is vanilla but modified textures name and recipe
    public static final Block BLACKSTONE_FURNACE = furnaceRegister("blackstone_furnace", MapColor.COLOR_BLACK);
    public static final Block DEEPSLATE_FURNACE = furnaceRegister("deepslate_furnace", MapColor.DEEPSLATE);

    private static Block chestRegister(String name, MapColor mapColor, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(mapColor)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD);
        if (burns) {
            properties.ignitedByLava();
        }
        return register(
            name,
            props -> new ModChestBlock(
                SoundEvents.CHEST_OPEN,
                SoundEvents.CHEST_CLOSE,
                props,
                name
            ),
            properties,
            true
        );
    }

    private static Block trappedChestRegister(String name, MapColor mapColor, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(mapColor)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD);
        if (burns) {
            properties.ignitedByLava();
        }
        return register(
            name,
            props -> new ModTrappedChestBlock(
                props,
                name
            ),
            properties,
            true
        );
    }

    private static Block barrelRegister(String name, MapColor mapColor, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(mapColor)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD);
        if (burns) {
            properties.ignitedByLava();
        }
        return register(
            name,
            props -> new ModBarrelBlock(props, name),
            properties,
            true
        );
    }

    private static Block furnaceRegister(String name, MapColor mapColor) {
        return register(
            name,
            props -> new ModFurnaceBlock(props, name),
            BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops()
                .strength(3.5F)
                .lightLevel(litBlockEmission(13)),
            true
        );
    }

    private static Block craftingTableRegister(String name, MapColor mapColor, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(mapColor)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD);
        if (burns) {
            properties.ignitedByLava();
        }
        return register(
            name,
            ModCraftingTableBlock::new,
            properties,
            true
        );
    }

    private static Block glassPaneRegister(String name) {
        return register(
            name,
            IronBarsBlock::new,
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.HAT)
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion(),
            false
        );
    }

    private static Block register(
        String name,
        Function<BlockBehaviour.Properties, Block> blockFactory,
        BlockBehaviour.Properties settings,
        boolean shouldRegisterItem
    ) {
        ResourceKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, name));
    }
}
