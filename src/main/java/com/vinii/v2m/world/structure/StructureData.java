package com.vinii.v2m.world.structure;

import org.jspecify.annotations.Nullable;

import java.util.Optional;

public final class StructureData {
    private static StructureData INSTANCE;
    private String structureId;

    public static StructureData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StructureData();
        }
        return INSTANCE;
    }

    // IMPORTANT NOTE: getStructureId() will never work with "/place structure" command
    // But it works on natural generation
    public Optional<String> getStructureId() {
        return structureId != null ? Optional.of(structureId) : Optional.empty();
    }

    public void setStructureId(@Nullable String id) {
        structureId = id;
    }
}
