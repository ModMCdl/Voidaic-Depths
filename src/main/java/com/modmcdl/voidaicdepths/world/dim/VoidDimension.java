package com.modmcdl.voidaicdepths.world.dim;

import com.modmcdl.voidaicdepths.world.gen.VoidChunkGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.EndGenerationSettings;

import javax.annotation.Nullable;

public class VoidDimension extends Dimension
{
    public VoidDimension(World world, DimensionType type)
    {
        super(world, type, 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator()
    {
        return new VoidChunkGenerator(world, new VoidBiomeProvider(new VoidBiomeProviderSettings(world.getWorldInfo())), new VoidGenerationSettings());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid)
    {
        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid)
    {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.5F;
    }

    @Override
    public boolean isSurfaceWorld()
    {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks)
    {
        int i = 7933291;
        float f = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        float f1 = 0.627451F;
        float f2 = 0.5019608F;
        float f3 = 0.627451F;
        f1 = f1 * (f * 0.0F + 0.15F);
        f2 = f2 * (f * 0.0F + 0.15F);
        f3 = f3 * (f * 0.0F + 0.15F);

        return new Vec3d((double)f1, (double)f2, (double)f3);
    }

    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z)
    {
        return false;
    }

    @Nullable
    @Override
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) { return null; }


}
