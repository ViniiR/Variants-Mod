package com.vinii.v2m.world.structure;

import net.minecraft.core.BlockPos;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public final class StructureData {
    private static StructureData INSTANCE;

    // IMPORTANT NOTE: getters will never work with "/place structure" command
    // But it works on natural generation
    private String structureId;

    public static StructureData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StructureData();
        }
        return INSTANCE;
    }

    public Optional<String> getStructureId() {
        return structureId != null ? Optional.of(structureId) : Optional.empty();
    }

    public void setStructureId(@Nullable String id) {
        structureId = id;
    }
}
