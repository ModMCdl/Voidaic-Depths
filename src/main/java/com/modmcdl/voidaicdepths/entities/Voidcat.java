package com.modmcdl.voidaicdepths.entities;

import com.modmcdl.voidaicdepths.init.VoidaicBlocks;
import com.modmcdl.voidaicdepths.init.VoidaicMobs;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Voidcat extends AnimalEntity
{
    public static final Ingredient LURES = Ingredient.fromItems(VoidaicBlocks.VOID_BULB.get().asItem(), VoidaicBlocks.NIGHTBLOOM.get().asItem(), VoidaicBlocks.VOIDSHROOM.get().asItem());

    public Voidcat(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
    }

    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, LURES, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    }

    public static boolean canVoidcatSpawn(EntityType<? extends AnimalEntity> animal, IWorld world, SpawnReason spawnReason, BlockPos blockPos, Random rand)
    {
        BlockPos blockpos = blockPos.down();
        return world.getBlockState(blockpos).canEntitySpawn(world, blockpos, animal);
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity)
    {
        return VoidaicMobs.VOIDCAT.get().create(this.world);
    }
}
