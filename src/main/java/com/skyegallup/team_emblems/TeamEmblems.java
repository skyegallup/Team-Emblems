package com.skyegallup.team_emblems;

import com.skyegallup.team_emblems.config.Config;
import com.skyegallup.team_emblems.item.ModItems;
import com.skyegallup.team_emblems.recipes.ModRecipeSerializers;
import com.skyegallup.team_emblems.tag.ModTags;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class TeamEmblems implements ModInitializer {
	public static final String MOD_ID = "team_emblems";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Config CONFIG = new Config();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.initialize();
		ModTags.initialize();
		ModRecipeSerializers.initialize();
	}
}