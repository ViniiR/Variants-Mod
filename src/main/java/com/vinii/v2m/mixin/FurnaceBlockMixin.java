package com.vinii.v2m.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.vinii.v2m.datagen.tag.ModBlockTagProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FurnaceBlock.class)
public abstract class FurnaceBlockMixin extends AbstractFurnaceBlock {
    protected FurnaceBlockMixin(Properties properties) {
        super(properties);
    }

    @WrapOperation(
        method = "animateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"
        )
    )
    private void replaceFlameParticles(Level instance, ParticleOptions particle, double x, double y, double z, double xd, double yd, double zd, Operation<Void> original) {
        if (particle.getType() == ParticleTypes.FLAME && this.asBlock().defaultBlockState().is(ModBlockTagProvider.MOD_NETHER_FURNACES)) {
            original.call(instance, ParticleTypes.SOUL_FIRE_FLAME, x, y, z, xd, yd, zd);
            return;
        }

        original.call(instance, particle, x, y, z, xd, yd, zd);
    }
}
