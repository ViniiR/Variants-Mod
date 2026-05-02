package com.vinii.v2m;

import com.vinii.v2m.block.ModBlockEntities;
import com.vinii.v2m.block.ModBlocks;
import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.EquipmentDispenseItemBehavior;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.DispenserBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViniisVariantsMod implements ModInitializer {
    public static final String MOD_ID = "v2m";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        ModBlockEntities.initialize();

        ModEntities.initialize();

        PointsOfInterest.registerFishermanBarrels();

        ModBiomeModifications.initialize();

        DispenserBlock.registerBehavior(ModBlocks.CARVED_PALE_PUMPKIN, new EquipmentDispenseItemBehavior());
    }
}