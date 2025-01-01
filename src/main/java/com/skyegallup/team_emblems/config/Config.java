package com.skyegallup.team_emblems.config;

import com.skyegallup.team_emblems.TeamEmblems;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Config {
    public static String filePath = "config/team_emblems.toml";
    public static Path path = Paths.get(filePath);

    public String defaultConfigText = """
[team_settings]
# All team settings are based on the behavior of the /team Minecraft command. Documentation for these settings can be
# found on the Minecraft wiki: https://minecraft.wiki/w/Commands/team#Arguments

# If true, team members can inflict damage upon each other
friendly_fire = false

# If true, team members can see each other even when invisible
see_friendly_invisibles = true

# If true, team members can collide with each other (as usual). If false, team members will pass through each other.
collide_with_teammates = true
""";

    private final TomlParseResult configContents;

    public Config()  {
        if (path.toFile().exists()) {
            configContents = Toml.parse(filePath);
            TeamEmblems.LOGGER.info(String.format("Loaded configuration from file %s.", filePath));
        } else {
            configContents = createDefaultConfig();
            TeamEmblems.LOGGER.info("Loaded default configuration.");
        }
    }

    public boolean getFriendlyFire() {
        Boolean value = configContents.getBoolean("team_settings.friendly_fire");
        return Objects.requireNonNullElse(value, false);
    }

    public boolean getSeeFriendlyInvisibles() {
        Boolean value = configContents.getBoolean("team_settings.see_friendly_invisibles");
        return Objects.requireNonNullElse(value, true);
    }

    public boolean getCollideWithTeammates() {
        Boolean value = configContents.getBoolean("team_settings.collide_with_teammates");
        return Objects.requireNonNullElse(value, true);
    }

    private TomlParseResult createDefaultConfig() {
        // Write to file
        File file = path.toFile();
        try {
            if (file.createNewFile()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(defaultConfigText);
                }
                TeamEmblems.LOGGER.info("Created default configuration file at config/team_emblems.toml.");
            }

        } catch (IOException ex) {
            TeamEmblems.LOGGER.error(String.format("Failed to create default configuration file at %s.", filePath), ex);
        }

        // Load default config
        return Toml.parse(defaultConfigText);
    }
}
