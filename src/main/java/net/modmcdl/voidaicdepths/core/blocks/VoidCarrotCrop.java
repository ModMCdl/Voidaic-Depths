package net.modmcdl.voidaicdepths.core.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.modmcdl.voidaicdepths.core.VoidaicBlocks;
import net.modmcdl.voidaicdepths.core.VoidaicItems;

public class VoidCarrotCrop extends CropBlock
{
    public VoidCarrotCrop(Settings settings)
    {
        super(settings);
    }

    protected ItemConvertible getSeedsItem()
    {
        return VoidaicItems.VOID_CARROT;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos)
    {
        return floor.isOf(VoidaicBlocks.VOID_SAND);
    }
}

