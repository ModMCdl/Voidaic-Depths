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
    public static final Item ARCANE_SALT = create("arcane_salt", new Item(group()));
    public static final Item VOID_ESSENCE = create("void_essence", new Item(group()));
    public static final Item VOID_CRYSTAL = create("void_crystal", new Item(group()));
    public static final Item ATTUNED_ENDER_PEARL = create("attuned_ender_pearl", new Item(group()));

    public static final Item VOID_INGOT = create("void_ingot", new Item(group()));
    public static final Item VOID_NUGGET = create("void_nugget", new Item(group()));

    public static final Item TRANSLOCATION_STAFF = create("staff_of_translocation", new Item(group()));
    public static final Item VOID_GOGGLES = create("void_goggles", new Item(group()));

    public static void register()
    {
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }

    private static <T extends Item> T create(String name, T item)
    {
        ITEMS.put(item, new Identifier(VoidaicDepths.MOD_ID, name));
        return item;
    }

    public static Item.Settings group()
    {
        return new Item.Settings().group(VoidaicDepths.VD_GROUP);
    }
}

