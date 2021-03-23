package com.modmcdl.voidaicdepths.entities.model;

import com.modmcdl.voidaicdepths.entities.Voidcat;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class VoidcatModel<T extends Voidcat> extends EntityModel<T>
{
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer body_rotation;
    private final ModelRenderer legRightBack;
    private final ModelRenderer legLegBack;
    private final ModelRenderer legRightFront;
    private final ModelRenderer legLeftFront;
    private final ModelRenderer tail;
    private final ModelRenderer tail_rotation;

    public VoidcatModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(1.0F, 16.5F, -3.0F);
        setRotationAngle(head, 0.0F, 0.0436F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-5.0F, -2.0F, -6.0F, 8.0F, 8.0F, 7.0F, 0.0F, false);
        head.setTextureOffset(8, 32).addBox(1.0F, -5.0F, -4.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 32).addBox(-4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(18, 15).addBox(-3.0F, -1.0F, -7.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 7.5F, 3.5F);


        body_rotation = new ModelRenderer(this);
        body_rotation.setRotationPoint(0.0F, 9.0F, -0.5F);
        body.addChild(body_rotation);
        setRotationAngle(body_rotation, 1.5708F, 0.0F, 0.0F);
        body_rotation.setTextureOffset(0, 15).addBox(-3.0F, -5.0F, -5.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);

        legRightBack = new ModelRenderer(this);
        legRightBack.setRotationPoint(5.0F, 17.5F, 7.0F);
        legRightBack.setTextureOffset(30, 10).addBox(-8.001F, 2.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        legLegBack = new ModelRenderer(this);
        legLegBack.setRotationPoint(1.0F, 17.5F, 7.0F);
        legLegBack.setTextureOffset(30, 4).addBox(0.001F, 2.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        legRightFront = new ModelRenderer(this);
        legRightFront.setRotationPoint(5.0F, 17.5F, 0.0F);
        legRightFront.setTextureOffset(28, 18).addBox(-8.001F, 2.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        legLeftFront = new ModelRenderer(this);
        legLeftFront.setRotationPoint(1.0F, 17.5F, 0.0F);
        legLeftFront.setTextureOffset(23, 0).addBox(0.001F, 2.5F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(4.0F, 13.0F, 10.0F);


        tail_rotation = new ModelRenderer(this);
        tail_rotation.setRotationPoint(-4.0F, 3.5F, -0.5F);
        tail.addChild(tail_rotation);
        setRotationAngle(tail_rotation, 1.5708F, 0.0F, 0.0F);
        tail_rotation.setTextureOffset(24, 24).addBox(-2.0F, -0.5F, -2.5F, 4.0F, 9.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI /180F);
        this.legRightBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legLegBack.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legRightFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legLeftFront.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legRightBack.render(matrixStack, buffer, packedLight, packedOverlay);
        legLegBack.render(matrixStack, buffer, packedLight, packedOverlay);
        legRightFront.render(matrixStack, buffer, packedLight, packedOverlay);
        legLeftFront.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
