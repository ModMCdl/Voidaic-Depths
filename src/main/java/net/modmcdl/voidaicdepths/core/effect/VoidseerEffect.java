package net.modmcdl.voidaicdepths.core.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.FluidTags;
import net.modmcdl.voidaicdepths.core.VoidaicItems;

public class VoidseerEffect extends StatusEffect
{
    protected VoidseerEffect(StatusEffectCategory statusEffectCategory, int color)
    {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return super.canApplyUpdateEffect(duration, amplifier);
    }
}
