package net.sylve.voidaicdepths.core;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sylve.voidaicdepths.VoidaicDepths;

public class VoidaicSounds
{
    public static SoundEvent THE_VOID_DISC = registerSoundEvent("the_void_music_disc");
    public static SoundEvent REMNANTS_DISC = registerSoundEvent("remnants_music_disc");
    public static SoundEvent OSSIFY_DISC = registerSoundEvent("ossify_music_disc");



    private static SoundEvent registerSoundEvent(String name)
    {
        Identifier id = new Identifier(VoidaicDepths.MODID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
