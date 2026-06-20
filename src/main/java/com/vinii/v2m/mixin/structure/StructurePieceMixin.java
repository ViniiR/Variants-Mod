package com.vinii.v2m.mixin.structure;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.ModConfig;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.world.structure.VariantsStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.structures.DesertPyramidPiece;
import net.minecraft.world.level.levelgen.structure.structures.JungleTemplePiece;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixin {
    @WrapOperation(
        method = "createChest(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/level/block/state/BlockState;)Z",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/Block;defaultBlockState()Lnet/minecraft/world/level/block/state/BlockState;"
        )
    )
    BlockState replaceNonJigsawPieceChest(Block instance, Operation<BlockState> original) {
        if (!ModConfig.getGenerateUtilityVariants()) {
            return original.call(instance);
        }

        return switch ((StructurePiece) (Object) this) {
            case DesertPyramidPiece ignore -> ModBlocks.ACACIA_CHEST.defaultBlockState();
            case JungleTemplePiece ignore -> ModBlocks.JUNGLE_CHEST.defaultBlockState();
            default -> original.call(instance);
        };
    }

    @WrapOperation(
        method = "createChest(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/level/block/state/BlockState;)Z",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/structure/StructurePiece;reorient(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/level/block/state/BlockState;"
        )
    )
    BlockState replaceNetherFortressChest(
        BlockGetter level,
        BlockPos blockPos,
        BlockState blockState,
        Operation<BlockState> original,
        @Local(argsOnly = true, name = "lootTable") ResourceKey<LootTable> lootTable
    ) {
        if (lootTable.isFor(BuiltInLootTables.NETHER_BRIDGE.registryKey())) {
            return original.call(level, blockPos, VariantsStructureProcessor.getReplacedBlock((LevelReader) level, blockPos, blockState));
        }
        return original.call(level, blockPos, blockState);
    }
}
