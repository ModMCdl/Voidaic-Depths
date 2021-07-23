package com.modmcdl.voidaicdepths.client;

import com.modmcdl.voidaicdepths.core.init.VoidaicObjectRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class VoidaicDepthsClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        //Item Renderers
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicObjectRegistry.VOID_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicObjectRegistry.VOID_WEEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicObjectRegistry.VOID_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicObjectRegistry.NIGHTBLOOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicObjectRegistry.TWISTED_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicObjectRegistry.VOIDSHROOM, RenderLayer.getCutout());
    }
}
