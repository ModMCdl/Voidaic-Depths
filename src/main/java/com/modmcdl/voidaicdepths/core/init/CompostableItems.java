package com.modmcdl.voidaicdepths.core.init;

import com.modmcdl.voidaicdepths.core.blocks.VoidPlant;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

public class CompostableItems
{
    private static void registerCompostItem(ItemConvertible item, float chance)
    {
        if (item.asItem() != Items.AIR)
        {
            ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), chance);
        }
    }

    public static void registerCompostBlock(Block block)
    {
        if (block instanceof VoidPlant)
        {
            registerCompostItem(block, 0.65F);
        }
    }
}
