package com.modmcdl.voidaicdepths.world.biomes;

import com.modmcdl.voidaicdepths.world.biomes.decorators.VoidDecorator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class HauntedVoidBiome extends Biome
{
    public HauntedVoidBiome(Builder biomeBuilder)
    {
        super(biomeBuilder);
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.1F)));
        VoidDecorator.addVoidshrooms(this);
        VoidDecorator.addVoidSandpits(this);

    }

    //Sky Should be black
    public int getSkyColor()
    {
        return 0;
    }
}

