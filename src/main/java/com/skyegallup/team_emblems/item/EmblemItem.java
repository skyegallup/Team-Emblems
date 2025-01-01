package com.skyegallup.team_emblems.item;

import com.skyegallup.team_emblems.util.TeamUtilities;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EmblemItem extends TrinketItem {
    public EmblemItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        if (hasTeamName(stack)) {
            Text text = Text.translatable("tooltip.team_emblems.team_name_set", getTeamName(stack))
                .formatted(Formatting.DARK_GRAY);
            tooltip.add(text);
        } else {
            Text text = Text.translatable("tooltip.team_emblems.team_name_unset", getTeamName(stack))
                .formatted(Formatting.DARK_GRAY);
            tooltip.add(text);
        }
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        // Set player's team
        if (hasTeamName(stack)) {
            TeamUtilities.addToTeam(entity, getTeamName(stack));
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        // Remove player's team
        if (hasTeamName(stack)) {
            TeamUtilities.removeFromTeam(entity, getTeamName(stack));
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);

        // Create and set team
        Team team = TeamUtilities.createNewTeam(world);
        NbtCompound nbt = stack.getOrCreateNbt();
        nbt.putString("team_name", team.getName());
    }

    private static String getTeamName(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        return nbt.getString("team_name");
    }

    private static boolean hasTeamName(ItemStack stack) {
        return !getTeamName(stack).isEmpty();
    }
}
