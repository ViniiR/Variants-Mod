package com.vinii.v2m.mixin.structure;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.ModConfig;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.world.structure.StructureData;
import com.vinii.v2m.world.structure.VariantsStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.structures.DesertPyramidPiece;
import net.minecraft.world.level.levelgen.structure.structures.JungleTemplePiece;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Map;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixin {
    @Shadow
    protected BoundingBox boundingBox;

    @Unique
    private static final Map<Block, Block> NETHER_BRICK_BLOCK_CONVERSION = Map.ofEntries(
        Map.entry(Blocks.NETHER_BRICKS, Blocks.RED_NETHER_BRICKS),
        Map.entry(Blocks.NETHER_BRICK_SLAB, Blocks.RED_NETHER_BRICK_SLAB),
        Map.entry(Blocks.NETHER_BRICK_STAIRS, Blocks.RED_NETHER_BRICK_STAIRS),
        Map.entry(Blocks.NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICK_WALL)
    );

    @ModifyVariable(
        method = "placeBlock",
        at = @At(
            value = "STORE",
            target = "Lnet/minecraft/world/level/levelgen/structure/StructurePiece;getWorldPos(III)Lnet/minecraft/core/BlockPos$MutableBlockPos;"
        ),
        argsOnly = true,
        name = "blockState"
    )
    BlockState createNetherFortressVariant(
        BlockState blockState,
        @Local(argsOnly = true, name = "level") WorldGenLevel level,
        @Local(name = "pos") BlockPos pos
    ) {
        if (!ModConfig.getGenerateCrimsonFortress()){
            return blockState;
        }

        // TODO: hmm unreliable
        String structureId = StructureData.getInstance().getStructureId().orElse("");

        Holder<Biome> biome = level.getBiome(boundingBox.getCenter());

        if (!biome.is(Biomes.CRIMSON_FOREST)) {
            return blockState;
        }

        Block replacementBlock = NETHER_BRICK_BLOCK_CONVERSION.get(blockState.getBlock());
        return replacementBlock != null ? replacementBlock.defaultBlockState() : blockState;
    }

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
        if (ModConfig.getGenerateUtilityVariants() && lootTable.isFor(BuiltInLootTables.NETHER_BRIDGE.registryKey())) {
            return original.call(level, blockPos, VariantsStructureProcessor.getReplacedBlock((LevelReader) level, blockPos, blockState));
        }
        return original.call(level, blockPos, blockState);
    }
}
