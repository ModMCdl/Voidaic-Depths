package com.modmcdl.voidaicdepths.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.world.biomes.LushVoidBiome;
import com.modmcdl.voidaicdepths.world.biomes.SparseVoidBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VoidaicBiomes
{

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, VoidaicDepths.MODID);

    public static final RegistryObject<Biome> SPARSE_VOID = BIOMES.register("sparse_void", () -> new SparseVoidBiome(new Biome.Builder()
            .surfaceBuilder(SurfaceBuilder.DEFAULT,
                    new SurfaceBuilderConfig(
                            VoidaicBlocks.VOIDSTONE.get().getDefaultState(),
                            VoidaicBlocks.VOIDSTONE.get().getDefaultState(),
                            VoidaicBlocks.VOIDSTONE.get().getDefaultState()
                    )
            )
            .category(Biome.Category.DESERT)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.5F)
            .downfall(0.5F)
            .parent((String)null)
            .waterColor(1638437).waterFogColor(1638437)
            .precipitation(Biome.RainType.NONE)));

    public static final RegistryObject<Biome> LUSH_VOID = BIOMES.register("lush_void", () -> new LushVoidBiome(new Biome.Builder()
            .surfaceBuilder(SurfaceBuilder.DEFAULT,
                    new SurfaceBuilderConfig(
                            VoidaicBlocks.OVERGROWN_VOIDSTONE.get().getDefaultState(),
                            VoidaicBlocks.VOIDSTONE.get().getDefaultState(),
                            VoidaicBlocks.VOIDSTONE.get().getDefaultState()
                    )
            )
            .category(Biome.Category.DESERT)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(0.5F)
            .downfall(0.5F)
            .parent((String)null)
            .waterColor(1638437).waterFogColor(1638437)
            .precipitation(Biome.RainType.NONE)));



    public static void registerBiomes()
    {
        addBiomeToDictionary(SPARSE_VOID.get(), BiomeDictionary.Type.END);
        addBiomeToDictionary(LUSH_VOID.get(), BiomeDictionary.Type.END);
    }

    //Add biome to dictionary
    public static void addBiomeToDictionary(Biome biome, BiomeDictionary.Type... types)
    {
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 0));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }


}
