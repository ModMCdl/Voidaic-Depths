package com.modmcdl.voidaicdepths.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.blocks.VoidPlant;
import com.modmcdl.voidaicdepths.blocks.VoidSand;
import com.modmcdl.voidaicdepths.blocks.VoidStalk;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class VoidaicBlocks
{

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, VoidaicDepths.MODID);


    //Blocks
        //VOIDSTONE TYPES ie. F_BLOCKS, STAIRS, SLABS, WALLS
    public static final RegistryObject<Block> VOIDSTONE = BLOCKS.register("voidstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> OVERGROWN_VOIDSTONE = BLOCKS.register( "overgrown_voidstone", () -> new Block(Block.Properties.from(VoidaicBlocks.VOIDSTONE.get())));
    public static final RegistryObject<Block> VOID_SAND = BLOCKS.register("void_sand", () -> new VoidSand(Block.Properties.from(Blocks.SAND)));
    public static final RegistryObject<Block> VOIDSTONE_PILLAR = BLOCKS.register("voidstone_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> VOIDSTONE_TILES = BLOCKS.register("voidstone_tiles", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> VOIDSTONE_TILES_CRACKED = BLOCKS.register("cracked_voidstone_tiles", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 5.0F)));
    public static final RegistryObject<Block> VOIDSTONE_POLISHED = BLOCKS.register("polished_voidstone", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 7.0F)));
    public static final RegistryObject<Block> VOIDSTONE_TILE_STAIRS = BLOCKS.register("voidstone_tile_stairs", () -> new StairsBlock(() -> VoidaicBlocks.VOIDSTONE_TILES.get().getDefaultState(), Block.Properties.from(VoidaicBlocks.VOIDSTONE_TILES.get())));
    public static final RegistryObject<Block> POLISHED_VOIDSTONE_STAIRS = BLOCKS.register("polished_voidstone_stairs", () -> new StairsBlock(() -> VoidaicBlocks.VOIDSTONE_POLISHED.get().getDefaultState(), Block.Properties.from(VoidaicBlocks.VOIDSTONE_POLISHED.get())));
    public static final RegistryObject<Block> VOIDSTONE_WALL = BLOCKS.register("voidstone_wall", () -> new WallBlock(Block.Properties.from(VoidaicBlocks.VOIDSTONE.get())));
    public static final RegistryObject<Block> POLISHED_VOIDSTONE_WALL = BLOCKS.register("polished_voidstone_wall", () -> new WallBlock(Block.Properties.from(VoidaicBlocks.VOIDSTONE_POLISHED.get())));
    public static final RegistryObject<Block> VOIDSTONE_TILE_SLAB = BLOCKS.register("voidstone_tile_slab", () -> new SlabBlock(Block.Properties.from(VoidaicBlocks.VOIDSTONE_TILES.get())));
    public static final RegistryObject<Block> POLISHED_VOIDSTONE_SLAB = BLOCKS.register("polished_voidstone_slab", () -> new SlabBlock(Block.Properties.from(VoidaicBlocks.VOIDSTONE_POLISHED.get())));

    public static final RegistryObject<Block> VOID_ORE = BLOCKS.register("void_ore", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F,3.0F).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> VOID_CLOUD = BLOCKS.register("void_cloud", () -> new Block(Block.Properties.from(Blocks.COBWEB)));

    public static final RegistryObject<Block> VOID_LANTERN = BLOCKS.register("void_lantern", () -> new LanternBlock(Block.Properties.from(Blocks.LANTERN)));

    public static final RegistryObject<Block> VOID_WEEDS = BLOCKS.register("void_weeds", () -> new VoidPlant(Block.Properties.from(Blocks.GRASS)));
    public static final RegistryObject<Block> VOID_BULB = BLOCKS.register("void_bulb", () -> new VoidPlant(Block.Properties.from(Blocks.POPPY)));
    public static final RegistryObject<Block> TWISTED_SHRUB = BLOCKS.register("twisted_shrub", () -> new VoidPlant((Block.Properties.from(Blocks.DEAD_BUSH))));
    public static final RegistryObject<Block> VOIDSHROOM = BLOCKS.register("voidshroom", () -> new VoidPlant((Block.Properties.from(Blocks.RED_MUSHROOM))));


    public static final RegistryObject<Block> VOID_STALK_STEM = BLOCKS.register("void_stalk_stem", () -> new VoidStalk(Block.Properties.from(Blocks.BAMBOO).doesNotBlockMovement()));
    public static final RegistryObject<Block> VOID_STALK_BLOSSOM = BLOCKS.register("void_stalk_bulb", () -> new VoidStalk(Block.Properties.from(Blocks.CHORUS_FLOWER).lightValue(10)));


    //UNDERWOOD TYPES
    //public static final RegistryObject<Block> UNDERWOOD_SAPLING = BLOCKS.register("underwood_sapling", () -> new UnderwoodSapling(() -> new UnderwoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> UNDERWOOD_LOG = BLOCKS.register("underwood_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> UNDERWOOD_PLANKS = BLOCKS.register("underwood_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> UNDERWOOD_STAIRS = BLOCKS.register("underwood_stairs", () -> new StairsBlock(() -> VoidaicBlocks.UNDERWOOD_PLANKS.get().getDefaultState(), Block.Properties.from(VoidaicBlocks.UNDERWOOD_PLANKS.get())));
    public static final RegistryObject<Block> UNDERWOOD_SLAB = BLOCKS.register("underwood_slab", () -> new SlabBlock(Block.Properties.from(VoidaicBlocks.UNDERWOOD_PLANKS.get())));

    //public static final RegistryObject<Block> UNDERWOOD_LEAVES = BLOCKS.register("underwood_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));



}
