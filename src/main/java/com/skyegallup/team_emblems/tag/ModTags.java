package com.skyegallup.team_emblems.tag;

import com.skyegallup.team_emblems.TeamEmblems;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Item> EMBLEMS = TagKey.of(
        RegistryKeys.ITEM,
        Identifier.of(TeamEmblems.MOD_ID, "emblems")
    );

    public static void initialize() {
        // pass
    }
}
