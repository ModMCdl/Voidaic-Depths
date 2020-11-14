package com.modmcdl.voidaicdepths.util;



import net.minecraft.entity.Entity;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.Random;
import java.util.function.Function;


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
        return repositionEntity.apply(false);
    }
}
