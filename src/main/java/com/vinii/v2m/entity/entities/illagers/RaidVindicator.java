package com.vinii.v2m.entity.entities.illagers;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.level.Level;

public class RaidVindicator extends Vindicator {
    public RaidVindicator(EntityType<? extends Vindicator> type, Level level) {
        super(type, level);
        this.type.lootTable = ModEntities.copyLootTableFrom("vindicator");
    }
}
