package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.block.blocks.ModCraftingTableBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CraftingMenu.class)
public abstract class CraftingMenuMixin {
    @WrapOperation(
        method = "stillValid",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/inventory/CraftingMenu;stillValid(Lnet/minecraft/world/inventory/ContainerLevelAccess;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/block/Block;)Z"
        )
    )
    boolean patchModCraftingTableMenu(ContainerLevelAccess containerLevelAccess, Player player, Block block, Operation<Boolean> original) {
        return original.call(containerLevelAccess, player, block) ||
            containerLevelAccess.evaluate(
                (level, pos) -> {
                    BlockState state = level.getBlockState(pos);
                    // Check if position has Mod table
                    return state.getBlock() instanceof ModCraftingTableBlock &&
                        // Check if the original block is a vanilla table
                        block instanceof CraftingTableBlock &&
                        player.isWithinBlockInteractionRange(pos, 4.0);
                },
                true // FIXME: should this be false?
            );
    }
}
