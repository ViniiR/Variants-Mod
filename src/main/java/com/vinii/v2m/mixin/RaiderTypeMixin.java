package com.vinii.v2m.mixin;

import com.vinii.v2m.entity.ModEntities;
import net.minecraft.world.entity.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.world.entity.raid.Raid$RaiderType")
public abstract class RaiderTypeMixin {
    @Inject(
        method = "<clinit>",
        at = @At("TAIL")
    )
    private static void replaceRaiders(CallbackInfo ci) {
        // PILLAGER is default
        Raid.RaiderType.VINDICATOR.entityType = ModEntities.RAID_VINDICATOR;
        Raid.RaiderType.EVOKER.entityType = ModEntities.RAID_EVOKER;
        Raid.RaiderType.WITCH.entityType = ModEntities.RAID_WITCH;
    }
}
