package com.vinii.v2m.entity.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;

public class MuddyZombie extends Zombie {
    public MuddyZombie(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    protected boolean isSunSensitive() {
        return true;
    }
}
