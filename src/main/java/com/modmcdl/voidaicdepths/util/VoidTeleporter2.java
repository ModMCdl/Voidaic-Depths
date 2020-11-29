package com.modmcdl.voidaicdepths.util;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.init.VoidaicDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;

public class VoidTeleporter2
{
    public static final VoidTeleporter2 VOID_TELEPORTER = new VoidTeleporter2();

    public VoidTeleporter2(){}

    public void voidTeleporter(Entity entity)
    {
        MinecraftServer minecraftServer = LogicalSidedProvider.INSTANCE.get(LogicalSide.SERVER);
        if(minecraftServer == null)
        {
            return;
        }
        DimensionType dimensionType = this.destinationDimension(entity.dimension);
        ServerWorld world = minecraftServer.getWorld(dimensionType);

        BlockPos pos = entity.getPosition();
        BlockPos newPos = new BlockPos(
                                        pos.getX() + world.rand.nextInt(15) - world.rand.nextInt(15),
                                        pos.getY(),
                                        pos.getZ() + world.rand.nextInt(15 - world.rand.nextInt(15)
                                        )
        );
        IChunk iChunk = world.getChunk(pos);
        int surface = iChunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, newPos.getX(), newPos.getZ()) +1;
        BlockPos surfacePos = new BlockPos(newPos.getX(), surface, newPos.getZ());

        Vec3d repositionedPos = new Vec3d(newPos.getX() + 0.5, surfacePos.getY(), newPos.getZ() + 0.5);
        Entity repositionedEntity = this.repositionEntity(entity, world, repositionedPos);
        repositionedEntity.fallDistance = 0.0F;

    }

    private Entity repositionEntity(Entity entity, ServerWorld serverWorld, Vec3d vec3d)
    {
        if(entity instanceof ServerPlayerEntity)
        {
            ServerPlayerEntity playerEntity = (ServerPlayerEntity) entity;
            playerEntity.teleport(serverWorld, vec3d.x, vec3d.y, vec3d.z, entity.rotationYaw, entity.rotationPitch);
            return playerEntity;
        }

        entity.detach(); entity.dimension = serverWorld.dimension.getType();
        Entity movedEntity = entity.getType().create(serverWorld);
        if(movedEntity == null) { return entity; }

        movedEntity.copyDataFromOld(entity);
        movedEntity.setLocationAndAngles(vec3d.x, vec3d.y, vec3d.z, entity.rotationYaw, entity.rotationPitch);
        movedEntity.setRotationYawHead(entity.rotationYaw);
        serverWorld.addFromAnotherDimension(movedEntity);
        entity.remove();
        return movedEntity;
    }

    private DimensionType destinationDimension(DimensionType dim)
    {
        return dim.getModType() == VoidaicDimensions.THE_VOID.get() ? DimensionType.OVERWORLD : DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE);
    }


}
