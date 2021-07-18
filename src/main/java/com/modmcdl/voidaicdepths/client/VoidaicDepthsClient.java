package com.modmcdl.voidaicdepths.client;

import com.modmcdl.voidaicdepths.core.init.VoidaicBlocks;
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
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_WEEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.NIGHTBLOOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.TWISTED_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOIDSHROOM, RenderLayer.getCutout());
    }
}
