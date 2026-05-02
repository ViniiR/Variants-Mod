package com.vinii.v2m.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class PortugueseBRLangProvider extends TranslationProvider {
    public PortugueseBRLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "pt_br", registryLookup);

        ICID = "Gelenho";

        PALE_PUMPKIN = "Abóbora Pálida";
        CARVED_PALE_PUMPKIN = PALE_PUMPKIN + " Esculpida";
        PALE_JACK_O_LANTERN = PALE_PUMPKIN + " de Halloween";

        PALE_SNOW_GOLEM = "Golem de Neve Pálido";

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

        LARGE_OAK_CHEST = OAK_CHEST + " Grande";
        LARGE_SPRUCE_CHEST = SPRUCE_CHEST + " Grande";
        LARGE_BIRCH_CHEST = BIRCH_CHEST + " Grande";
        LARGE_DARK_OAK_CHEST = DARK_OAK_CHEST + " Grande";
        LARGE_PALE_OAK_CHEST = PALE_OAK_CHEST + " Grande";
        LARGE_ACACIA_CHEST = ACACIA_CHEST + " Grande";
        LARGE_JUNGLE_CHEST = JUNGLE_CHEST + " Grande";
        LARGE_MANGROVE_CHEST = MANGROVE_CHEST + " Grande";
        LARGE_CHERRY_CHEST = CHERRY_CHEST + " Grande";
        LARGE_BAMBOO_CHEST = BAMBOO_CHEST + " Grande";
        LARGE_CRIMSON_CHEST = CRIMSON_CHEST + " Grande";
        LARGE_WARPED_CHEST = WARPED_CHEST + " Grande";

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

        COPPER_CHEST = "Baú de Cobre";
        LARGE_COPPER_CHEST = COPPER_CHEST + " Grande";

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

        BLACKSTONE_FURNACE = "Fornalha de Pedra-negra";
        DEEPSLATE_FURNACE = "Fornalha de Ardosiabissal";
    }
}
