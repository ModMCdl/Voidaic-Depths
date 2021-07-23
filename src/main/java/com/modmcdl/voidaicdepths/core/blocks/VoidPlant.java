package com.modmcdl.voidaicdepths.core.blocks;

import com.modmcdl.voidaicdepths.core.init.VoidaicObjectRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

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
        return block == VoidaicObjectRegistry.VOIDSTONE || block == VoidaicObjectRegistry.VOID_ORE || block == VoidaicObjectRegistry.OVERGROWN_VOIDSTONE;
    }
}
