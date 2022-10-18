package net.modmcdl.voidaicdepths;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.modmcdl.voidaicdepths.core.VoidaicBlocks;
import net.modmcdl.voidaicdepths.core.VoidaicItems;
import net.modmcdl.voidaicdepths.core.effect.VoidaicEffects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoidaicDepths implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MODID = "voidaicdepths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final ItemGroup VDITEMGROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "main"), () -> new ItemStack(VoidaicBlocks.VOID_LANTERN.asItem()));

	@Override
	public void onInitialize()
	{
		VoidaicItems.registerVoidItems();
		VoidaicBlocks.registerVoidBlocks();

		VoidaicEffects.registerEffects();
	}
}
