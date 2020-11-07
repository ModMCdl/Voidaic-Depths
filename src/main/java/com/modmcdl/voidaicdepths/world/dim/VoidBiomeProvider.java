package com.modmcdl.voidaicdepths.world.dim;

import com.modmcdl.voidaicdepths.init.VoidaicBiomes;
import com.modmcdl.voidaicdepths.world.gen.noise.VoronoiNoiseGenerator;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraftforge.fml.RegistryObject;

import java.util.*;

public class VoidBiomeProvider extends BiomeProvider
{

    private VoronoiNoiseGenerator biomeNoise;
    double biomeSize = 32.0d;

    private static final Set<Biome> voidBiomeList = new HashSet<>();

    private Random rand;

    public VoidBiomeProvider(VoidBiomeProviderSettings settings) {
        super(voidBiomeList);
        this.biomeNoise = new VoronoiNoiseGenerator();
        this.biomeNoise.setNoiseSeed((int) settings.getSeed());
        //Adds biomes from list BIOMES to voidBiomeList
        VoidaicBiomes.BIOMES.getEntries().stream().map(RegistryObject::get).forEach(biome -> {voidBiomeList.add(biome);});
    }



    @Override
    public Biome getNoiseBiome(int x, int y, int z)
    {
        return getVoidBiome(new LinkedList<Biome>(voidBiomeList), biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z /biomeSize));
    }

    public Biome getVoidBiome(List<Biome> voidBiomeList, double noiseVal)
    {
        for (int i = voidBiomeList.size(); i >= 0; i--)
        {
            if (noiseVal > (2.0F / voidBiomeList.size()) * i - 1)
                return voidBiomeList.get(i);
        }
        return voidBiomeList.get(voidBiomeList.size() - 1);
    }
}
