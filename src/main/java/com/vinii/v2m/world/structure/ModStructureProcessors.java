package com.vinii.v2m.world.structure;

import com.vinii.v2m.ViniisVariantsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class ModStructureProcessors {
    public static void initialize() {
    }

    public static final StructureProcessorType<VariantsStructureProcessor> VARIANTS_PROCESSOR =
        Registry.register(
            BuiltInRegistries.STRUCTURE_PROCESSOR,
            Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, "variants_processor"),
            () -> VariantsStructureProcessor.CODEC
        );
}
