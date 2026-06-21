package com.vinii.v2m.datagen.tag;

import com.vinii.v2m.entity.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public ModEntityTypeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        valueLookupBuilder(EntityTypeTags.BURN_IN_DAYLIGHT)
            .add(ModEntities.SOUL_SKELETON)
            .add(ModEntities.MUDDY_ZOMBIE)
        ;
    }
}
