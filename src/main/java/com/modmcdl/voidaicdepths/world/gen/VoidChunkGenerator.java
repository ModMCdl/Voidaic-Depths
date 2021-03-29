package com.modmcdl.voidaicdepths.world.gen;

import com.modmcdl.voidaicdepths.world.dim.VoidGenerationSettings;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class VoidChunkGenerator extends NoiseChunkGenerator<VoidGenerationSettings>
{

    public final BlockPos spawnPoint;

    public VoidChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, VoidGenerationSettings settingsIn) {
        super(worldIn, biomeProviderIn, 8, 4, 128, settingsIn, true);
        this.spawnPoint = settingsIn.getSpawnPos();
    }

    protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
        double d0 = 3370.0D;
        double d1 = 700.0D;
        double d2 = 50.0D;
        double d3 = 10.0D;
        int i = 64;
        int j = -3000;
        this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, d0, d1, d2, d3, i, j);
    }

    protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
        return new double[]{(double)this.biomeProvider.func_222365_c(noiseX, noiseZ), 0.0D};
    }

    protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
        return 8.0D - p_222545_1_;
    }

    protected double func_222551_g() {
        return (double)((int)super.func_222551_g() / 2);
    }

    protected double func_222553_h() {
        return 8.0D;
    }

    public int getGroundHeight() {
        return 50;
    }

    public int getSeaLevel() {
        return 0;
    }

}

