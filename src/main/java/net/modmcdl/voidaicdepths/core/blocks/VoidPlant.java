package net.modmcdl.voidaicdepths.core.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.modmcdl.voidaicdepths.core.VoidaicBlocks;

public class VoidPlant extends PlantBlock
{
    public VoidPlant(Settings settings)
    {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
    {
        return floor.isOf(VoidaicBlocks.VOIDSTONE) ||
                floor.isOf(VoidaicBlocks.OVERGROWN_VOIDSTONE) ||
                floor.isOf(VoidaicBlocks.VOID_SAND) ||
                floor.isOf(VoidaicBlocks.VOID_ORE);
    }
}
