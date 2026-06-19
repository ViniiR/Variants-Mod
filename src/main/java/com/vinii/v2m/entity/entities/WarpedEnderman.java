package com.vinii.v2m.entity.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;

public class WarpedEnderman extends EnderMan {
    public WarpedEnderman(EntityType<? extends EnderMan> type, Level level) {
        super(type, level);
    }
}
