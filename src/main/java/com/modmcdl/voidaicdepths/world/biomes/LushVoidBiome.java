package com.modmcdl.voidaicdepths.world.biomes;

import com.modmcdl.voidaicdepths.init.VoidaicMobs;
import com.modmcdl.voidaicdepths.world.biomes.decorators.VoidDecorator;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;


public class LushVoidBiome extends Biome
{
    public LushVoidBiome(Builder biomeBuilder)
    {
        super(biomeBuilder);
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.2F)));
        VoidDecorator.addVoidWeeds(this);
        VoidDecorator.addVoidBulbs(this);
        VoidDecorator.addNightblooms(this);
        VoidDecorator.addVoidshrooms(this);
        VoidDecorator.addTwistedShrubs(this);
        VoidDecorator.addVoidStalks(this);
    }



    //Sky Should be black
    public int getSkyColor()
    {
        return 0;
    }
}

