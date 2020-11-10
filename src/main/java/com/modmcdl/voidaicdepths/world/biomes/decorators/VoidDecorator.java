package com.modmcdl.voidaicdepths.world.biomes.decorators;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.modmcdl.voidaicdepths.world.feature.VoidStalkFeature;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class VoidDecorator
{
    public static final BlockState VOID_WEEDS = VoidaicBlocks.VOID_WEEDS.get().getDefaultState();
    public static final BlockClusterFeatureConfig VOID_WEED_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(VOID_WEEDS), new SimpleBlockPlacer())).tries(4).build();
    public static final BlockState VOID_BULBS = VoidaicBlocks.VOID_BULB.get().getDefaultState();
    public static final BlockClusterFeatureConfig VOID_BULB_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(VOID_BULBS), new SimpleBlockPlacer())).tries(4).build();
    public static final BlockState TWISTED_SHRUBS = VoidaicBlocks.TWISTED_SHRUB.get().getDefaultState();
    public static final BlockClusterFeatureConfig TWISTED_SHRUB_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TWISTED_SHRUBS), new SimpleBlockPlacer())).tries(4).build();



    public static final Feature<ProbabilityConfig> VOID_STALK = (new VoidStalkFeature(ProbabilityConfig::deserialize));

    public static void addVoidWeeds(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(VOID_WEED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
    }

    public static void addVoidBulbs(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(VOID_BULB_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
    }

    public static void addTwistedShrubs(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TWISTED_SHRUB_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(35))));
    }

    public static void addVoidStalks(Biome biomeIn)
    {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, VOID_STALK.withConfiguration(new ProbabilityConfig(0.0F)).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(50))));
    }



}
