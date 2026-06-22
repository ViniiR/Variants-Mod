package com.vinii.v2m.datagen.loot_table;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableSubProvider {
    public ModEntityLootTableProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.ENTITY_INTERACT);
    }

    public static final ResourceKey<LootTable> SHEAR_PALE_SNOW_GOLEM = register("shearing/pale_snow_golem");
    public static final ResourceKey<LootTable> ICID = register("entities/icid");
    public static final ResourceKey<LootTable> MUDDY_ZOMBIE = register("entities/muddy_zombie");
    public static final ResourceKey<LootTable> SOUL_SKELETON = register("entities/soul_skeleton");
    public static final ResourceKey<LootTable> SOUL_BLAZE = register("entities/soul_blaze");
    public static final ResourceKey<LootTable> WARPED_ENDERMAN = register("entities/warped_enderman");
    public static final ResourceKey<LootTable> FROZEN_GUARDIAN = register("entities/frozen_guardian");

    // Vanilla
    private static final ResourceKey<LootTable> ZOMBIE = ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/zombie"));
    private static final ResourceKey<LootTable> SKELETON = ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/skeleton"));
    private static final ResourceKey<LootTable> BLAZE = ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/blaze"));
    private static final ResourceKey<LootTable> ENDERMAN = ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/enderman"));
    private static final ResourceKey<LootTable> GUARDIAN = ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace("entities/guardian"));

    @Override
    public void generate(@NonNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
            SHEAR_PALE_SNOW_GOLEM,
            LootTable.lootTable().withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(ModBlocks.CARVED_PALE_PUMPKIN))
                )
                .setRandomSequence(SHEAR_PALE_SNOW_GOLEM.identifier())
        );
        inheritLootTable(biConsumer, ZOMBIE, ICID);
        inheritLootTable(biConsumer, ZOMBIE, MUDDY_ZOMBIE);
        inheritLootTable(biConsumer, SKELETON, SOUL_SKELETON);
        inheritLootTable(biConsumer, BLAZE, SOUL_BLAZE);
        inheritLootTable(biConsumer, ENDERMAN, WARPED_ENDERMAN);
        inheritLootTable(biConsumer, GUARDIAN, FROZEN_GUARDIAN);
    }

    private static void inheritLootTable(
        BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer,
        ResourceKey<LootTable> sub,
        ResourceKey<LootTable> over
    ) {
        biConsumer.accept(
            over,
            LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(NestedLootTable.lootTableReference(sub))
            )
        );
    }

    private static ResourceKey<LootTable> register(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, path));
    }
}
