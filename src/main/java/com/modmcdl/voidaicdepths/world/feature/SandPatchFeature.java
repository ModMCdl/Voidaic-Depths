package com.modmcdl.voidaicdepths.world.feature;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureRadiusConfig;

import java.util.Random;
import java.util.function.Function;

public class SandPatchFeature extends Feature<FeatureRadiusConfig>
{

    private final Block block;

    public SandPatchFeature(Function<Dynamic<?>, ? extends FeatureRadiusConfig> function)
    {
        super(function);
        this.block = VoidaicBlocks.VOID_SAND.get();
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, FeatureRadiusConfig radiusConfig)
    {
        while(worldIn.isAirBlock(pos) && pos.getY() > 2) { pos = pos.down(); }
        if (worldIn.getBlockState(pos).getBlock() != VoidaicBlocks.VOIDSTONE.get()) { return false; }
        else {
            int lvt_6_1_ = rand.nextInt(radiusConfig.radius) + 2;

            for(int lvt_8_1_ = pos.getX() - lvt_6_1_; lvt_8_1_ <= pos.getX() + lvt_6_1_; ++lvt_8_1_) {
                for(int lvt_9_1_ = pos.getZ() - lvt_6_1_; lvt_9_1_ <= pos.getZ() + lvt_6_1_; ++lvt_9_1_) {
                    int lvt_10_1_ = lvt_8_1_ - pos.getX();
                    int lvt_11_1_ = lvt_9_1_ - pos.getZ();
                    if (lvt_10_1_ * lvt_10_1_ + lvt_11_1_ * lvt_11_1_ <= lvt_6_1_ * lvt_6_1_) {
                        for(int lvt_12_1_ = pos.getY() - 1; lvt_12_1_ <= pos.getY() + 1; ++lvt_12_1_) {
                            BlockPos lvt_13_1_ = new BlockPos(lvt_8_1_, lvt_12_1_, lvt_9_1_);
                            Block lvt_14_1_ = worldIn.getBlockState(lvt_13_1_).getBlock();
                            if (isDirt(lvt_14_1_) || lvt_14_1_ == VoidaicBlocks.VOIDSTONE.get() || lvt_14_1_ == Blocks.ICE) {
                                worldIn.setBlockState(lvt_13_1_, this.block.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
