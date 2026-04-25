package com.vinii.v2m.entity.entities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class Icid extends Zombie {
    public Icid(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }

    protected void doUnderWaterConversion(@NonNull ServerLevel serverLevel) {
        this.convertToZombieType(serverLevel, EntityType.ZOMBIE);
        if (!this.isSilent()) {
            serverLevel.levelEvent(null, 1041, this.blockPosition(), 0);
        }
    }
}
