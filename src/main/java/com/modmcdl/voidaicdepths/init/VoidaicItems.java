package com.modmcdl.voidaicdepths.init;


import com.modmcdl.voidaicdepths.VoidaicDepths;
import com.modmcdl.voidaicdepths.items.TranslocationStaff;
import com.modmcdl.voidaicdepths.items.VoidChargeStaff;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VoidaicItems
{

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, VoidaicDepths.MODID);

    public static final RegistryObject<Item> ARCANE_SALT = ITEMS.register("arcane_salt", () -> new Item(new Item.Properties().group(VoidaicItemGroup.VOIDTAB)));
    public static final RegistryObject<Item> VOID_ESSENCE = ITEMS.register("void_essence", () -> new Item(new Item.Properties().group(VoidaicItemGroup.VOIDTAB)));
    public static final RegistryObject<Item> VOID_CRYSTAL = ITEMS.register("void_crystal", () -> new Item(new Item.Properties().group(VoidaicItemGroup.VOIDTAB)));

    public static final RegistryObject<Item> VOID_STAR = ITEMS.register("void_star", () -> new SpecialRenderItem(new Item.Properties().group(VoidaicItemGroup.VOIDTAB)));
    public static final RegistryObject<Item> VOID_NUGGET = ITEMS.register("void_nugget", () -> new Item(new Item.Properties().group(VoidaicItemGroup.VOIDTAB)));
    public static final RegistryObject<Item> VOID_INGOT = ITEMS.register("void_ingot", () -> new Item(new Item.Properties().group(VoidaicItemGroup.VOIDTAB)));

    public static final RegistryObject<Item> TRANSLOCATION_STAFF = ITEMS.register("staff_of_translocation", () -> new TranslocationStaff(new Item.Properties().group(VoidaicItemGroup.VOIDTAB).maxStackSize(1)));
    public static final RegistryObject<Item> VOID_CHARGE_STAFF = ITEMS.register("staff_of_voidaic_charge", () -> new VoidChargeStaff(new Item.Properties().group(VoidaicItemGroup.VOIDTAB).maxStackSize(1)));


    //SpecialRenderItem w/ Enchantment glint
    public static class SpecialRenderItem extends Item
    { public SpecialRenderItem(Properties properties)
        { super(properties); }
        @Override
        public boolean hasEffect(ItemStack stack)
        { return true; }
    }

}
