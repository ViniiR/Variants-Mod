package com.vinii.v2m.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.vinii.v2m.ModConfig;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.network.chat.Component;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen -> YetAnotherConfigLib.createBuilder()
            .title(Component.translatable("config.v2m.title"))
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("config.v2m.main.name"))
                .tooltip(Component.translatable("config.v2m.main.tooltip"))

                .group(OptionGroup.createBuilder()
                    .name(Component.translatable("config.v2m.structures.name"))
                    .description(OptionDescription.of(Component.translatable("config.v2m.structures.desc")))

                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("config.v2m.structures.generate.name"))
                        .description(OptionDescription.of(Component.translatable("config.v2m.structures.generate.desc")))
                        .binding(ModConfig.DEFAULT_TRUE,
                            ModConfig::getGenerateUtilityVariants,
                            ModConfig::setGenerateUtilityVariants
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("config.v2m.structures.generate_frosted.name"))
                        .description(OptionDescription.of(Component.translatable("config.v2m.structures.generate_frosted.desc")))
                        .binding(ModConfig.DEFAULT_TRUE,
                            ModConfig::getGenerateFrostedGlass,
                            ModConfig::setGenerateFrostedGlass
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("config.v2m.structures.pale_mansion.name"))
                        .description(OptionDescription.of(Component.translatable("config.v2m.structures.pale_mansion.desc")))
                        .binding(ModConfig.DEFAULT_FALSE,
                            ModConfig::getGeneratePaleMansion,
                            ModConfig::setGeneratePaleMansion
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("config.v2m.structures.crimson_fortress.name"))
                        .description(OptionDescription.of(Component.translatable("config.v2m.structures.crimson_fortress.desc")))
                        .binding(ModConfig.DEFAULT_FALSE,
                            ModConfig::getGenerateCrimsonFortress,
                            ModConfig::setGenerateCrimsonFortress
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .build())

                .build())
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("config.v2m.compatibility.name"))
                .tooltip(Component.translatable("config.v2m.compatibility.tooltip"))

                .option(Option.<Boolean>createBuilder()
                    .name(Component.translatable("config.v2m.recipe.name"))
                    .description(OptionDescription.of(Component.translatable("config.v2m.recipe.desc")))
                    .binding(ModConfig.DEFAULT_FALSE,
                        ModConfig::getEnableRecipeCompatibility,
                        ModConfig::setEnableRecipeCompatibility
                    )
                    .controller(TickBoxControllerBuilder::create)
                    .build())

                .build())

            .build()
            .generateScreen(parentScreen);

    }
}
