package com.vinii.v2m.datagen.translation;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class PortugueseBRLangProvider extends TranslationProvider {
    public PortugueseBRLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
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

        // Config keys
        CONFIG_TITLE = "Configuraçao do Vinii's Variants Mod";

        CONFIG_MAIN_NAME = "Configuração";
        CONFIG_MAIN_TOOLTIP = "Configuração principal";

        CONFIG_MAIN_STRUCTURES_NAME = "Geração de estruturas";
        CONFIG_MAIN_STRUCTURES_DESC = "Opções de geração de estruturas";

        CONFIG_MAIN_STRUCTURES_GENERATE_NAME = "Gerar blocos de utilidade";
        CONFIG_MAIN_STRUCTURES_GENERATE_DESC = "Gerar blocos de utilidade(Baús, fornalhas, etc) em estruturas";

        CONFIG_MAIN_STRUCTURES_GENERATE_FROSTED_NAME = "Gerar vidro congelado";
        CONFIG_MAIN_STRUCTURES_GENERATE_FROSTED_DESC = "Gerar painéis de vidro congelado em vilas da neve";

        CONFIG_MAIN_STRUCTURES_GENERATE_PALE_MANSION_NAME = "Gerar mansão de carvalho pálido (Experimental)";
        CONFIG_MAIN_STRUCTURES_GENERATE_PALE_MANSION_DESC = """
            Gerar versão de carvalho pálido da mansão da floresta em jardins pálidos.
            Nota: o comando /place não funciona com essa versão, e as chances de geração ainda são vanilla, então é extremamente improvável ela gerar.
            
            Importante: essa opção é experimental e pode causar conflitos com outros mods ou problemas de performance.""";

        CONFIG_MAIN_STRUCTURES_GENERATE_CRIMSON_FORTRESS_NAME = "Gerar fortalezas carmesin (Inacabado)";
        CONFIG_MAIN_STRUCTURES_GENERATE_CRIMSON_FORTRESS_DESC = """
            Gerar versão carmesin da fortaleza do nether em florestas carmesin.
            
            Importante: essa opção não está finalizada e você não deve habilitá-la.""";

        CONFIG_COMPATIBILITY_NAME = "Compatibilidade";
        CONFIG_COMPATIBILITY_TOOLTIP = "Opções de compatibilidade";

        CONFIG_COMPATIBILITY_RECIPE_NAME = "Compatibilidade de receitas";
        CONFIG_COMPATIBILITY_RECIPE_DESC = """
            Habilitar compatibilidade de receitas com outros mods.
            
            Quando usar:
            Use apenas se estiver com outro mod que adiciona variantes de madeira ou pedra (que possam craftar baús, fornalhas, etc).
            Habilitando essa opção fará com que as receitas do mod só possam ser craftadas pelo livro de receitas, não habilitando levaria a essas receitas serem deletadas.
            
            Using the chest as an example, but not limited to it:
            O que muda: ambas as receitas vanilla e do mod ficam disponiveis em conflito e só podem ser criadas pelo livro de receita.
            
            Não habilite caso não haja necessidade, mods que precisam dessa opção incluem: Wilder Wild, e Biomes O' Plenty.
            
            Caso habilite enquanto estiver dentro de um mundo você precisará sair e entrar novamente ou usar o comando "/reload".""";

    }
}
