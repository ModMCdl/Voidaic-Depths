package com.modmcdl.voidaicdepths.items;

import javafx.scene.effect.Effect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class VoidGoggles extends ArmorItem
{

    public VoidGoggles(IArmorMaterial material, EquipmentSlotType slotType, Properties properties)
    {
        super(material, slotType, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        if(player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof VoidGoggles)
        {
            player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 220, 0, false, false));
        }
    }


}
