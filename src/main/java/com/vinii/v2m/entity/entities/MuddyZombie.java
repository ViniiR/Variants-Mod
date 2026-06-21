package com.vinii.v2m.entity.entities;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class MuddyZombie extends Zombie {
    public MuddyZombie(EntityType<? extends Zombie> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(final @NonNull ServerLevel level, final @NonNull Entity target) {
        boolean result = super.doHurtTarget(level, target);
        if (result && this.getMainHandItem().isEmpty() && target instanceof LivingEntity) {
            float difficulty = level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.POISON, 140 * (int)difficulty), this);
        }

        return result;
    }
}
