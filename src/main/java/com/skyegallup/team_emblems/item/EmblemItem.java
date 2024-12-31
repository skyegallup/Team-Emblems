package com.skyegallup.team_emblems.item;

import com.skyegallup.team_emblems.TeamEmblems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class EmblemItem extends TrinketItem {
    public EmblemItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);
    }
}
