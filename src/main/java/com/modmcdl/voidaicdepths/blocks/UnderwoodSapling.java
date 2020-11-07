package com.modmcdl.voidaicdepths.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;


import java.util.Random;
import java.util.function.Supplier;


public class UnderwoodSapling extends BushBlock implements IGrowable
{
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape SAP = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Supplier<Tree> treeSupplier;


    public UnderwoodSapling(Supplier<Tree> treeSupplier, Properties properties)
    {
        super(properties);
        this.treeSupplier = treeSupplier;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SAP;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        if(!worldIn.isAreaLoaded(pos, 1))
        {
            return;
        }
        if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0)
        {
            this.grow(worldIn, pos, state, rand);
        }
    }

    public void grow(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand)
    {
        if(state.get(STAGE) == 0)
        {
            worldIn.setBlockState(pos, state.cycle(STAGE), 4);
        }
        else
        {
            if (!ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;
            this.treeSupplier.get().func_225545_a_(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state)
    {
      this.grow(worldIn, pos, state, rand);
    }

    @Override
    public boolean canGrow(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, BlockState blockState)
    {
        return (double)world.rand.nextFloat() < 0.45D;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_)
    {
        p_206840_1_.add(STAGE);
    }
}
