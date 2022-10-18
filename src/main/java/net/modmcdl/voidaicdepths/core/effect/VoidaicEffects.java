package net.modmcdl.voidaicdepths.core.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.modmcdl.voidaicdepths.VoidaicDepths;

public class VoidaicEffects
{
    public static StatusEffect VOIDSEER;

    public static StatusEffect registerStatusEffect(String name)
    {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(VoidaicDepths.MODID, name),
                new VoidseerEffect(StatusEffectCategory.BENEFICIAL, 15382271));
    }

    public static void registerEffects()
    {
        VOIDSEER = registerStatusEffect("voidseer");
    }
}
