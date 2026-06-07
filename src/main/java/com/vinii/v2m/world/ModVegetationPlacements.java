package com.vinii.v2m.world;

import com.vinii.v2m.ViniisVariantsMod;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class ModVegetationPlacements {

    private static final String namespace = ViniisVariantsMod.MOD_ID;

    public static final ResourceKey<PlacedFeature> PATCH_PALE_PUMPKIN =
        ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(namespace, "patch_pale_pumpkin"));

    public static void bootstrap(BootstrapContext<PlacedFeature> bootstrapContext) {
        HolderGetter<ConfiguredFeature<?, ?>> holder = bootstrapContext.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> patchPalePumpkinHolder = holder.getOrThrow(ModVegetationFeatures.PATCH_PALE_PUMPKIN);

        PlacementUtils.register(bootstrapContext,
            PATCH_PALE_PUMPKIN,
            patchPalePumpkinHolder,
            RarityFilter.onAverageOnceEvery(10),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP,
            BiomeFilter.biome(),
            CountPlacement.of(96),
            RandomOffsetPlacement.ofTriangle(7, 3),
            BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE,
                BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), Blocks.GRASS_BLOCK)))
        );
    }
}
