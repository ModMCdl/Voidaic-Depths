package com.modmcdl.voidaicdepths.world.dim;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import java.util.function.BiFunction;

public class VoidModDimension extends ModDimension
{
    @Override //Bi-function factory
    public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
        return VoidDimension::new;
    }
}
