package com.vinii.v2m.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class PortugueseBRLangProvider extends TranslationProvider {
    public PortugueseBRLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "pt_br", registryLookup);

        // Vanilla override
        OAK_CRAFTING_TABLE = "Mesa de Trabalho de Carvalho";

        SPRUCE_CRAFTING_TABLE = "Mesa de Trabalho de Abeto";
        BIRCH_CRAFTING_TABLE = "Mesa de Trabalho de Bétula";
        DARK_OAK_CRAFTING_TABLE = "Mesa de Trabalho de Carvalho Escuro";
        PALE_OAK_CRAFTING_TABLE = "Mesa de Trabalho de Carvalho Pálido";
        ACACIA_CRAFTING_TABLE = "Mesa de Trabalho de Acácia";
        JUNGLE_CRAFTING_TABLE = "Mesa de Trabalho da Selva";
        MANGROVE_CRAFTING_TABLE = "Mesa de Trabalho de Mangue";
        CHERRY_CRAFTING_TABLE = "Mesa de Trabalho de Cerejeira";
        BAMBOO_CRAFTING_TABLE = "Mesa de Trabalho de Bambu";
        CRIMSON_CRAFTING_TABLE = "Mesa de Trabalho Carmesim";
        WARPED_CRAFTING_TABLE = "Mesa de Trabalho Distorcida";

        // Vanilla override
        OAK_CHEST = "Baú de Carvalho";

        SPRUCE_CHEST = "Baú de Abeto";
        BIRCH_CHEST = "Baú de Bétula";
        DARK_OAK_CHEST = "Baú de Carvalho Escuro";
        PALE_OAK_CHEST = "Baú de Carvalho Pálido";
        ACACIA_CHEST = "Baú de Acácia";
        JUNGLE_CHEST = "Baú da Selva";
        MANGROVE_CHEST = "Baú de Mangue";
        CHERRY_CHEST = "Baú de Cerejeira";
        BAMBOO_CHEST = "Baú de Bambu";
        CRIMSON_CHEST = "Baú Carmesim";
        WARPED_CHEST = "Baú Distorcida";

        // Vanilla override
        TRAPPED_OAK_CHEST = OAK_CHEST + " com Armadilha";

        TRAPPED_SPRUCE_CHEST = SPRUCE_CHEST + " com Armadilha";
        TRAPPED_BIRCH_CHEST = BIRCH_CHEST + " com Armadilha";
        TRAPPED_DARK_OAK_CHEST = DARK_OAK_CHEST + " com Armadilha";
        TRAPPED_PALE_OAK_CHEST = PALE_OAK_CHEST + " com Armadilha";
        TRAPPED_ACACIA_CHEST = ACACIA_CHEST + " com Armadilha";
        TRAPPED_JUNGLE_CHEST = JUNGLE_CHEST + " com Armadilha";
        TRAPPED_MANGROVE_CHEST = MANGROVE_CHEST + " com Armadilha";
        TRAPPED_CHERRY_CHEST = CHERRY_CHEST + " com Armadilha";
        TRAPPED_BAMBOO_CHEST = BAMBOO_CHEST + " com Armadilha";
        TRAPPED_CRIMSON_CHEST = CRIMSON_CHEST + " com Armadilha";
        TRAPPED_WARPED_CHEST = WARPED_CHEST + " com Armadilha";

        // Vanilla override
        SPRUCE_BARREL = "Barríl de Abeto";

        OAK_BARREL = "Barríl de Carvalho";
        BIRCH_BARREL = "Barríl de Bétula";
        DARK_OAK_BARREL = "Barríl de Carvalho Escuro";
        PALE_OAK_BARREL = "Barríl de Carvalho Pálido";
        ACACIA_BARREL = "Barríl de Acácia";
        JUNGLE_BARREL = "Barríl da Selva";
        MANGROVE_BARREL = "Barríl de Mangue";
        CHERRY_BARREL = "Barríl de Cerejeira";
        BAMBOO_BARREL = "Barríl de Bambu";
        CRIMSON_BARREL = "Barríl Carmesim";
        WARPED_BARREL = "Barríl Distorcida";

        // Vanilla override
        STONE_FURNACE = "Fornalha de Pedra";

        BLACKSTONE_FURNACE = "Fornalha de Pedra-negra";
        DEEPSLATE_FURNACE = "Fornalha de Ardosiabissal";
    }
}
