package com.modmcdl.voidaicdepths.blocks;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;


public class VoidPlant extends BushBlock
{
    public VoidPlant(Properties properties)
    {
        super(properties);
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Block block = state.getBlock();
        return block == VoidaicBlocks.VOIDSTONE.get() || block == VoidaicBlocks.VOID_ORE.get() || block == VoidaicBlocks.OVERGROWN_VOIDSTONE.get();
    }
}
