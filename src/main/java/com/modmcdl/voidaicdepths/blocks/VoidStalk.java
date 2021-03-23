package com.modmcdl.voidaicdepths.blocks;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;


public class VoidStalk extends BushBlock //implements IGrowable
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

    /*public void tick(BlockState blockState, ServerWorld world, BlockPos blockPos, Random rand)
    {
        if (!blockState.isValidPosition(world, blockPos)) {
            world.destroyBlock(blockPos, true);
        }
        else if (rand.nextInt(3) == 0 && world.isAirBlock(blockPos.up()) && world.getLightSubtracted(blockPos.up(), 0) >= 9)
        {
                int lvt_5_1_ = this.getStalksBelow(world, blockPos) + 1;
                if (lvt_5_1_ < 16) {
                    this.grow(world, rand, blockPos, blockState);
                }

        }
    }

    public boolean canGrow(IBlockReader iBlockReader, BlockPos blockPos, BlockState state, boolean grow) {
        int stalksAbove = this.getStalksAbove(iBlockReader, blockPos);
        int stalksBelow = this.getStalksBelow(iBlockReader, blockPos);
        return stalksAbove + stalksBelow + 1 < 16;
    }

    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random rand, BlockPos blockPos, BlockState state) {
        int stalksAbove = this.getStalksAbove(world, blockPos);
        int stalksBelow = this.getStalksBelow(world, blockPos);
        int h = stalksAbove + stalksBelow + 1;
        int r = 1 + rand.nextInt(2);

        for(int lvt_9_1_ = 0; lvt_9_1_ < r; ++lvt_9_1_) {
            BlockPos up = blockPos.up(stalksAbove);
            BlockState blockState = world.getBlockState(up);
            if (!world.isAirBlock(up.up())) {
                return;
            }

            this.grow(world, rand, blockPos, state);
            ++stalksAbove;
            ++h;
        }
    }

    protected int getStalksAbove(IBlockReader iBlockReader, BlockPos blockPos) {
        int i;
        for(i = 0; i < 16 && iBlockReader.getBlockState(blockPos.up(i + 1)).getBlock() == VoidaicBlocks.VOID_STALK_STEM.get(); ++i) {
        }

        return i;
    }

    protected int getStalksBelow(IBlockReader iBlockReader, BlockPos blockPos) {
        int i;
        for(i = 0; i < 16 && iBlockReader.getBlockState(blockPos.down(i + 1)).getBlock() == VoidaicBlocks.VOID_STALK_STEM.get(); ++i) {
        }

        return i;
    }*/

}

