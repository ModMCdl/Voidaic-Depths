package com.modmcdl.voidaicdepths.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.world.feature.structures.VoidWellPieces;
import com.modmcdl.voidaicdepths.world.feature.structures.VoidWellStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = VoidaicDepths.MODID)
public class VoidaicFeatures
{
    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, VoidaicDepths.MODID);

    public static IStructurePieceType VOID_WELL_PIECE = VoidWellPieces.Piece::new;

    public static final RegistryObject<VoidWellStructure> VOID_WELL = FEATURES.register("void_well", () -> new VoidWellStructure(NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event)
    {
        Registry.register(Registry.STRUCTURE_PIECE, "VOID_WELL".toLowerCase(Locale.ROOT), VOID_WELL_PIECE);
    }
}
