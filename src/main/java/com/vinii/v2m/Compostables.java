package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.world.level.block.ComposterBlock;

public class Compostables {
    public static void initialize() {
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PALE_PUMPKIN, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.CARVED_PALE_PUMPKIN, 0.65f);
    }

}
