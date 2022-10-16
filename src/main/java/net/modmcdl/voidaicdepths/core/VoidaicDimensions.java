package net.modmcdl.voidaicdepths.core;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.modmcdl.voidaicdepths.VoidaicDepths;

public class VoidaicDimensions
{
        private static final RegistryKey<DimensionOptions> DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION_KEY, new Identifier(VoidaicDepths.MODID, "void_dim"));
        public static RegistryKey<World> VOID_DIM_KEY = RegistryKey.of(Registry.WORLD_KEY, DIMENSION_KEY.getValue());
        private static final RegistryKey<DimensionType> DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier(VoidaicDepths.MODID, "void_dim_type"));

        public static void registerDimensions() {
                System.out.println("Registering Dimensions for " + VoidaicDepths.MODID);
        }
}
