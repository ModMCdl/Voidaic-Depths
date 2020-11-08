package com.modmcdl.voidaicdepths.util;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class BioluminescentRender extends RenderType
{
    public BioluminescentRender(String name, VertexFormat vertexFormat, int mode, int size, boolean crumbling, boolean depth, Runnable onEnable, Runnable onDisable)
    {
        super(name, vertexFormat, mode, size, crumbling, depth, onEnable, onDisable);
        throw new IllegalStateException();
    }

    public static RenderType getBioluminescent(ResourceLocation location)
    {
        State render = State.getBuilder()
                .texture(new TextureState(location, false, false))
                .transparency(NO_TRANSPARENCY)
                .alpha(DEFAULT_ALPHA)
                .cull(CULL_DISABLED)
                .lightmap(LIGHTMAP_DISABLED)
                .overlay(OVERLAY_ENABLED)
                .build(true);

        return makeType("bioluminescent_rendertype", DefaultVertexFormats.BLOCK, GL11.GL_QUADS, 256, true, false, render);
    }

}
