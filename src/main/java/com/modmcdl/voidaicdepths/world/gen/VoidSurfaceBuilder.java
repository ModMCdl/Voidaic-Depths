package com.modmcdl.voidaicdepths.world.gen;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class VoidSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>
{
    public VoidSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function)
    {
        super(function);
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config)
    {
        Random rand = new Random();
        int i = rand.nextInt(3);
        if (i == 0)
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(VoidaicBlocks.VOIDSTONE.get().getDefaultState(), VoidaicBlocks.VOIDSTONE.get().getDefaultState(), VoidaicBlocks.VOIDSTONE.get().getDefaultState()));
        else
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(i == 1 ? VoidaicBlocks.VOIDSTONE.get().getDefaultState() : VoidaicBlocks.VOIDSTONE.get().getDefaultState(), VoidaicBlocks.VOIDSTONE.get().getDefaultState(), VoidaicBlocks.VOIDSTONE.get().getDefaultState()));

    }
}
