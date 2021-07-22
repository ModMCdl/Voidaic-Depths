package com.modmcdl.voidaicdepths;

import com.modmcdl.voidaicdepths.core.init.VoidaicCompostableItems;
import com.modmcdl.voidaicdepths.core.init.VoidaicObjectRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class VoidaicDepths implements ModInitializer
{
	public static final String MOD_ID = "voidaicdepths";
	public static final ItemGroup VD_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main"), () -> new ItemStack(VoidaicObjectRegistry.VOID_LANTERN.asItem()));


	@Override
	public void onInitialize()
	{
		VoidaicObjectRegistry.registerObjects();
		VoidaicCompostableItems.compostableItemsList();

		System.out.println("Voidaic Depths checking in!");
	}
}
