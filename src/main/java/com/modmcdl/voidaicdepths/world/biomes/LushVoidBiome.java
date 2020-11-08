package com.modmcdl.voidaicdepths.world.biomes;

import com.modmcdl.voidaicdepths.init.VoidaicFeatures;
import com.modmcdl.voidaicdepths.world.biomes.decorators.VoidDecorator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class LushVoidBiome extends Biome
{
    public LushVoidBiome(Builder biomeBuilder)
    {
        super(biomeBuilder);
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.2F)));
        VoidDecorator.addVoidWeeds(this);
        VoidDecorator.addVoidBulbs(this);
        VoidDecorator.addTwistedShrubs(this);
        VoidDecorator.addVoidStalks(this);
    }



    //Sky Should be black
    public int getSkyColor()
    {
        return 0;
    }
}

