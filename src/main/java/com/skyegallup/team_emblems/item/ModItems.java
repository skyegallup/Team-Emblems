package com.skyegallup.team_emblems.item;

import com.skyegallup.team_emblems.TeamEmblems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item EMBLEM = register("emblem", new EmblemItem(new Item.Settings().maxCount(1)));

    public static void initialize() {
        // pass
    }

    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TeamEmblems.MOD_ID, id), item);
    }
}
