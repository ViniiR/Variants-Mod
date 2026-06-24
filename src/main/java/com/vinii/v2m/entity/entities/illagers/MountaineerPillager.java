package com.vinii.v2m.entity.entities.illagers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.level.Level;

public class MountaineerPillager extends Pillager {
    public MountaineerPillager(EntityType<? extends Pillager> type, Level level) {
        super(type, level);
    }
}
