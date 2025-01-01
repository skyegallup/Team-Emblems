package com.skyegallup.team_emblems.recipes;

import com.skyegallup.team_emblems.item.ModItems;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class EmblemCraftRecipe extends SpecialCraftingRecipe {
    public EmblemCraftRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        if (inventory.getWidth() == 3 && inventory.getHeight() == 3) {
            return inventory.getStack(1).isOf(Items.COPPER_INGOT)
                && inventory.getStack(3).isOf(Items.COPPER_INGOT)
                && inventory.getStack(4).isOf(Items.WHITE_WOOL)
                && inventory.getStack(5).isOf(Items.COPPER_INGOT)
                && inventory.getStack(7).isOf(Items.COPPER_INGOT);
        } else {
            return false;
        }
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        // Create new team for item
        //Team team = TeamUtilities.createNewTeam()

        // Create and return item
        ItemStack itemStack = new ItemStack(ModItems.EMBLEM, 1);
        //itemStack.setNbt();
        return itemStack;
    }

    @Override
    public boolean fits(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.EMBLEM_CRAFT;
    }
}
