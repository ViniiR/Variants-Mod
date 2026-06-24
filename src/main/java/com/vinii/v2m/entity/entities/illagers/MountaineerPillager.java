package com.vinii.v2m.entity.entities.illagers;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.level.Level;

public class MountaineerPillager extends Pillager {
    public MountaineerPillager(EntityType<? extends Pillager> type, Level level) {
        super(type, level);
        this.type.lootTable = ModEntities.copyLootTableFrom("pillager");
    }
}
