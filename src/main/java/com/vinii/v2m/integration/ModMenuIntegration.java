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
                        .binding(ModConfig.generateUtilityVariants,
                            () -> ModConfig.generateUtilityVariants,
                            newVal -> ModConfig.generateUtilityVariants = newVal
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("config.v2m.structures.generate_frosted.name"))
                        .description(OptionDescription.of(Component.translatable("config.v2m.structures.generate_frosted.desc")))
                        .binding(ModConfig.generateFrostedGlass,
                            () -> ModConfig.generateFrostedGlass,
                            newVal -> ModConfig.generateFrostedGlass = newVal
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("config.v2m.structures.pale_mansion.name"))
                        .description(OptionDescription.of(Component.translatable("config.v2m.structures.pale_mansion.desc")))
                        .binding(ModConfig.generatePaleMansion,
                            () -> ModConfig.generatePaleMansion,
                            newVal -> ModConfig.generatePaleMansion = newVal
                        )
                        .controller(TickBoxControllerBuilder::create)
                        .build())

                    .build())

//                .group(OptionGroup.createBuilder()
//                    .name(Component.translatable("config.v2m.entities.name"))
//                    .description(OptionDescription.of(Component.translatable("config.v2m.entities.desc")))
//
//                    .build())

                .build())
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("config.v2m.compatibility.name"))
                .tooltip(Component.translatable("config.v2m.compatibility.tooltip"))

//                .group(OptionGroup.createBuilder()
//
//                    .build())

                .build())
            .build()
            .generateScreen(parentScreen);

    }

//    private <T> Option<T> createOption(String name, String desc) {
//        return Option.<T>createBuilder()
//            .name(Component.translatable(name))
//            .description(OptionDescription.of(Component.translatable(desc)))
//            .binding(ModConfig.generateUtilityVariants,
//                () -> ModConfig.generateUtilityVariants,
//                newVal -> ModConfig.generateUtilityVariants = newVal
//            )
//            .controller(TickBoxControllerBuilder::create)
//            .build();
//    }
}
