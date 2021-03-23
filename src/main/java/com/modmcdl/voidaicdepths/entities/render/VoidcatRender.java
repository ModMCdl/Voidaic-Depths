package com.modmcdl.voidaicdepths.entities.render;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.entities.Voidcat;
import com.modmcdl.voidaicdepths.entities.model.VoidcatModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class VoidcatRender extends MobRenderer<Voidcat, VoidcatModel<Voidcat>>
{

    protected static final ResourceLocation VOIDCAT_TEXTURE = new ResourceLocation(VoidaicDepths.MODID, "textures/entities/voidcat.png");

    public VoidcatRender(EntityRendererManager rendererManager)
    {
        super(rendererManager, new VoidcatModel<Voidcat>(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(Voidcat entity)
    {
        return VOIDCAT_TEXTURE;
    }
}
