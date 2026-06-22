package com.vinii.v2m.entity.entities.illagers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.level.Level;

public class RaidWitch extends Witch {
    public RaidWitch(EntityType<? extends Witch> type, Level level) {
        super(type, level);
    }
}
