package com.modmcdl.voidaicdepths.core.blocks;

import com.modmcdl.voidaicdepths.core.init.VoidaicBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class VoidPlant extends PlantBlock
{
    public VoidPlant(Settings settings)
    {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
    {
        Block block = floor.getBlock();
        return block == VoidaicBlocks.VOIDSTONE || block == VoidaicBlocks.VOID_ORE || block == VoidaicBlocks.OVERGROWN_VOIDSTONE;
    }
}
