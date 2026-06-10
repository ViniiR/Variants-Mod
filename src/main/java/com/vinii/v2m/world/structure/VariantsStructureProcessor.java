package com.vinii.v2m.world.structure;

import com.mojang.serialization.MapCodec;
import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.Set;

enum Dimension {
    OVERWORLD,
    NETHER,
    END
}

public class VariantsStructureProcessor extends StructureProcessor {
    public static final VariantsStructureProcessor INSTANCE = new VariantsStructureProcessor();
    public static final MapCodec<VariantsStructureProcessor> CODEC = MapCodec.unit(VariantsStructureProcessor.INSTANCE);

    @Override
    protected @NonNull StructureProcessorType<?> getType() {
        return ModStructureProcessors.VARIANTS_PROCESSOR;
    }

    public static final Set<Block> MODIFIABLE_BLOCKS = Set.of(
        Blocks.CHEST,
        Blocks.TRAPPED_CHEST,
        Blocks.BARREL,
        Blocks.FURNACE,
        Blocks.CRAFTING_TABLE,
        Blocks.GLASS_PANE
    );

    public static final Map<Block, Block> SHIPWRECK_CHEST_WOOD_VARIANTS = Map.ofEntries(
        Map.entry(Blocks.OAK_PLANKS, Blocks.CHEST),
        Map.entry(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CHEST),
        Map.entry(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CHEST),
        Map.entry(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CHEST),
        Map.entry(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CHEST),
        Map.entry(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CHEST),
        Map.entry(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CHEST),
        Map.entry(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_CHEST),
        Map.entry(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CHEST),
        Map.entry(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CHEST)
    );

    @Override
    public StructureTemplate.@Nullable StructureBlockInfo processBlock(
        @NonNull LevelReader level,
        @NonNull BlockPos targetPosition, // Block pos
        @NonNull BlockPos referencePos, // Structure pivot pos
        StructureTemplate.@NonNull StructureBlockInfo originalBlockInfo,
        StructureTemplate.@NonNull StructureBlockInfo processedBlockInfo,
        @NonNull StructurePlaceSettings settings
    ) {
        // Default
        if (!MODIFIABLE_BLOCKS.contains(originalBlockInfo.state().getBlock())) {
            return super.processBlock(level, targetPosition, referencePos, originalBlockInfo, processedBlockInfo, settings);
        }

        BlockState newState;
        Block shipwreckChest = null;

        // TODO: get the block below (and or adjacent to) the chest
        // then get which type of planks it is
        // however using levelReader does not return structure generated blocks

        // Have to check all chests instead of just checking if it's a shipwreck
//        if (processedBlockInfo.state().is(Blocks.CHEST)) {
//            Block plank = getAdjacentPlanks(level, targetPosition, settings);
//
//            ViniisVariantsMod.LOGGER.info("Adjacent block: {}", plank);
//
//            if (plank != null) {
//                shipwreckChest = SHIPWRECK_CHEST_WOOD_VARIANTS.get(plank);
//            }
//        }

        // NOTE: passing structure referencePos instead of targetPos
        newState = shipwreckChest != null ?
            shipwreckChest.defaultBlockState() :
            getReplacedBlock(level, referencePos, processedBlockInfo.state());

        // Late Default
        if (newState == null) {
            return super.processBlock(level, targetPosition, referencePos, originalBlockInfo, processedBlockInfo, settings);
        }

        for (Property<?> property : processedBlockInfo.state().getProperties()) {
            if (newState.hasProperty(property)) {
                newState = copyProperty(newState, processedBlockInfo.state(), property);
            }
        }

        return new StructureTemplate.StructureBlockInfo(processedBlockInfo.pos(), newState, processedBlockInfo.nbt());
    }

    private <T extends Comparable<T>> BlockState copyProperty(BlockState newState, BlockState source, Property<T> property) {
        return newState.setValue(property, source.getValue(property));
    }

    private @Nullable Block getAdjacentPlanks(LevelReader levelReader, BlockPos pos, StructurePlaceSettings settings) {
        // Respect south-east bias lol
        BlockPos[] coordinates = {
            pos.below(),
            pos.south(),
            pos.east(),
            pos.north(),
            pos.west(),
            pos.above()
        };

        for (var coordinate : coordinates) {
            BlockState state = levelReader.getBlockState(coordinate);

            ViniisVariantsMod.LOGGER.info("Inner Adjacent block: {}", state.getBlock());
            if (state.is(BlockTags.PLANKS)) {
                return state.getBlock();
            }
        }

        return null;
    }

    private @Nullable Holder<Biome> getBiome(LevelReader level, BlockPos pos) {
        if (level instanceof ServerLevelAccessor accessor) {
            ServerLevel serverLevel = accessor.getLevel();
            ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();

            int quartX = QuartPos.fromBlock(pos.getX());
            int quartY = QuartPos.fromBlock(pos.getY());
            int quartZ = QuartPos.fromBlock(pos.getZ());

            Climate.Sampler sampler = serverLevel.getChunkSource().randomState().sampler();

            return chunkGenerator.getBiomeSource().getNoiseBiome(quartX, quartY, quartZ, sampler);
        }
        return null;
    }

