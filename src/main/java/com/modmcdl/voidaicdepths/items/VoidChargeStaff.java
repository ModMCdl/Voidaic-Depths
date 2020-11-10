package com.modmcdl.voidaicdepths.items;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;


public class VoidChargeStaff extends Item
    {
        public VoidChargeStaff(Properties properties)
        {
            super(properties);
        }

        public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, BlockPos pos, Hand hand)
        {
            if (!world.isRemote)
            {
                if (world.getBlockState(pos).getBlock() != Blocks.AIR)
                {
                    world.destroyBlock(pos, false);
                }
            }

           return super.onItemRightClick(world, player, hand);
        }

        @Override
        public boolean hasEffect(ItemStack stack)
        { return true; }

    }

