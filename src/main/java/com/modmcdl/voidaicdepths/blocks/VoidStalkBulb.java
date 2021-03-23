package com.modmcdl.voidaicdepths.blocks;

import net.minecraft.block.Block;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class VoidStalkBulb extends Block
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_5;
    private final VoidStalk voidStalk;

    public VoidStalkBulb(VoidStalk voidStalkVine, Properties builder)
    {
        super(builder);
        this.voidStalk = voidStalkVine;
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
    }
}
