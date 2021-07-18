package com.modmcdl.voidaicdepths;

import com.modmcdl.voidaicdepths.core.init.VoidaicBlocks;
import com.modmcdl.voidaicdepths.core.init.VoidaicItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class VoidaicDepths implements ModInitializer
{
	public static final String MOD_ID = "voidaicdepths";
	public static final ItemGroup VD_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main"), () -> new ItemStack(VoidaicBlocks.VOID_LANTERN.asItem()));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		VoidaicItems.register(); //Register Items
		VoidaicBlocks.register(); //Register Blocks

		System.out.println("Voidaic Depths checking in!");
	}
}
