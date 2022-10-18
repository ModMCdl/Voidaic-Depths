package net.modmcdl.voidaicdepths.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.modmcdl.voidaicdepths.VoidaicDepths;
import net.modmcdl.voidaicdepths.core.items.TranslocationStaff;
import net.modmcdl.voidaicdepths.core.items.VoidArmorMaterials;
import net.modmcdl.voidaicdepths.core.items.VoidGoggles;
import net.modmcdl.voidaicdepths.core.items.VoidMusicDisc;

public class VoidaicItems
{
    public static final Item ARCANE_SALT = registerItem("arcane_salt", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item VOID_ESSENCE = registerItem("void_essence", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item VOID_CRYSTAL = registerItem("void_crystal", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item ATTUNED_ENDER_PEARL = registerItem("attuned_ender_pearl", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item EYE_OF_THE_VOID = registerItem("eye_of_the_void", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).rarity(Rarity.EPIC)));

    public static final Item VOID_CARROT = registerItem("void_carrot", new AliasedBlockItem(VoidaicBlocks.VOID_CARROTS, new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).food(VoidaicFoods.VOID_CARROT)));
    public static final Item VOID_CARROT_STEW = registerItem("void_carrot_stew", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).food(VoidaicFoods.VOID_CARROT_STEW).maxCount(1)));

    public static final Item VOID_INGOT = registerItem("void_ingot", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item VOID_NUGGET = registerItem("void_nugget", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));

    public static final Item OSSIFICUM_INGOT = registerItem("ossificum_ingot", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item OSSIFICUM_SHARD = registerItem("ossificum_shard", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));

    public static final Item TRANSLOCATION_STAFF = registerItem("staff_of_translocation", new TranslocationStaff(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item VOIDAIC_CHARGE_STAFF = registerItem("staff_of_voidaic_charge", new Item(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));
    public static final Item VOID_GOGGLES = registerItem("void_goggles", new VoidGoggles(VoidArmorMaterials.GOGGLES, EquipmentSlot.HEAD, new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP)));

    public static final Item THE_VOID_MUSIC_DISC = registerItem("the_void_music_disc", new VoidMusicDisc(7, VoidaicSounds.THE_VOID_DISC, new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).maxCount(1).rarity(Rarity.RARE), 228));
    public static final Item REMNANTS_MUSIC_DISC = registerItem("remnants_music_disc", new VoidMusicDisc(7, VoidaicSounds.REMNANTS_DISC, new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).maxCount(1).rarity(Rarity.RARE), 215));
    public static final Item OSSIFY_MUSIC_DISC = registerItem("ossify_music_disc", new VoidMusicDisc(7, VoidaicSounds.OSSIFY_DISC, new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).maxCount(1).rarity(Rarity.RARE), 201));

    public static final Item UNDERWOOD_SIGN_ITEM = registerItem("underwood_sign", new SignItem(new FabricItemSettings().group(VoidaicDepths.VDITEMGROUP).maxCount(16), VoidaicBlocks.UNDERWOOD_SIGN, VoidaicBlocks.UNDERWOOD_WALL_SIGN));




    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(VoidaicDepths.MODID, name), item);
    }
    public static void registerVoidItems()
    {
        VoidaicDepths.LOGGER.info("Registering Voidaic Items: " + VoidaicDepths.MODID);
    }
}
