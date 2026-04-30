package com.vinii.v2m;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.mixin.accessor.PoiTypesAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PointsOfInterest {
    public static void registerFishermanBarrels() {
        Map<BlockState, Holder<PoiType>> poiStatesToType = PoiTypesAccessor.getTypeByState();

        Holder<PoiType> fishermanEntry = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.FISHERMAN).get();

        PoiType fishermanPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getValue(PoiTypes.FISHERMAN);

        List<BlockState> fishermanBlockStates = new ArrayList<>(fishermanPoiType.matchingStates);

        List<Block> barrels = List.of(
            ModBlocks.OAK_BARREL,
            ModBlocks.BIRCH_BARREL,
            ModBlocks.DARK_OAK_BARREL,
            ModBlocks.PALE_OAK_BARREL,
            ModBlocks.ACACIA_BARREL,
            ModBlocks.JUNGLE_BARREL,
            ModBlocks.MANGROVE_BARREL,
            ModBlocks.CHERRY_BARREL,
            ModBlocks.BAMBOO_BARREL,
            ModBlocks.CRIMSON_BARREL,
            ModBlocks.WARPED_BARREL
        );

        for (Block block : barrels) {
            ImmutableList<BlockState> blockStates = block.getStateDefinition().getPossibleStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, fishermanEntry);
            }

            fishermanBlockStates.addAll(blockStates);
        }

        fishermanPoiType.matchingStates = ImmutableSet.copyOf(fishermanBlockStates);
    }
}
