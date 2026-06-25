package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.vinii.v2m.datagen.tag.ModBiomeTagProvider;
import com.vinii.v2m.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.biome.Biomes;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(NaturalSpawner.class)
public abstract class NaturalSpawnerMixin {
    @WrapOperation(
        method = "spawnCategoryForPosition(Lnet/minecraft/world/entity/MobCategory;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/chunk/ChunkAccess;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/NaturalSpawner$SpawnPredicate;Lnet/minecraft/world/level/NaturalSpawner$AfterSpawnCallback;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/NaturalSpawner;getMobForSpawn(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/EntityType;)Lnet/minecraft/world/entity/Mob;"
        )
    )
    private static @Nullable Mob replaceMobWithVariant(
        ServerLevel level,
        EntityType<?> type,
        Operation<Mob> original,
        @Local(argsOnly = true, name = "start") BlockPos start
    ) {
        var biome = level.getBiome(start);

        return switch (type) {
            case EntityType<?> e when e == EntityType.ZOMBIE && biome.is(ModBiomeTagProvider.SNOWY_BIOMES) ->
                original.call(level, ModEntities.ICID);
            case EntityType<?> e when e == EntityType.SKELETON && biome.is(Biomes.SOUL_SAND_VALLEY) ->
                original.call(level, ModEntities.SOUL_SKELETON);
            case EntityType<?> e when e == EntityType.BLAZE && biome.is(Biomes.SOUL_SAND_VALLEY) ->
                original.call(level, ModEntities.SOUL_BLAZE);
            case EntityType<?> e when e == EntityType.ENDERMAN && biome.is(Biomes.WARPED_FOREST) ->
                original.call(level, ModEntities.WARPED_ENDERMAN);
            case EntityType<?> e when e == EntityType.GUARDIAN && biome.is(ModBiomeTagProvider.COLD_OCEAN_BIOMES) ->
                original.call(level, ModEntities.FROZEN_GUARDIAN);
            case EntityType<?> e when e == EntityType.ZOMBIE && biome.is(BiomeTags.HAS_RUINED_PORTAL_SWAMP) ->
                original.call(level, ModEntities.MUDDY_ZOMBIE);
            case EntityType<?> e when e == EntityType.PILLAGER && biome.is(ModBiomeTagProvider.SNOWY_BIOMES) ->
                original.call(level, ModEntities.MOUNTAINEER_PILLAGER);
            default -> original.call(level, type);
        };
    }
}