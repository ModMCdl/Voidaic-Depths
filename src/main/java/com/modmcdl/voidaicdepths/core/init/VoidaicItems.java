package com.modmcdl.voidaicdepths.core.init;

import com.modmcdl.voidaicdepths.VoidaicDepths;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;

public class VoidaicItems
{
    public static final LinkedHashMap<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //-- ITEM LIST --//
    public static final Item VOID_ESSENCE = create("void_essence", new Item(itemGroup()));


    public static void register()
    {
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }

    private static <T extends Item> T create(String name, T item)
    {
        ITEMS.put(item, new Identifier(VoidaicDepths.MOD_ID, name));
        return item;
    }

    public static Item.Settings itemGroup()
    {
        return new Item.Settings().group(VoidaicDepths.VD_GROUP);
    }
}

