package com.modmcdl.voidaicdepths.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class BioluminescentRender extends RenderType
{

    private static final RenderType BIOLUMINESCENT;

    public BioluminescentRender(String name, VertexFormat vertexFormat, int mode, int size, boolean crumbling, boolean depth, Runnable onEnable, Runnable onDisable)
    {
        super(name, vertexFormat, mode, size, crumbling, depth, onEnable, onDisable);
        throw new IllegalStateException();
    }

    public static RenderType getBioluminescent()
    {
        return BIOLUMINESCENT;
    }

    static
    {
        BIOLUMINESCENT = makeType("bioluminescent", DefaultVertexFormats.BLOCK, 7, 131072, true, false, RenderType.State.getBuilder()
                .shadeModel(SHADE_ENABLED)
                .lightmap(LIGHTMAP_DISABLED)
                .texture(BLOCK_SHEET)
                .alpha(HALF_ALPHA)
                .cull(CULL_DISABLED)
                .build(true));
    }

}
