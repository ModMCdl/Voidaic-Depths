package com.modmcdl.voidaicdepths;

import com.modmcdl.voidaicdepths.init.*;
import com.modmcdl.voidaicdepths.world.gen.OreGeneration;
import com.modmcdl.voidaicdepths.world.gen.VoidStructureGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(VoidaicDepths.MODID)
@Mod.EventBusSubscriber(modid = VoidaicDepths.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoidaicDepths
{
    public static final String MODID = "voidaicdepths";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static VoidaicDepths instance;
    public static final ResourceLocation VOID_DIM_TYPE = new ResourceLocation(MODID, "the_void_depths");

    public VoidaicDepths()
    {
        LOGGER.debug("Loading Voidaic Depths..."); //Shouts welcome

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            modEventBus.addListener(this::setup);
            modEventBus.addListener(this::clientStart);

        VoidaicItems.ITEMS.register(modEventBus); //Register Item List
        VoidaicBlocks.BLOCKS.register(modEventBus); //Register Normal Block List
        //VoidaicBlocks.SPECIAL_BLOCKS.register(modEventBus); //Register Special Block List
        VoidaicBiomes.BIOMES.register(modEventBus); //Register Biome List
        VoidaicDimensions.DIMENSION.register(modEventBus); //Register Dim List
        VoidaicFeatures.FEATURES.register(modEventBus); //Register Features
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent //Create BlockItems for BLOCKS blocks
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();

        VoidaicBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
        {
            final Item.Properties properties = new Item.Properties().group(VoidaicItemGroup.VOIDTAB);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
        LOGGER.debug("BlockItems Registered for Voidaic Depths"); //Shouts success
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event)
    {
        VoidaicBiomes.registerBiomes();
        LOGGER.info("Registered biomes!");
    } //Register BIOMES

    @SubscribeEvent
    public static void loadEventComplete(FMLLoadCompleteEvent event)
    {
        OreGeneration.generateOre();
        VoidStructureGen.generateStructure();
    }


    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void clientStart(final FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.VOID_LANTERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.VOID_WEEDS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.VOID_BULB.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.NIGHTBLOOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.TWISTED_SHRUB.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.VOIDSHROOM.get(), RenderType.getCutout());;
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.VOID_STALK_STEM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(VoidaicBlocks.VOID_STALK_BLOSSOM.get(), RenderType.getTranslucent());
    }

    @SubscribeEvent
    public void serverStart(FMLServerStartingEvent event)
    {
        LOGGER.debug("Voidaic Depths started on server_env!");
    }

}
