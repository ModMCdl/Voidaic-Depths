package com.modmcdl.voidaicdepths.core.blocks;

import com.modmcdl.voidaicdepths.core.init.VoidaicItems;
import com.modmcdl.voidaicdepths.core.init.VoidaicObjectRegistry;
import net.minecraft.item.ItemConvertible;

public class VoidCarrotCrop extends VoidCrop
{
    protected VoidCarrotCrop(Settings settings)
    {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return VoidaicObjectRegistry.VOID_CARROT;
    }
}
