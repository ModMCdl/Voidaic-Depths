package com.modmcdl.voidaicdepths.world.feature.structures;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;
import java.util.function.Function;

public class VoidWellStructure extends Structure<NoFeatureConfig>
{
    public VoidWellStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config)
    {
        super(config);
    }

    @Override
    //Can be generated?
    public boolean canBeGenerated(BiomeManager biomeManager, ChunkGenerator<?> chunkGenerator, Random random, int posX, int posZ, Biome biome)
    {
        ChunkPos pos = this.getStartPositionForPosition(chunkGenerator, random, posX, posZ, 0, 0);

        if(posX == pos.x && posZ == pos.z)
        {
          if(chunkGenerator.hasStructure(biome, this)) //if biome has structure then true
          {
              return true;
          }
        }

        return false;
    }

    public static class Start extends StructureStart
    {
        public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed)
        {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn)
        {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            //ByteWise find center of chunk and surface
            int x = (chunkX << 4) + 7;
            int z = (chunkX << 4) + 7;
            int y = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos pos = new BlockPos(x, y, z);

            VoidWellPieces.start(templateManagerIn, pos, rotation, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }

    @Override
    public IStartFactory getStartFactory()
    {
        return VoidWellStructure.Start::new;
    }


    @Override
    public String getStructureName()
    {
        return VoidaicDepths.MODID + ":void_well";
    }

    @Override
    protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int posX, int posZ, int offsetX, int offsetZ)
    {
        int maxDistance = 10; //cannot be further away than
        int minDistance = 1; //cannot be closer than

        int xTemp = posX + maxDistance * offsetX;
        int ztemp = posZ + maxDistance * offsetZ;
        int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
        int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
        int validChunkX = xTemp2 / maxDistance;
        int validChunkZ = zTemp2 / maxDistance;

        ((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
        validChunkX = validChunkX * maxDistance;
        validChunkZ = validChunkZ * maxDistance;
        validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
        validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);

        return new ChunkPos(validChunkX, validChunkZ);
    }

    protected int getSeedModifier()
    {
        return 85185632;
    }

    //unused
    @Override
    public int getSize()
    {
        return 0;
    }
}
