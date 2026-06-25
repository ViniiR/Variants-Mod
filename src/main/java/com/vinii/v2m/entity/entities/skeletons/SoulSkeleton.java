package com.vinii.v2m.entity.entities.skeletons;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.level.Level;

public class SoulSkeleton extends Skeleton {
    public SoulSkeleton(EntityType<? extends Skeleton> type, Level level) {
        super(type, level);
        this.type.lootTable = ModEntities.copyLootTableFrom("skeleton");
    }
}
