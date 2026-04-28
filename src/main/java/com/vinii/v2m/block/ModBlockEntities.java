package com.vinii.v2m.block;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.block.entities.ModBarrelBlockEntity;
import com.vinii.v2m.block.entities.ModChestBlockEntity;
import com.vinii.v2m.block.entities.ModFurnaceBlockEntity;
import com.vinii.v2m.block.entities.ModTrappedChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static void initialize() {
    }

    public static final BlockEntityType<ModChestBlockEntity> MOD_CHEST_BLOCK_ENTITY = register(
        "chest",
        ModChestBlockEntity::new,
        ModBlocks.SPRUCE_CHEST,
        ModBlocks.BIRCH_CHEST,
        ModBlocks.DARK_OAK_CHEST,
        ModBlocks.PALE_OAK_CHEST,
        ModBlocks.JUNGLE_CHEST,
        ModBlocks.MANGROVE_CHEST,
        ModBlocks.CHERRY_CHEST,
        ModBlocks.ACACIA_CHEST,
        ModBlocks.BAMBOO_CHEST,
        ModBlocks.WARPED_CHEST,
        ModBlocks.CRIMSON_CHEST
    );

    public static final BlockEntityType<ModTrappedChestBlockEntity> MOD_TRAPPED_CHEST_BLOCK_ENTITY = register(
        "trapped_chest",
        ModTrappedChestBlockEntity::new,
        ModBlocks.TRAPPED_SPRUCE_CHEST,
        ModBlocks.TRAPPED_BIRCH_CHEST,
        ModBlocks.TRAPPED_DARK_OAK_CHEST,
        ModBlocks.TRAPPED_PALE_OAK_CHEST,
        ModBlocks.TRAPPED_JUNGLE_CHEST,
        ModBlocks.TRAPPED_MANGROVE_CHEST,
        ModBlocks.TRAPPED_CHERRY_CHEST,
        ModBlocks.TRAPPED_ACACIA_CHEST,
        ModBlocks.TRAPPED_BAMBOO_CHEST,
        ModBlocks.TRAPPED_WARPED_CHEST,
        ModBlocks.TRAPPED_CRIMSON_CHEST
    );

    public static final BlockEntityType<ModBarrelBlockEntity> MOD_BARREL_BLOCK_ENTITY = register(
        "barrel",
        ModBarrelBlockEntity::new,
        ModBlocks.OAK_BARREL,
        ModBlocks.BIRCH_BARREL,
        ModBlocks.DARK_OAK_BARREL,
        ModBlocks.PALE_OAK_BARREL,
        ModBlocks.JUNGLE_BARREL,
        ModBlocks.MANGROVE_BARREL,
        ModBlocks.CHERRY_BARREL,
        ModBlocks.ACACIA_BARREL,
        ModBlocks.BAMBOO_BARREL,
        ModBlocks.WARPED_BARREL,
        ModBlocks.CRIMSON_BARREL
    );

    public static final BlockEntityType<ModFurnaceBlockEntity> MOD_FURNACE_BLOCK_ENTITY = register(
        "furnace",
        ModFurnaceBlockEntity::new,
        ModBlocks.DEEPSLATE_FURNACE,
        ModBlocks.BLACKSTONE_FURNACE
    );

    public static <T extends BlockEntity> BlockEntityType<T> register(
        String name,
        FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
        Block... blocks
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}
