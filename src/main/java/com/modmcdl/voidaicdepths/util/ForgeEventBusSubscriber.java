package com.modmcdl.voidaicdepths.util;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.init.VoidaicDimensions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VoidaicDepths.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber
{

    //Register Dimension
    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event)
    {
        if(DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE) == null)
        {
            DimensionManager.registerDimension(VoidaicDepths.VOID_DIM_TYPE, VoidaicDimensions.THE_VOID.get(), null,false);
            //VoidaicDepths.LOGGER.info("Pretend I'm loading the void here...");
        }

        VoidaicDepths.LOGGER.info("The Depths of the Void have been loaded. . .");
    }




}
