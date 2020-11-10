package com.modmcdl.voidaicdepths.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class VoidaicItemGroup extends ItemGroup
{

    public static final VoidaicItemGroup VOIDTAB  = new VoidaicItemGroup(ItemGroup.GROUPS.length, "voidaic_depths");

    private VoidaicItemGroup(int index, String label)
    {
        super(index, label);
    }

    public ItemStack createIcon()
    {
        return new ItemStack(VoidaicItems.VOID_STAR.get());
    }

}
