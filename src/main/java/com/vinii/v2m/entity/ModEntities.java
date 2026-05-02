package com.vinii.v2m.entity;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.entity.entities.Icid;
import com.vinii.v2m.entity.entities.PaleSnowGolem;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.level.block.Blocks;

public class ModEntities {
    public static void initialize() {
        FabricDefaultAttributeRegistry.register(ICID, Icid.createAttributes());
        FabricDefaultAttributeRegistry.register(PALE_SNOW_GOLEM, PaleSnowGolem.createAttributes());
    }
    // TODO: add spawn eggs

    public static final EntityType<Icid> ICID = register(
        "icid",
        EntityType.Builder.of(Icid::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .eyeHeight(1.74F)
            .passengerAttachments(2.0125F)
            .ridingOffset(-0.7F)
            .clientTrackingRange(8)
            .notInPeaceful()
    );
    public static final EntityType<PaleSnowGolem> PALE_SNOW_GOLEM = register(
        "pale_snow_golem",
        EntityType.Builder.of(PaleSnowGolem::new, MobCategory.MISC)
            .immuneTo(Blocks.POWDER_SNOW)
            .sized(0.7F, 1.9F)
            .eyeHeight(1.7F)
            .clientTrackingRange(8)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, name));

        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}
