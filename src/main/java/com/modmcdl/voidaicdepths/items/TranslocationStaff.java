package com.modmcdl.voidaicdepths.items;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.util.VoidTeleporter;
import com.modmcdl.voidaicdepths.util.VoidTeleporter2;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
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

            if(player.world instanceof ServerWorld)
            {
                VoidTeleporter2.VOID_TELEPORTER.voidTeleporter(player);
            }

            //OldScript
           /*if (!world.isRemote)
           {
               player.changeDimension(world.dimension.getType() == DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE) ? DimensionType.OVERWORLD : DimensionType.byName(VoidaicDepths.VOID_DIM_TYPE), new VoidTeleporter((ServerWorld) player.getEntityWorld()));
           }*/

           return super.onItemRightClick(world, player, hand);
        }

        @Override
        public boolean hasEffect(ItemStack stack)
        { return true; }

    }

