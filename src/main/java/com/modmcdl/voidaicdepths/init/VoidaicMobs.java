package com.modmcdl.voidaicdepths.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.entities.Voidcat;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VoidaicMobs
{

    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, VoidaicDepths.MODID);

    public static final RegistryObject<EntityType<Voidcat>> VOIDCAT = ENTITIES.register("voidcat", () -> EntityType.Builder.<Voidcat>
            create(Voidcat::new, EntityClassification.CREATURE)
            .size(1.0F, 1.0F)
            .build(new ResourceLocation(VoidaicDepths.MODID, "voidcat").toString()));

}
