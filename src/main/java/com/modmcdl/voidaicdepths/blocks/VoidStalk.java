package com.modmcdl.voidaicdepths.blocks;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class VoidStalk extends BushBlock
{
    public VoidStalk(Properties properties)
    {
        super(properties);
    }



    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        Block block = state.getBlock();
        return block == VoidaicBlocks.VOID_STALK_STEM.get() || block == VoidaicBlocks.OVERGROWN_VOIDSTONE.get();
    }
}

