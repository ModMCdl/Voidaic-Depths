package com.modmcdl.voidaicdepths.core.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.core.blocks.VoidPlant;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;

public class VoidaicObjectRegistry
{
    public static final LinkedHashMap<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    public static final LinkedHashMap<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //-- BLOCK LIST --//
    public static final Block VOIDSTONE = create("voidstone", new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5F).resistance(6.0F)), true);
    public static final Block OVERGROWN_VOIDSTONE = create("overgrown_voidstone", new Block(FabricBlockSettings.copy(VOIDSTONE).sounds(BlockSoundGroup.WET_GRASS)), true);
    public static final Block VOID_SAND = create("void_sand", new Block(FabricBlockSettings.copy(Blocks.SAND)), true);
    public static final Block VOIDSTONE_PILLAR = create("voidstone_pillar", new PillarBlock(FabricBlockSettings.copy(VOIDSTONE)), true);
    public static final Block VOIDSTONE_TILES = create("voidstone_tiles", new Block(FabricBlockSettings.copy(VOIDSTONE)), true);
    public static final Block CRACKED_VOIDSTONE_TILES = create("cracked_voidstone_tiles", new Block(FabricBlockSettings.copy(VOIDSTONE)), true);
    public static final Block POLISHED_VOIDSTONE = create("polished_voidstone", new Block(FabricBlockSettings.copy(VOIDSTONE)), true);
    public static final Block VOIDSTONE_TILE_STAIRS = create("voidstone_tile_stairs", new BlockStairs(VOIDSTONE_TILES, FabricBlockSettings.copy(VOIDSTONE_TILES)), true);
    public static final Block VOIDSTONE_TILE_SLAB = create("voidstone_tile_slab", new SlabBlock(FabricBlockSettings.copy(VOIDSTONE_TILES)), true);
    public static final Block POLISHED_VOIDSTONE_STAIRS = create("polished_voidstone_stairs", new BlockStairs(POLISHED_VOIDSTONE, FabricBlockSettings.copy(POLISHED_VOIDSTONE)), true);
    public static final Block POLISHED_VOIDSTONE_SLAB = create("polished_voidstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_VOIDSTONE)), true);
    public static final Block VOIDSTONE_WALL = create("voidstone_wall", new WallBlock(FabricBlockSettings.copy(VOIDSTONE)), true);
    public static final Block POLISHED_VOIDSTONE_WALL = create("polished_voidstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_VOIDSTONE)), true);

    public static final Block VOID_PORTAL_FRAME = create("void_portal_frame", new EndPortalFrameBlock(FabricBlockSettings.copy(Blocks.END_PORTAL_FRAME)), true);

    public static final Block VOID_ORE = create("void_ore", new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).resistance(6.0F).breakByTool(FabricToolTags.PICKAXES, 2)), true);

    public static final Block VOID_LANTERN = create("void_lantern", new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN).nonOpaque()), true);

    public static final Block VOID_WEEDS = create("void_weeds", new VoidPlant(FabricBlockSettings.copy(Blocks.GRASS).nonOpaque()), true);
    public static final Block VOID_BLOSSOM = create("void_blossom", new VoidPlant(FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()), true);
    public static final Block TWISTED_SHRUB = create("twisted_shrub", new VoidPlant(FabricBlockSettings.copy(Blocks.DEAD_BUSH).nonOpaque()), true);
    public static final Block VOIDSHROOM = create("voidshroom", new VoidPlant(FabricBlockSettings.copy(Blocks.RED_MUSHROOM).nonOpaque()), true);
    public static final Block NIGHTBLOOM = create("nightbloom", new VoidPlant(FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()), true);

    public static final Block UNDERWOOD_LOG = create("underwood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), true);
    public static final Block UNDERWOOD_PLANKS = create("underwood_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), true);
    public static final Block UNDERWOOD_STAIRS = create("underwood_stairs", new BlockStairs(UNDERWOOD_PLANKS, FabricBlockSettings.copy(Blocks.OAK_STAIRS)), true);
    public static final Block UNDERWOOD_SLAB = create("underwood_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), true);

    //-- ITEM LIST --//
    public static final Item ARCANE_SALT = create("arcane_salt", new Item(group()));
    public static final Item VOID_ESSENCE = create("void_essence", new Item(group()));
    public static final Item VOID_CRYSTAL = create("void_crystal", new Item(group()));
    public static final Item ATTUNED_ENDER_PEARL = create("attuned_ender_pearl", new Item(group()));

    public static final Item VOID_CARROT = create("void_carrot", new Item(group()));

    public static final Item VOID_INGOT = create("void_ingot", new Item(group()));
    public static final Item VOID_NUGGET = create("void_nugget", new Item(group()));

    public static final Item TRANSLOCATION_STAFF = create("staff_of_translocation", new Item(group()));
    public static final Item VOID_GOGGLES = create("void_goggles", new Item(group()));


    //Factory ---------------------------------------------------------------------------------------------
    public static class BlockStairs extends StairsBlock
    {
        public BlockStairs(Block base, Settings settings)
        {
            super(base.getDefaultState(), settings);
        }
    }

    public static Item.Settings group()
    {
        return new Item.Settings().group(VoidaicDepths.VD_GROUP);
    }

    private static <T extends Item> T create(String name, T item) //Creates Items
    {
        ITEMS.put(item, new Identifier(VoidaicDepths.MOD_ID, name));
        return item;
    }

    private static <T extends Block> T create(String name, T block, boolean itemBlock) //Creates Blocks
    {
        BLOCKS.put(block, new Identifier(VoidaicDepths.MOD_ID, name));
        if(itemBlock)
        {
            ITEMS.put(new BlockItem(block, group()), BLOCKS.get(block));
        }
        return block;
    }

    public static void registerObjects()
    {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }



}
