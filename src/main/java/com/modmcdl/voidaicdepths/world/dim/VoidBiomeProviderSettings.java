package com.modmcdl.voidaicdepths.world.dim;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class VoidBiomeProviderSettings implements IBiomeProviderSettings
{
    private final long seed;
    private final WorldType worldType;
    private VoidGenerationSettings genSettings = new VoidGenerationSettings();

    public VoidBiomeProviderSettings(WorldInfo info)
    {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public VoidBiomeProviderSettings setGeneratorSettings(VoidGenerationSettings settings)
    {
        this.genSettings = settings;
        return this;
    }

    public long getSeed()
    {
        return this.seed;
    }

    public WorldType getWorldType()
    {
        return this.worldType;
    }

    public VoidGenerationSettings getGenSettings()
    {
        return this.genSettings;
    }


}
