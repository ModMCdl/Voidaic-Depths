package com.modmcdl.voidaicdepths.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class SparseVoidBiome extends Biome
{
    public SparseVoidBiome(Builder biomeBuilder)
    {
        super(biomeBuilder);
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.2F)));
    }

    //Sky Should be black
    public int getSkyColor()
    {
        return 0;
    }
}

