package com.vinii.v2m.world;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModVegetationFeatures {

    private static final String namespace = ViniisVariantsMod.MOD_ID;

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PALE_PUMPKIN = ResourceKey.create(Registries.CONFIGURED_FEATURE,
        Identifier.fromNamespaceAndPath(namespace, "patch_pale_pumpkin"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> bootstrapContext) {
        HolderGetter<PlacedFeature> placedFeature = bootstrapContext.lookup(Registries.PLACED_FEATURE);

        FeatureUtils.register(bootstrapContext,
            PATCH_PALE_PUMPKIN,
            Feature.RANDOM_PATCH,
            FeatureUtils.simplePatchConfiguration(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PALE_PUMPKIN)),
                List.of(
                    Blocks.GRASS_BLOCK,
                    Blocks.PALE_MOSS_BLOCK
                ))
        );

//        FeatureUtils.register(
//            bootstrapContext,
//            PATCH_PALE_PUMPKIN,
//            Feature.BLOCK_PILE,
//            new BlockPileConfiguration(new WeightedStateProvider(WeightedList.<BlockState>builder()
//                .add(ModBlocks.PALE_PUMPKIN.defaultBlockState(), 20)
////                .add(ModBlocks.PALE_PUMPKIN.defaultBlockState().setValue(CarvedPalePumpkinBlock.FACING, Direction.NORTH), 1)
////                .add(ModBlocks.PALE_PUMPKIN.defaultBlockState().setValue(CarvedPalePumpkinBlock.FACING, Direction.SOUTH), 1)
////                .add(ModBlocks.PALE_PUMPKIN.defaultBlockState().setValue(CarvedPalePumpkinBlock.FACING, Direction.EAST), 1)
////                .add(ModBlocks.PALE_PUMPKIN.defaultBlockState().setValue(CarvedPalePumpkinBlock.FACING, Direction.WEST), 1)
//            ))
//        );
    }
}
