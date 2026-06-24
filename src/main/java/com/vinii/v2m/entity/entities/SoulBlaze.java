package com.vinii.v2m.entity.entities;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.level.Level;

public class SoulBlaze extends Blaze {
    public SoulBlaze(EntityType<? extends Blaze> blaze, Level level) {
        super(blaze, level);
        this.type.lootTable = ModEntities.copyLootTableFrom("blaze");
    }
}
