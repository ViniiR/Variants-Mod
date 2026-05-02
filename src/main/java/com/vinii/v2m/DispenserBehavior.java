package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.EquipmentDispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jspecify.annotations.NonNull;

public class DispenserBehavior {
    public static void initialize() {
        DispenserBlock.registerBehavior(ModBlocks.CARVED_PALE_PUMPKIN, HANDLE_DISPENSE_PUMPKIN);
        DispenserBlock.registerBehavior(ModBlocks.PALE_JACK_O_LANTERN, HANDLE_DISPENSE_PUMPKIN);
    }

    private static final DispenseItemBehavior HANDLE_DISPENSE_PUMPKIN = new OptionalDispenseItemBehavior() {
        protected @NonNull ItemStack execute(@NonNull BlockSource blockSource, @NonNull ItemStack itemStack) {
            Level level = blockSource.level();

            BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
            CarvedPumpkinBlock carvedPumpkinBlock = (CarvedPumpkinBlock) ModBlocks.CARVED_PALE_PUMPKIN;

            if (level.isEmptyBlock(blockPos) && carvedPumpkinBlock.canSpawnGolem(level, blockPos)) {
                if (!level.isClientSide()) {
                    level.setBlock(blockPos, carvedPumpkinBlock.defaultBlockState(), 3);
                    level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                }

                itemStack.shrink(1);
                this.setSuccess(true);
            } else {
                this.setSuccess(EquipmentDispenseItemBehavior.dispenseEquipment(blockSource, itemStack));
            }

            return itemStack;
        }
    };
}
