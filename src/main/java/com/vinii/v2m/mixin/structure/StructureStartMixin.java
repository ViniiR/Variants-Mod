package com.vinii.v2m.mixin.structure;

import com.vinii.v2m.world.structure.StructureData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructureStart.class)
public abstract class StructureStartMixin {
    @Inject(
        method = "loadStaticStart",
        at = @At("HEAD")
    )
    private static void storeStructureId(
        StructurePieceSerializationContext context,
        CompoundTag tag,
        long seed,
        CallbackInfoReturnable<StructureStart> cir
    ) {
        Tag id = tag.get("id");

        if (id != null) {
            StructureData.getInstance().setStructureId(id.toString());
        }
    }

    // I'm really hoping the structure processor has already finished at this point
    @Inject(
        method = "loadStaticStart",
        at = @At("RETURN")
    )
    private static void clearStructureId(
        StructurePieceSerializationContext context,
        CompoundTag tag,
        long seed,
        CallbackInfoReturnable<StructureStart> cir
    ) {
        StructureData.getInstance().setStructureId(null);
    }
}
