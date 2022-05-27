package net.sylve.voidaicdepths.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sylve.voidaicdepths.VoidaicDepths;
import net.sylve.voidaicdepths.core.blocks.VoidCarrotCrop;
import net.sylve.voidaicdepths.core.blocks.VoidPlant;

public class VoidaicBlocks
{
    public static final Block OSSIFICUM_BLOCK = registerVoidBlock("ossificum_block", new Block(FabricBlockSettings.of(Material.METAL)));

    public static final Block VOIDSTONE = registerVoidBlock("voidstone", new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5F).resistance(6.0F).requiresTool()));
    public static final Block OVERGROWN_VOIDSTONE = registerVoidBlock("overgrown_voidstone", new Block(FabricBlockSettings.copy(VOIDSTONE).sounds(BlockSoundGroup.WET_GRASS)));
    public static final Block VOID_SAND = registerVoidBlock("void_sand", new Block(FabricBlockSettings.copy(Blocks.SAND)));
    public static final Block VOIDSTONE_PILLAR = registerVoidBlock("voidstone_pillar", new PillarBlock(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block VOIDSTONE_TILES = registerVoidBlock("voidstone_tiles", new Block(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block CRACKED_VOIDSTONE_TILES = registerVoidBlock("cracked_voidstone_tiles", new Block(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block POLISHED_VOIDSTONE = registerVoidBlock("polished_voidstone", new Block(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block VOIDSTONE_TILE_STAIRS = registerVoidBlock("voidstone_tile_stairs", new StairsBlock(VOIDSTONE_TILES.getDefaultState(), FabricBlockSettings.copy(VOIDSTONE_TILES)));
    public static final Block VOIDSTONE_TILE_SLAB = registerVoidBlock("voidstone_tile_slab", new SlabBlock(FabricBlockSettings.copy(VOIDSTONE_TILES)));
    public static final Block POLISHED_VOIDSTONE_STAIRS = registerVoidBlock("polished_voidstone_stairs", new StairsBlock(POLISHED_VOIDSTONE.getDefaultState(), FabricBlockSettings.copy(POLISHED_VOIDSTONE)));
    public static final Block POLISHED_VOIDSTONE_SLAB = registerVoidBlock("polished_voidstone_slab", new SlabBlock(FabricBlockSettings.copy(POLISHED_VOIDSTONE)));
    public static final Block VOIDSTONE_WALL = registerVoidBlock("voidstone_wall", new WallBlock(FabricBlockSettings.copy(VOIDSTONE)));
    public static final Block POLISHED_VOIDSTONE_WALL = registerVoidBlock("polished_voidstone_wall", new WallBlock(FabricBlockSettings.copy(POLISHED_VOIDSTONE)));

    public static final Block VOID_PORTAL_FRAME = registerVoidBlock("void_portal_frame", new EndPortalFrameBlock(FabricBlockSettings.copy(Blocks.END_PORTAL_FRAME)));

    public static final Block VOID_ORE = registerVoidBlock("void_ore", new Block(FabricBlockSettings.of(Material.STONE).hardness(3.0F).resistance(6.0F).requiresTool())); //Needs pickaxe

    public static final Block VOID_LANTERN = registerVoidBlock("void_lantern", new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN).nonOpaque()));

    public static final Block VOID_WEEDS = registerVoidBlock("void_weeds", new VoidPlant(FabricBlockSettings.copy(Blocks.GRASS).nonOpaque()));
    public static final Block VOID_BLOSSOM = registerVoidBlock("void_blossom", new VoidPlant(FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()));
    public static final Block TWISTED_SHRUB = registerVoidBlock("twisted_shrub", new VoidPlant(FabricBlockSettings.copy(Blocks.DEAD_BUSH).nonOpaque()));
    public static final Block VOIDSHROOM = registerVoidBlock("voidshroom", new VoidPlant(FabricBlockSettings.copy(Blocks.RED_MUSHROOM).nonOpaque()));
    public static final Block NIGHTBLOOM = registerVoidBlock("nightbloom", new VoidPlant(FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()));
    public static final Block VOID_CARROTS = registerNoItemVoidBlock("void_carrots", new VoidCarrotCrop(FabricBlockSettings.copy(Blocks.CARROTS).nonOpaque()));

    public static final Block UNDERWOOD_LOG = registerVoidBlock("underwood_log", new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block UNDERWOOD_PLANKS = registerVoidBlock("underwood_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block UNDERWOOD_STAIRS = registerVoidBlock("underwood_stairs", new StairsBlock(UNDERWOOD_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)));
    public static final Block UNDERWOOD_SLAB = registerVoidBlock("underwood_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)));
    //public static final Block UNDERWOOD_DOOR = registerVoidBlock("underwood_door", new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), VoidaicDepths.VDITEMGROUP);
    //public static final Block UNDERWOOD_TRAPDOOR = registerVoidBlock("underwood_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), VoidaicDepths.VDITEMGROUP);
    public static final Block UNDERWOOD_SIGN = registerNoItemVoidBlock("underwood_sign", new SignBlock(FabricBlockSettings.copy(Blocks.OAK_SIGN), VoidaicSignTypes.UNDERWOOD));
    public static final Block UNDERWOOD_WALL_SIGN = registerNoItemVoidBlock("underwood_wall_sign", new WallSignBlock(FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN), VoidaicSignTypes.UNDERWOOD));

    public static final Block POTTED_VOID_BLOSSOM = registerNoItemVoidBlock("potted_void_blossom", new FlowerPotBlock(VOID_BLOSSOM, FabricBlockSettings.copy(Blocks.POTTED_ALLIUM).nonOpaque()));


    private static Block registerVoidBlock(String name, Block block)
    {
        registerVoidItemBlock(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(VoidaicDepths.MODID, name), block);

    }

    private static Block registerNoItemVoidBlock(String name, Block block)
    {
        return Registry.register(Registry.BLOCK, new Identifier(VoidaicDepths.MODID, name), block);
    }
    private static Item registerVoidItemBlock(String name, Block block)
    {
        return Registry.register(Registry.ITEM, new Identifier(VoidaicDepths.MODID, name), new BlockItem(block, new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    }
    public static void registerVoidBlocks()
    {
        VoidaicDepths.LOGGER.info("Registering Voidaic Blocks: " + VoidaicDepths.MODID);
    }
}
