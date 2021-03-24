package com.modmcdl.voidaicdepths.world.feature;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.Random;
import java.util.function.Function;

public class VoidStalkFeature extends Feature<ProbabilityConfig>
{
    private static final BlockState STALK_BASE;
    private static final BlockState STALK_BULB;

    public VoidStalkFeature(Function<Dynamic<?>, ? extends ProbabilityConfig> dynamicFunction)
    {
        super(dynamicFunction);
    }

    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> chunkGen, Random random, BlockPos pos, ProbabilityConfig probabilityConfig)
    {
        int i = 0;
        BlockPos.Mutable pos1 = new BlockPos.Mutable(pos);
        BlockPos.Mutable pos2 = new BlockPos.Mutable(pos);
        if (world.isAirBlock(pos1))
        {
            if (VoidaicBlocks.VOID_STALK_STEM.get().getDefaultState().isValidPosition(world, pos1))
            {
                int posY = random.nextInt(2) + 5;
                int hieghtY;
                if (random.nextFloat() < probabilityConfig.probability)
                {
                    hieghtY = random.nextInt(4) + 1;

                    for(int posX = pos.getX() - hieghtY; posX <= pos.getX() + hieghtY; ++posX)
                    {
                        for(int posZ = pos.getZ() - hieghtY; posZ <= pos.getZ() + hieghtY; ++posZ)
                        {
                            int locationX = posX - pos.getX();
                            int locationZ = posZ - pos.getZ();
                            if (locationX * locationX + locationZ * locationZ <= hieghtY * hieghtY)
                            {
                                pos2.setPos(posX, world.getHeight(Heightmap.Type.WORLD_SURFACE, posX, posZ) - 1, posZ);
                                if (isDirt(world.getBlockState(pos2).getBlock()))
                                {
                                    world.setBlockState(pos2, VoidaicBlocks.OVERGROWN_VOIDSTONE.get().getDefaultState(), 2);
                                }
                            }
                        }
                    }
                }

                for(hieghtY = 0; hieghtY < posY && world.isAirBlock(pos1); ++hieghtY)
                {
                    world.setBlockState(pos1, STALK_BASE, 2);
                    pos1.move(Direction.UP, 1);
                }

                if (pos1.getY() - pos.getY() >= 3)
                {
                    world.setBlockState(pos1, STALK_BULB, 2);
                    world.setBlockState(pos1.move(Direction.DOWN, 1), STALK_BASE, 2);
                    world.setBlockState(pos1.move(Direction.DOWN, 1), STALK_BASE, 2);
                }
            }

            ++i;
        }

        return i > 0;
    }

    static
    {
        STALK_BASE = (BlockState)((BlockState)((BlockState) VoidaicBlocks.VOID_STALK_STEM.get().getDefaultState()));
        STALK_BULB = (BlockState)((BlockState)((BlockState) VoidaicBlocks.VOID_STALK_BLOSSOM.get().getDefaultState()));
    }
}
