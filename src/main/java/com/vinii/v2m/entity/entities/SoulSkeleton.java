package com.vinii.v2m.entity.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.level.Level;

public class SoulSkeleton extends Skeleton {
    public SoulSkeleton(EntityType<? extends Skeleton> type, Level level) {
        super(type, level);
    }
}
