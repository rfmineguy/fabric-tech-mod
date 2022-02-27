package com.rf.techmod.util;

import com.google.gson.JsonObject;
import com.rf.techmod.TechMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashSet;
import java.util.Set;

public class ModRegistry {
    public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.create(
            new Identifier(TechMod.MOD_ID, "general"))
            .icon(()->new ItemStack(Items.TEST_ITEM))
            .build();

    private static final FabricItemSettings DEFAULT_MOD_ITEM_SETTINGS = new FabricItemSettings().group(MOD_GROUP);
    private static final FabricBlockSettings DEFAULT_MOD_BLOCK_SETTINGS = FabricBlockSettings.of(Material.STONE);


    public static class Items {
        public static Item TEST_ITEM = new Item(DEFAULT_MOD_ITEM_SETTINGS);
    }
    public static class Blocks {
        public static Block TEST_BLOCK = new Block(DEFAULT_MOD_BLOCK_SETTINGS);
    }
    public static class Recipes {

    }

    public static void RegisterModItems() {
        RegisterItem("test_item", Items.TEST_ITEM);

        TechMod.LOGGER.info("Registered mod items successfully");
    }

    public static void RegisterModBlocks() {
        RegisterBlock("test_block", Blocks.TEST_BLOCK);

        TechMod.LOGGER.info("Registered mod blocks successfully");
    }

    public static void RegisterModRecipes() {

    }

    //register items and blocks to the minecraft Registry
    private static void RegisterItem(String name, Item item) {
        TechMod.LOGGER.debug("Registered new item {}", name);
        Registry.register(Registry.ITEM, new Identifier(TechMod.MOD_ID, name), item);
    }
    private static void RegisterBlock(String name, Block block) {
        TechMod.LOGGER.debug("Registered new block {}", name);
        Registry.register(Registry.BLOCK, new Identifier(TechMod.MOD_ID, name), block);
        Registry.register(Registry.ITEM, new Identifier(TechMod.MOD_ID, name), new BlockItem(block, DEFAULT_MOD_ITEM_SETTINGS));
    }
    public static void RegisterRecipe(JsonObject recipe) {
        TechMod.LOGGER.debug("Registered new recipe (WIP)");
    }
}
