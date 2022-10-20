package net.modmcdl.voidaicdepths.core.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.modmcdl.voidaicdepths.core.VoidaicItems;

public class VoidaicChargeStaff extends Item
{
    public VoidaicChargeStaff(Settings settings)
    {
        super(settings);
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient)
    {
        return ingredient.isOf(VoidaicItems.ATTUNED_ENDER_PEARL);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND && !user.hasVehicle()) {
            ItemStack itemStack = user.getStackInHand(hand);
            ItemStack voidCharge = VoidaicItems.EYE_OF_THE_VOID.getDefaultStack();
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            user.getItemCooldownManager().set(this, 20);
            if (!world.isClient) {
                EnderPearlEntity voidChargeProjectile = new EnderPearlEntity(world, user);
                voidChargeProjectile.setItem(voidCharge);
                voidChargeProjectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(voidChargeProjectile);
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if(!user.getAbilities().creativeMode)
            {
                itemStack.damage(1, user, (p) -> {
                    p.sendToolBreakStatus(hand);
                });
            }
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return super.use(world, user, hand);
    }
}
