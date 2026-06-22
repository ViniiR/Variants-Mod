package com.vinii.v2m.entity.entities.illagers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.illager.Evoker;
import net.minecraft.world.level.Level;

public class RaidEvoker extends Evoker {
    public RaidEvoker(EntityType<? extends Evoker> type, Level level) {
        super(type, level);
    }
}
