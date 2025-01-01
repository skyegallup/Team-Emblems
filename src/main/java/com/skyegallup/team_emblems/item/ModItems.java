package com.skyegallup.team_emblems.item;

import com.skyegallup.team_emblems.TeamEmblems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item BLACK_EMBLEM = register("black_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item BLUE_EMBLEM = register("blue_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item BROWN_EMBLEM = register("brown_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item CYAN_EMBLEM = register("cyan_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item GRAY_EMBLEM = register("gray_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item GREEN_EMBLEM = register("green_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item LIGHT_BLUE_EMBLEM = register("light_blue_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item LIGHT_GRAY_EMBLEM = register("light_gray_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item LIME_EMBLEM = register("lime_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item MAGENTA_EMBLEM = register("magenta_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item ORANGE_EMBLEM = register("orange_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item PINK_EMBLEM = register("pink_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item PURPLE_EMBLEM = register("purple_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item RED_EMBLEM = register("red_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item WHITE_EMBLEM = register("white_emblem", new EmblemItem(new Item.Settings().maxCount(1)));
    public static Item YELLOW_EMBLEM = register("yellow_emblem", new EmblemItem(new Item.Settings().maxCount(1)));

    public static void initialize() {
        // Add items to creative tabs
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> {
            itemGroup.add(BLACK_EMBLEM);
            itemGroup.add(BLUE_EMBLEM);
            itemGroup.add(BROWN_EMBLEM);
            itemGroup.add(CYAN_EMBLEM);
            itemGroup.add(GRAY_EMBLEM);
            itemGroup.add(GREEN_EMBLEM);
            itemGroup.add(LIGHT_BLUE_EMBLEM);
            itemGroup.add(LIGHT_GRAY_EMBLEM);
            itemGroup.add(LIME_EMBLEM);
            itemGroup.add(MAGENTA_EMBLEM);
            itemGroup.add(ORANGE_EMBLEM);
            itemGroup.add(PINK_EMBLEM);
            itemGroup.add(PURPLE_EMBLEM);
            itemGroup.add(RED_EMBLEM);
            itemGroup.add(WHITE_EMBLEM);
            itemGroup.add(YELLOW_EMBLEM);
        });
    }

    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TeamEmblems.MOD_ID, id), item);
    }
}
