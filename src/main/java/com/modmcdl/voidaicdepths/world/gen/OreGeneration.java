package com.modmcdl.voidaicdepths.world.gen;

import com.modmcdl.voidaicdepths.init.VoidaicBiomes;
import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
    public static void generateOre()
    {
        for (Biome biome : ForgeRegistries.BIOMES)
        {
            if (biome == VoidaicBiomes.SPARSE_VOID.get() || biome == VoidaicBiomes.LUSH_VOID.get())
            {
                ConfiguredPlacement orePlacement = Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 5, 5, 64));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        Feature.ORE.withConfiguration(new OreFeatureConfig(customFillerBlockType.VOIDSTONE_FILLER, VoidaicBlocks.VOID_ORE.get().getDefaultState(), 10)).withPlacement(orePlacement));
            }
        }
    }

    public static class customFillerBlockType
    {
        public static final OreFeatureConfig.FillerBlockType VOIDSTONE_FILLER = OreFeatureConfig.FillerBlockType.create("VoidstoneFiller", "voidstone", new BlockMatcher(VoidaicBlocks.VOIDSTONE.get()));
    }

}
