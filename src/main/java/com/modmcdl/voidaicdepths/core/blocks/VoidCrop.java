package com.modmcdl.voidaicdepths.core.blocks;

import com.modmcdl.voidaicdepths.core.init.VoidaicBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;


import java.util.Random;

public class VoidCrop extends CropBlock
{
    public VoidCrop(Settings settings)
    {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(this.getAgeProperty(), 0));
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(VoidaicBlocks.VOID_SAND);
    }
}
