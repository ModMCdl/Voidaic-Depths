package com.modmcdl.voidaicdepths.util;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.modmcdl.voidaicdepths.init.VoidaicDimensions;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;
import org.apache.logging.log4j.core.jmx.Server;

public class VoidTeleporter2
{
    public static final VoidTeleporter2 VOID_TELEPORTER = new VoidTeleporter2();

    public VoidTeleporter2(){
    }

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

        if (dimensionType == DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE)) {
            Vec3d repositionedPos = new Vec3d(newPos.getX() + 0.5, newPos.getY(), newPos.getZ() + 0.5);
            Entity repositionedEntity = this.repositionEntity(entity, world, repositionedPos);
            repositionedEntity.fallDistance = 0.0F;

            int i = MathHelper.floor(newPos.getX());
            int j = MathHelper.floor(newPos.getY()) - 1;
            int k = MathHelper.floor(newPos.getZ());
            int l = 1;
            int i1 = 0;

            for (int j1 = -2; j1 <= 2; ++j1) {
                for (int k1 = -2; k1 <= 2; ++k1) {
                    for (int l1 = -1; l1 < 3; ++l1) {
                        int i2 = i + k1 * 1 + j1 * 0;
                        int j2 = j + l1;
                        int k2 = k + k1 * 0 - j1 * 1;
                        boolean flag = l1 < 0;
                        world.setBlockState(new BlockPos(i2, j2, k2), flag ? VoidaicBlocks.VOIDSTONE.get().getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        else if (dimensionType == DimensionType.OVERWORLD) {
            Vec3d repositionedPos = new Vec3d(newPos.getX() + 0.5, surface, newPos.getZ() + 0.5);
            Entity repositionedEntity = this.repositionEntity(entity, world, repositionedPos);
            repositionedEntity.fallDistance = 0.0F;
        }
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
