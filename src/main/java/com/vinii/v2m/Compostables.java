package com.vinii.v2m;

import com.vinii.v2m.block.ModBlocks;
import net.fabricmc.fabric.api.registry.CompostableRegistry;

public class Compostables {
    public static void initialize() {
        CompostableRegistry.INSTANCE.add(ModBlocks.PALE_PUMPKIN, 0.65f);
        CompostableRegistry.INSTANCE.add(ModBlocks.CARVED_PALE_PUMPKIN, 0.65f);
    }

}
