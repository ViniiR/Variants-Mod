package com.vinii.v2m.block;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.blocks.ModBarrelBlock;
import com.vinii.v2m.block.blocks.ModChestBlock;
import com.vinii.v2m.block.blocks.ModCraftingTableBlock;
import com.vinii.v2m.block.blocks.ModFurnaceBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

import static net.minecraft.world.level.block.Blocks.litBlockEmission;

public class ModBlocks {
    public static void initialize() {
    }

    // TODO: set fuel registry for wood items

    // Not data generated, loot tables are manual
    public static final Block FROSTED_GLASS_PANE = glassPaneRegister("frosted_glass_pane");
    public static final Block SANDY_GLASS_PANE = glassPaneRegister("sandy_glass_pane");

    // TODO: set map color individually

    // OAK is vanilla but modified textures name and recipe
    public static final Block SPRUCE_CRAFTING_TABLE = craftingTableRegister("spruce_crafting_table", true);
    public static final Block BIRCH_CRAFTING_TABLE = craftingTableRegister("birch_crafting_table", true);
    public static final Block DARK_OAK_CRAFTING_TABLE = craftingTableRegister("dark_oak_crafting_table", true);
    public static final Block PALE_OAK_CRAFTING_TABLE = craftingTableRegister("pale_oak_crafting_table", true);
    public static final Block ACACIA_CRAFTING_TABLE = craftingTableRegister("acacia_crafting_table", true);
    public static final Block JUNGLE_CRAFTING_TABLE = craftingTableRegister("jungle_crafting_table", true);
    public static final Block MANGROVE_CRAFTING_TABLE = craftingTableRegister("mangrove_crafting_table", true);
    public static final Block CHERRY_CRAFTING_TABLE = craftingTableRegister("cherry_crafting_table", true);
    public static final Block BAMBOO_CRAFTING_TABLE = craftingTableRegister("bamboo_crafting_table", true);
    public static final Block CRIMSON_CRAFTING_TABLE = craftingTableRegister("crimson_crafting_table", false);
    public static final Block WARPED_CRAFTING_TABLE = craftingTableRegister("warped_crafting_table", false);

    // TODO: register trapped chests too
    // OAK is vanilla but modified textures name and recipe
    public static final Block SPRUCE_CHEST = chestRegister("spruce_chest", true);
    public static final Block BIRCH_CHEST = chestRegister("birch_chest", true);
    public static final Block DARK_OAK_CHEST = chestRegister("dark_oak_chest", true);
    public static final Block PALE_OAK_CHEST = chestRegister("pale_oak_chest", true);
    public static final Block ACACIA_CHEST = chestRegister("acacia_chest", true);
    public static final Block JUNGLE_CHEST = chestRegister("jungle_chest", true);
    public static final Block MANGROVE_CHEST = chestRegister("mangrove_chest", true);
    public static final Block CHERRY_CHEST = chestRegister("cherry_chest", true);
    public static final Block BAMBOO_CHEST = chestRegister("bamboo_chest", true);
    public static final Block CRIMSON_CHEST = chestRegister("crimson_chest", false);
    public static final Block WARPED_CHEST = chestRegister("warped_chest", false);

    // TODO: make all barrels valid profession blocks
    // SPRUCE is vanilla but modified textures name and recipe
    public static final Block OAK_BARREL = barrelRegister("oak_barrel", true);
    public static final Block BIRCH_BARREL = barrelRegister("birch_barrel", true);
    public static final Block DARK_OAK_BARREL = barrelRegister("dark_oak_barrel", true);
    public static final Block PALE_OAK_BARREL = barrelRegister("pale_oak_barrel", true);
    public static final Block ACACIA_BARREL = barrelRegister("acacia_barrel", true);
    public static final Block JUNGLE_BARREL = barrelRegister("jungle_barrel", true);
    public static final Block MANGROVE_BARREL = barrelRegister("mangrove_barrel", true);
    public static final Block CHERRY_BARREL = barrelRegister("cherry_barrel", true);
    public static final Block BAMBOO_BARREL = barrelRegister("bamboo_barrel", true);
    public static final Block CRIMSON_BARREL = barrelRegister("crimson_barrel", false);
    public static final Block WARPED_BARREL = barrelRegister("warped_barrel", false);

    // STONE is vanilla but modified textures name and recipe
    public static final Block BLACKSTONE_FURNACE = furnaceRegister("blackstone_furnace");
    public static final Block DEEPSLATE_FURNACE = furnaceRegister("deepslate_furnace");

    private static Block chestRegister(String name, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD);
        if (burns) {
            properties.ignitedByLava();
        }
        return register(
            name,
            props -> new ModChestBlock(SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, props, name),
            properties,
            true
        );
    }

    private static Block barrelRegister(String name, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
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

    private static Block furnaceRegister(String name) {
        return register(
            name,
            props -> new ModFurnaceBlock(props, name),
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops()
                .strength(3.5F)
                .lightLevel(litBlockEmission(13)),
            true
        );
    }

    private static Block craftingTableRegister(String name, Boolean burns) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
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
