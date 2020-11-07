package com.modmcdl.voidaicdepths.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.world.dim.VoidModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VoidaicDimensions
{

    public static final DeferredRegister<ModDimension> DIMENSION = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, VoidaicDepths.MODID);

    public static final RegistryObject<ModDimension> THE_VOID = DIMENSION.register("the_void_depths", () -> new VoidModDimension());

}
