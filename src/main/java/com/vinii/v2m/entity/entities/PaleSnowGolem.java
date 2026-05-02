package com.vinii.v2m.entity.entities;

import com.vinii.v2m.datagen.loot_table.ModEntityLootTableProvider;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class PaleSnowGolem extends SnowGolem {
    public PaleSnowGolem(EntityType<? extends SnowGolem> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void shear(ServerLevel serverLevel, @NonNull SoundSource soundSource, @NonNull ItemStack itemStack) {
        serverLevel.playSound(null, this, SoundEvents.SNOW_GOLEM_SHEAR, soundSource, 1.0F, 1.0F);
        this.setPumpkin(false);
        this.dropFromShearingLootTable(serverLevel,
            ModEntityLootTableProvider.SHEAR_PALE_SNOW_GOLEM,
            itemStack,
            (serverLevelx, itemStackx) -> this.spawnAtLocation(serverLevelx, itemStackx, this.getEyeHeight())
        );
    }
}