    /// Null should be parsed as default block
    private @Nullable BlockState getReplacedBlock(LevelReader level, BlockPos pos, BlockState originalBlock) {
        Holder<Biome> biome = getBiome(level, pos);
        if (biome == null) {
            return null;
        }

        Dimension dimension = getDimension(level);

        return switch (dimension) {
            // Handle furnaces separately since they're more complex
            case Dimension d when d == Dimension.OVERWORLD && originalBlock.is(Blocks.FURNACE) && pos.getY() < 0 ->
                ModBlocks.DEEPSLATE_FURNACE.defaultBlockState();
            case Dimension d when d == Dimension.NETHER && originalBlock.is(Blocks.FURNACE) ->
                ModBlocks.BLACKSTONE_FURNACE.defaultBlockState();
            case Dimension _ when originalBlock.is(Blocks.FURNACE) -> null;

            // Glass panes
            case Dimension d when
                d == Dimension.OVERWORLD && originalBlock.is(Blocks.GLASS_PANE) && biome.is(BiomeTags.HAS_VILLAGE_SNOWY) ->
                ModBlocks.FROSTED_GLASS_PANE.defaultBlockState();

            // 2 Nether woods
            case NETHER -> {
                if (biome.is(ModBiomeTagProvider.CRIMSON_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.CRIMSON_CRAFTING_TABLE, ModBlocks.CRIMSON_CHEST, ModBlocks.TRAPPED_CRIMSON_CHEST, ModBlocks.CRIMSON_BARREL);
                } else if (biome.is(ModBiomeTagProvider.WARPED_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.WARPED_CRAFTING_TABLE, ModBlocks.WARPED_CHEST, ModBlocks.TRAPPED_WARPED_CHEST, ModBlocks.WARPED_BARREL);
                } else {
                    yield null;
                }
            }

            case OVERWORLD -> {
                if (biome.is(ModBiomeTagProvider.SPRUCE_VARIANT_BIOMES)) {
                    if (originalBlock.is(Blocks.BARREL)) {
                        yield null;
                    }
                    // Use vanilla barrel as a mock-up
                    yield getWoodBlockVariant(originalBlock, ModBlocks.SPRUCE_CRAFTING_TABLE, ModBlocks.SPRUCE_CHEST, ModBlocks.TRAPPED_SPRUCE_CHEST, Blocks.BARREL);
                }
                if (biome.is(ModBiomeTagProvider.BIRCH_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.BIRCH_CRAFTING_TABLE, ModBlocks.BIRCH_CHEST, ModBlocks.TRAPPED_BIRCH_CHEST, ModBlocks.BIRCH_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.ACACIA_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.ACACIA_CRAFTING_TABLE, ModBlocks.ACACIA_CHEST, ModBlocks.TRAPPED_ACACIA_CHEST, ModBlocks.ACACIA_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.JUNGLE_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.JUNGLE_CRAFTING_TABLE, ModBlocks.JUNGLE_CHEST, ModBlocks.TRAPPED_JUNGLE_CHEST, ModBlocks.JUNGLE_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.BAMBOO_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.BAMBOO_CRAFTING_TABLE, ModBlocks.BAMBOO_CHEST, ModBlocks.TRAPPED_BAMBOO_CHEST, ModBlocks.BAMBOO_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.DARK_OAK_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.DARK_OAK_CRAFTING_TABLE, ModBlocks.DARK_OAK_CHEST, ModBlocks.TRAPPED_DARK_OAK_CHEST, ModBlocks.DARK_OAK_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.PALE_OAK_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.PALE_OAK_CRAFTING_TABLE, ModBlocks.PALE_OAK_CHEST, ModBlocks.TRAPPED_PALE_OAK_CHEST, ModBlocks.PALE_OAK_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.MANGROVE_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.MANGROVE_CRAFTING_TABLE, ModBlocks.MANGROVE_CHEST, ModBlocks.TRAPPED_MANGROVE_CHEST, ModBlocks.MANGROVE_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.CHERRY_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.CHERRY_CRAFTING_TABLE, ModBlocks.CHERRY_CHEST, ModBlocks.TRAPPED_CHERRY_CHEST, ModBlocks.CHERRY_BARREL);
                }
                if (biome.is(ModBiomeTagProvider.CHERRY_VARIANT_BIOMES)) {
                    yield getWoodBlockVariant(originalBlock, ModBlocks.CHERRY_CRAFTING_TABLE, ModBlocks.CHERRY_CHEST, ModBlocks.TRAPPED_CHERRY_CHEST, ModBlocks.CHERRY_BARREL);
                }

                // Use non barrel as mock-up
                if (originalBlock.is(Blocks.BARREL)) {
                    yield getWoodBlockVariant(originalBlock, Blocks.CRAFTING_TABLE, Blocks.CHEST, Blocks.TRAPPED_CHEST, ModBlocks.OAK_BARREL);
                }

                // Vanilla Blocks
                yield null;
            }
            // End will be ignored
            default -> null;
        };
    }

    private BlockState getWoodBlockVariant(BlockState state, Block craft, Block chest, Block trapped, Block barrel) {
        if (state.is(Blocks.CRAFTING_TABLE)) {
            return craft.defaultBlockState();
        }
        if (state.is(Blocks.CHEST)) {
            return chest.defaultBlockState();
        }
        if (state.is(Blocks.TRAPPED_CHEST)) {
            return trapped.defaultBlockState();
        }
        if (state.is(Blocks.BARREL)) {
            return barrel.defaultBlockState();
        }
        // Previous check prevents this entirely
        return state;
    }

    private Dimension getDimension(LevelReader levelReader) {
        DimensionType type = levelReader.dimensionType();
        if (type.hasEnderDragonFight()) {
            return Dimension.END;
        } else if (type.hasCeiling()) {
            return Dimension.NETHER;
        } else {
            return Dimension.OVERWORLD;
        }
    }

}
