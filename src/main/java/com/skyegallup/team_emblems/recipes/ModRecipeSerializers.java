package com.skyegallup.team_emblems.recipes;

import com.skyegallup.team_emblems.TeamEmblems;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializers {
    public static final RecipeSerializer<EmblemCopyRecipe> EMBLEM_COPY = register("emblem_copy", new SpecialRecipeSerializer<>(EmblemCopyRecipe::new));

    public static void initialize() {
        // pass
    }

    public static <T extends Recipe<?>> RecipeSerializer<T> register(String id, RecipeSerializer<T> serializer) {
        return Registry.register(
            Registries.RECIPE_SERIALIZER,
            new Identifier(TeamEmblems.MOD_ID, id),
            serializer
        );
    }
}
