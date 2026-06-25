package com.vinii.v2m.entity.entities.zombies;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class Icid extends Zombie {
    public Icid(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
        this.type.lootTable = ModEntities.copyLootTableFrom("zombie");
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }

    @Override
    public boolean doHurtTarget(final @NonNull ServerLevel level, final @NonNull Entity target) {
        boolean result = super.doHurtTarget(level, target);
        if (result && this.getMainHandItem().isEmpty() && target instanceof LivingEntity) {
            float difficulty = level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 140 * (int) difficulty), this);
        }

        return result;
    }

    protected void doUnderWaterConversion(@NonNull ServerLevel serverLevel) {
        this.convertToZombieType(serverLevel, EntityType.ZOMBIE);
        if (!this.isSilent()) {
            serverLevel.levelEvent(null, 1041, this.blockPosition(), 0);
        }
    }
}
