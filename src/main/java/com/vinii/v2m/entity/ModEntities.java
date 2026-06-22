package com.vinii.v2m.entity;

import com.vinii.v2m.ViniisVariantsMod;
import com.vinii.v2m.entity.entities.*;
import com.vinii.v2m.entity.entities.illagers.RaidEvoker;
import com.vinii.v2m.entity.entities.illagers.RaidVindicator;
import com.vinii.v2m.entity.entities.illagers.RaidWitch;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;

// EntityType
public class ModEntities {
    public static void initialize() {
        FabricDefaultAttributeRegistry.register(ICID, Icid.createAttributes());
        FabricDefaultAttributeRegistry.register(MUDDY_ZOMBIE, MuddyZombie.createAttributes());
        FabricDefaultAttributeRegistry.register(SOUL_SKELETON, SoulSkeleton.createAttributes());
        FabricDefaultAttributeRegistry.register(PALE_SNOW_GOLEM, PaleSnowGolem.createAttributes());
        FabricDefaultAttributeRegistry.register(WARPED_ENDERMAN, WarpedEnderman.createAttributes());
        FabricDefaultAttributeRegistry.register(SOUL_BLAZE, SoulBlaze.createAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_GUARDIAN, FrozenGuardian.createAttributes());
        FabricDefaultAttributeRegistry.register(RAID_VINDICATOR, RaidVindicator.createAttributes());
        FabricDefaultAttributeRegistry.register(RAID_WITCH, RaidWitch.createAttributes());
        FabricDefaultAttributeRegistry.register(RAID_EVOKER, RaidEvoker.createAttributes());
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

    public static final EntityType<MuddyZombie> MUDDY_ZOMBIE = register(
        "muddy_zombie",
        EntityType.Builder.of(MuddyZombie::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F)
            .eyeHeight(1.74F)
            .passengerAttachments(2.0125F)
            .ridingOffset(-0.7F)
            .clientTrackingRange(8)
            .notInPeaceful()
    );

    public static final EntityType<SoulSkeleton> SOUL_SKELETON = register(
        "soul_skeleton",
        EntityType.Builder.of(SoulSkeleton::new, MobCategory.MONSTER)
            .sized(0.6F, 1.99F)
            .eyeHeight(1.74F)
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

    public static final EntityType<WarpedEnderman> WARPED_ENDERMAN = register(
        "warped_enderman",
        EntityType.Builder.of(WarpedEnderman::new, MobCategory.MONSTER)
            .sized(0.6F, 2.9F)
            .eyeHeight(2.55F)
            .passengerAttachments(2.80625F)
            .clientTrackingRange(8)
            .notInPeaceful()
    );

    public static final EntityType<SoulBlaze> SOUL_BLAZE = register(
        "soul_blaze",
        EntityType.Builder.of(SoulBlaze::new, MobCategory.MONSTER)
            .fireImmune()
            .sized(0.6F, 1.8F)
            .clientTrackingRange(8)
            .notInPeaceful()
    );

    public static final EntityType<FrozenGuardian> FROZEN_GUARDIAN = register(
        "frozen_guardian",
        EntityType.Builder.of(FrozenGuardian::new, MobCategory.MONSTER)
            .sized(0.85F, 0.85F)
            .eyeHeight(0.425F)
            .passengerAttachments(0.975F)
            .clientTrackingRange(8)
            .notInPeaceful()
    );

    public static final EntityType<RaidVindicator> RAID_VINDICATOR = register("raid_vindicator", EntityType.Builder.of(RaidVindicator::new, MobCategory.MONSTER).sized(0.6F, 1.95F).passengerAttachments(2.0F).ridingOffset(-0.6F).clientTrackingRange(8).notInPeaceful());
    public static final EntityType<RaidWitch> RAID_WITCH = register("raid_witch", EntityType.Builder.of(RaidWitch::new, MobCategory.MONSTER).sized(0.6F, 1.95F).eyeHeight(1.62F).passengerAttachments(2.2625F).clientTrackingRange(8).notInPeaceful());
    public static final EntityType<RaidEvoker> RAID_EVOKER = register("raid_evoker", EntityType.Builder.of(RaidEvoker::new, MobCategory.MONSTER).sized(0.6F, 1.95F).passengerAttachments(2.0F).ridingOffset(-0.6F).clientTrackingRange(8).notInPeaceful());

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, name));

        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}
