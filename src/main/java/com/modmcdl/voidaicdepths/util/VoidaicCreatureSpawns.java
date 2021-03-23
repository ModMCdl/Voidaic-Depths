package com.modmcdl.voidaicdepths.util;


import com.modmcdl.voidaicdepths.init.VoidaicBiomes;
import com.modmcdl.voidaicdepths.init.VoidaicMobs;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;


public class VoidaicCreatureSpawns
{

    public static void creatureSpawnList()
    {
        for (Biome biome : ForgeRegistries.BIOMES)
        {
            if(biome == VoidaicBiomes.LUSH_VOID.get())
            {
                biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(VoidaicMobs.VOIDCAT.get(), 2, 2, 2));
            }
        }
    }

}
