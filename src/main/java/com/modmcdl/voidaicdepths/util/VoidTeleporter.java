package com.modmcdl.voidaicdepths.util;



import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.server.ServerWorld;

import java.util.function.Function;


public class VoidTeleporter extends Teleporter
{
    public VoidTeleporter(ServerWorld world)
    {
        super(world);
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity)
    {
        return repositionEntity.apply(false);
    }
}
