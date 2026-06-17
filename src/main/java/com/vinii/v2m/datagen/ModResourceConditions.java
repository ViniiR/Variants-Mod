package com.vinii.v2m.datagen;

import com.mojang.serialization.MapCodec;
import com.vinii.v2m.ModConfig;
import com.vinii.v2m.ViniisVariantsMod;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public final class ModResourceConditions {
    public static void initialize() {
        ResourceConditions.register(ENABLE_RECIPE_COMPATIBILITY);
    }

    public static final ResourceConditionType<EnableRecipeCompatibility> ENABLE_RECIPE_COMPATIBILITY =
        createResourceConditionType("enable_recipe_compatibility", EnableRecipeCompatibility.CODEC);

    private static <T extends ResourceCondition> ResourceConditionType<T> createResourceConditionType(String name, MapCodec<T> codec) {
        return ResourceConditionType.create(Identifier.fromNamespaceAndPath(ViniisVariantsMod.MOD_ID, name), codec);
    }

    public record EnableRecipeCompatibility() implements ResourceCondition {
        public static final MapCodec<EnableRecipeCompatibility> CODEC = MapCodec.unit(EnableRecipeCompatibility::new);

        @Override
        public @NonNull ResourceConditionType<?> getType() {
            return ENABLE_RECIPE_COMPATIBILITY;
        }

        @Override
        public boolean test(RegistryOps.@Nullable RegistryInfoLookup registryInfoLookup) {
            return ModConfig.getEnableRecipeCompatibility();
        }
    }
}
