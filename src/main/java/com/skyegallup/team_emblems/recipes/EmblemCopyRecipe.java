package com.skyegallup.team_emblems.recipes;

import com.skyegallup.team_emblems.item.ModItems;
import com.skyegallup.team_emblems.tag.ModTags;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class EmblemCopyRecipe extends SpecialCraftingRecipe {
    public EmblemCopyRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        if (inventory.getWidth() == 3 && inventory.getHeight() == 3) {
            return inventory.getStack(1).isOf(Items.COPPER_INGOT)
                && inventory.getStack(3).isOf(Items.COPPER_INGOT)
                && inventory.getStack(4).isIn(ModTags.EMBLEMS)
                && inventory.getStack(5).isOf(Items.COPPER_INGOT)
                && inventory.getStack(7).isOf(Items.COPPER_INGOT);
        } else {
            return false;
        }
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        // Create a new item stack and duplicate the Emblem item
        ItemStack existingEmblemStack = inventory.getStack(4);
        return existingEmblemStack.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public DefaultedList<ItemStack> getRemainder(RecipeInputInventory inventory) {
        DefaultedList<ItemStack> remainder = super.getRemainder(inventory);
        remainder.set(4, inventory.getStack(4).copyWithCount(1));
        return remainder;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.EMBLEM_COPY;
    }
}
