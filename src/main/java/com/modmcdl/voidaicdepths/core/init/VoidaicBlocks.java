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

public class VoidaicBlocks
{
    public static final LinkedHashMap<Block, Identifier> BLOCKS = new LinkedHashMap<>();

    //-- BLOCK LIST --//
    public static final Block VOIDSTONE = create("voidstone", new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5F).resistance(6.0F)));
    public static final Block OVERGROWN_VOIDSTONE = create("overgrown_voidstone", new Block(FabricBlockSettings.copy(VOIDSTONE).sounds(BlockSoundGroup.WET_GRASS)));
    public static final Block VOID_SAND = create("void_sand", new Block(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block VOIDSTONE_PILLAR = create("voidstone_pillar", new PillarBlock(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block VOIDSTONE_TILES = create("voidstone_tiles", new Block(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block CRACKED_VOIDSTONE_TILES = create("cracked_voidstone_tiles", new Block(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block POLISHED_VOIDSTONE = create("polished_voidstone", new Block(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block VOIDSTONE_TILE_STAIRS = create("voidstone_tile_stairs", new BlockStairs(VOIDSTONE_TILES, FabricBlockSettings.copy(VOIDSTONE_TILES)));
    public static final Block VOIDSTONE_TILE_SLAB = create("voidstone_tile_slab", new SlabBlock(FabricBlockSettings.copy(VOIDSTONE_TILES)));
    public static final Block POLISHED_VOIDSTONE_STAIRS = create("polished_voidstone_stairs", new BlockStairs(POLISHED_VOIDSTONE, FabricBlockSettings.copy(POLISHED_VOIDSTONE)));
    public static final Block POLISHED_VOIDSTONE_SLAB = create("polished_voidstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_VOIDSTONE)));
    public static final Block VOIDSTONE_WALL = create("voidstone_wall", new WallBlock(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block POLISHED_VOIDSTONE_WALL = create("polished_voidstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_VOIDSTONE)));

    public static final Block VOID_ORE = create("void_ore", new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).resistance(6.0F).breakByTool(FabricToolTags.PICKAXES, 2)));

    public static final Block VOID_LANTERN = create("void_lantern", new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN).nonOpaque()));

    public static final Block VOID_WEEDS = create("void_weeds", new VoidPlant(FabricBlockSettings.copy(Blocks.GRASS).nonOpaque()));
    public static final Block VOID_BLOSSOM = create("void_blossom", new VoidPlant(FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()));
    public static final Block TWISTED_SHRUB = create("twisted_shrub", new VoidPlant(FabricBlockSettings.copy(Blocks.DEAD_BUSH).nonOpaque()));
    public static final Block VOIDSHROOM = create("voidshroom", new VoidPlant(FabricBlockSettings.copy(Blocks.RED_MUSHROOM).nonOpaque()));
    public static final Block NIGHTBLOOM = create("nightbloom", new VoidPlant(FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()));


    public static class BlockStairs extends StairsBlock
    {
        public BlockStairs(Block base, Settings settings)
        {
            super(base.getDefaultState(), settings);
        }
    }

    private static BlockItem getItem(Block block)
    {
        return new BlockItem(block, new Item.Settings().group(VoidaicDepths.VD_GROUP));
    }

    public static void register()
    {
        BLOCKS.keySet().forEach(block ->
        {
            Registry.register(Registry.BLOCK, BLOCKS.get(block), block);
            Registry.register(Registry.ITEM, BLOCKS.get(block), getItem(block));
        });
    }

    private static <T extends Block> T create(String name, T block)
    {
        BLOCKS.put(block, new Identifier(VoidaicDepths.MOD_ID, name));
        return block;
    }
}
