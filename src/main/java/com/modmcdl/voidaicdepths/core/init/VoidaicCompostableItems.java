package com.modmcdl.voidaicdepths.core.init;

import com.modmcdl.voidaicdepths.core.blocks.VoidPlant;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;

public class VoidaicCompostableItems
{
    public static void compostableItemsList()
    {
        CompostingChanceRegistry compostingChanceRegistry = CompostingChanceRegistry.INSTANCE;
        compostingChanceRegistry.add(VoidaicObjectRegistry.NIGHTBLOOM, 0.3f);
        compostingChanceRegistry.add(VoidaicObjectRegistry.TWISTED_SHRUB, 0.3f);
        compostingChanceRegistry.add(VoidaicObjectRegistry.VOID_BLOSSOM, 0.3f);
        compostingChanceRegistry.add(VoidaicObjectRegistry.VOID_WEEDS, 0.3f);
        compostingChanceRegistry.add(VoidaicObjectRegistry.VOIDSHROOM, 0.3f);
        compostingChanceRegistry.add(VoidaicObjectRegistry.VOID_CARROT, 1f);
    }
}
