package com.vinii.v2m.mixin.structure;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.levelgen.structure.structures.NetherFortressPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(NetherFortressPieces.MonsterThrone.class)
public abstract class NetherFortressPiecesMonsterThroneMixin {
    @WrapOperation(
        method = "postProcess",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/entity/SpawnerBlockEntity;setEntityId(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/util/RandomSource;)V"
        )
    )
    void patchSoulBlazeSpawner(
        SpawnerBlockEntity instance,
        EntityType<?> type,
        RandomSource random,
        Operation<Void> original,
        @Local(name = "pos") BlockPos pos,
        @Local(argsOnly = true, name = "level") final WorldGenLevel level
    ) {
        original.call(instance,
            level.getBiome(pos).is(Biomes.SOUL_SAND_VALLEY) ? ModEntities.SOUL_BLAZE : type,
            random);
    }
}
