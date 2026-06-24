package com.vinii.v2m.entity.entities;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.level.Level;

public class FrozenGuardian extends Guardian {
    public FrozenGuardian(EntityType<? extends Guardian> type, Level level) {
        super(type, level);
        this.type.lootTable = ModEntities.copyLootTableFrom("guardian");
    }
}
