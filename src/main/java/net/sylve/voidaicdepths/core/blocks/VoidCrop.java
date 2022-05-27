package net.sylve.voidaicdepths.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sylve.voidaicdepths.core.VoidaicBlocks;

public class VoidCrop extends PlantBlock
{
    public VoidCrop(Settings settings)
    {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
    {
        return floor.isOf(VoidaicBlocks.VOID_SAND);
    }
}
