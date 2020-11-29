package com.modmcdl.voidaicdepths.util;



import com.modmcdl.voidaicdepths.VoidaicDepths;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Function;

//defunct
public class VoidTeleporter implements ITeleporter
{
        protected final ServerWorld world;
        protected final Random random;

        public VoidTeleporter(ServerWorld worldIn) {
            this.world = worldIn;
            this.random = new Random(worldIn.getSeed());
        }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity)
    {
        BlockPos pos;

        if(destWorld.dimension.getType() == DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE))
        {
            pos = destWorld.getSpawnCoordinate();
        }
        else if(destWorld.dimension.getType() == DimensionType.OVERWORLD)
        {
            pos = destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, destWorld.getSpawnPoint());
        }
        return repositionEntity.apply(false);
    }
}
