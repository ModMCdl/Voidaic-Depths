package com.modmcdl.voidaicdepths.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class VoidSand extends FallingBlock
{

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

    public VoidSand(Properties properties)
    {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState blockState, IBlockReader blockReader, BlockPos pos, ISelectionContext selectionContext)
    {
        return SHAPE;
    }

    public boolean allowsMovement(BlockState blockState, IBlockReader blockReader, BlockPos pos, PathType pathType)
    {
        return false;
    }


}
