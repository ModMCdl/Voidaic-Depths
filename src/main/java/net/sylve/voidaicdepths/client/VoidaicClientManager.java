package net.sylve.voidaicdepths.client;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.sylve.voidaicdepths.core.VoidaicBlocks;

public class VoidaicClientManager implements ClientModInitializer
{
    @Override
    public void onInitializeClient() 
    {
        //Alpha Renderers
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_WEEDS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.NIGHTBLOOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.TWISTED_SHRUB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOIDSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.VOID_CARROTS, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.UNDERWOOD_DOOR, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.UNDERWOOD_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(VoidaicBlocks.POTTED_VOID_BLOSSOM, RenderLayer.getCutout());

    }
}
