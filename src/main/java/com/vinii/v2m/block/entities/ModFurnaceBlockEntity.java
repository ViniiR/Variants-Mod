package com.vinii.v2m.block.entities;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.blocks.ModFurnaceBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class ModFurnaceBlockEntity extends FurnaceBlockEntity {
    public ModFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NonNull BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_FURNACE_BLOCK_ENTITY;
    }

    @Override
    public @NonNull Component getName() {
        return Component.translatable("container.v2m." + getFurnaceBlock().variant);
    }

//    @Override
//    protected @NonNull Component getDefaultName() {
//        return getName();
//    }

    @Override
    protected @NonNull AbstractContainerMenu createMenu(int i, @NonNull Inventory inventory) {
        return new FurnaceMenu(i, inventory, this, this.dataAccess);
    }

    public ModFurnaceBlock getFurnaceBlock() {
        if (getBlockState().getBlock() instanceof ModFurnaceBlock) {
            return (ModFurnaceBlock) getBlockState().getBlock();
        } else {
            return null;
        }
    }
}
