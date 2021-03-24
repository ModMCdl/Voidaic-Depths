package com.modmcdl.voidaicdepths.world.gen;

import com.modmcdl.voidaicdepths.init.VoidaicBiomes;
import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.modmcdl.voidaicdepths.init.VoidaicFeatures;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class VoidStructureGen
{
    public static void generateStructure()
    {
        for (Biome biome : ForgeRegistries.BIOMES)
        {
            if (biome == VoidaicBiomes.LUSH_VOID.get())
            {
                biome.addStructure(VoidaicFeatures.VOID_WELL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, VoidaicFeatures.VOID_WELL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

        }
    }
}
