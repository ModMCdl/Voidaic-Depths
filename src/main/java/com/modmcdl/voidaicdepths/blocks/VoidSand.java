package com.modmcdl.voidaicdepths.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class VoidSand extends FallingBlock
{

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

    public VoidSand(Properties properties)
    {
        super(properties);
    }

    public VoxelShape getCollisionShape(BlockState blockState, IBlockReader blockReader, BlockPos pos, ISelectionContext selectionContext)
    {
        return SHAPE;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
    {
        entityIn.setMotionMultiplier(state, new Vec3d(0.25D, (double)0.05F, 0.25D));
    }

    @Override
    public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return true;
    }
}
