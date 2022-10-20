package net.modmcdl.voidaicdepths.core.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
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

public class TranslocationStaff extends Item
{
    public TranslocationStaff(Settings settings)
    {
        super(settings);
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient)
    {
        return ingredient.isOf(VoidaicItems.ATTUNED_ENDER_PEARL);
    }
    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient() && hand == Hand.MAIN_HAND && !user.hasVehicle() && isUsable(itemStack)) {

            double d = user.getX();
            double e = user.getY();
            double f = user.getZ();
            float yaw = user.getYaw();

            float y1 = MathHelper.cos(-yaw * 0.017453292F - 3.1415927F); //cos 180 = 1
            float y2 = MathHelper.sin(-yaw * 0.017453292F - 3.1415927F); //sin 180 = 0

            for(int i = 0; i < 16; ++i) {
                double g = user.getX() + (-y2 * 16.0);
                double h = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16)), (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1));
                double j = user.getZ() + (-y1 * 16.0);

                Vec3d vec3d = user.getPos();
                if (user.teleport(g, h, j, true)) {
                    world.emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(user));
                    SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    user.playSound(soundEvent, 1.0F, 1.0F);

                    ((PlayerEntity)user).getItemCooldownManager().set(this, 15);
                    user.incrementStat(Stats.USED.getOrCreateStat(this));

                    if(!user.getAbilities().creativeMode)
                    {
                        itemStack.damage(1, user, (p) -> {
                            p.sendToolBreakStatus(hand);
                        });
                    }
                    break;
                }
            }
        }

        return super.use(world, user, hand);
    }
}
