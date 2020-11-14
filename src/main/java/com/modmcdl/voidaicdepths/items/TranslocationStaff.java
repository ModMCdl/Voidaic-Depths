package com.modmcdl.voidaicdepths.items;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.util.VoidTeleporter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;


public class TranslocationStaff extends Item
    {


        public TranslocationStaff(Properties properties)
        {
            super(properties);
        }



        @Override
        public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
        {
           /* BlockPos blockpos;
            DimensionType dimensiontype = player.dimension;
            ServerWorld serverworld = player.getServer().getWorld(dimensiontype); */

           if (!world.isRemote)
           {
              /* if (dimensiontype == DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE))
               {
                   blockpos = serverworld.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, serverworld.getSpawnPoint());
               }*/

               player.changeDimension(world.dimension.getType() == DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE) ? DimensionType.OVERWORLD : DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE), new VoidTeleporter((ServerWorld) player.getEntityWorld()));
           }

           return super.onItemRightClick(world, player, hand);
        }

        @Override
        public boolean hasEffect(ItemStack stack)
        { return true; }

    }

