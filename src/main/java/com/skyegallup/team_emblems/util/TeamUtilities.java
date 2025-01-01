package com.skyegallup.team_emblems.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Random;

public class TeamUtilities {
    public static int TEAM_NAME_LENGTH = 8;
    private static final Random rng = new Random();

    public static Team createNewTeam(World world) {
        Scoreboard scoreboard = world.getScoreboard();

        // Generate a new *unique* team name
        HashSet<String> existingTeamNames = new HashSet<>(scoreboard.getTeamNames());
        String newTeamName;
        do {
            newTeamName = generateTeamName();
        } while (existingTeamNames.contains(newTeamName));

        // Create and configure the team
        Team team = scoreboard.addTeam(newTeamName);
        team.setFriendlyFireAllowed(false);  // TODO: add configurable team settings
        return team;
    }

    public static void addToTeam(LivingEntity entity, String teamName) {
        Scoreboard scoreboard = entity.getWorld().getScoreboard();

        Team team = scoreboard.getTeam(teamName);
        if (team != null) {
            // Clear the player's existing team, if any
            String entityName = entity.getEntityName();
            Team existingTeam = scoreboard.getPlayerTeam(entityName);
            if (existingTeam != null) {
                scoreboard.removePlayerFromTeam(entityName, existingTeam);
            }

            // Set the player's new team
            scoreboard.addPlayerToTeam(entityName, team);
        }
    }

    public static void removeFromTeam(LivingEntity entity, String teamName) {
        Scoreboard scoreboard = entity.getWorld().getScoreboard();
        String entityName = entity.getEntityName();

        // We need to check if the player actually has a team, since the game crashes otherwise
        Team team = scoreboard.getPlayerTeam(entityName);
        if (team != null && team.getName().equals(teamName)) {
            try {
                scoreboard.removePlayerFromTeam(entity.getEntityName(), team);
            } catch (IllegalStateException ex) {
                // Ignore duplicated team removals
            }
        }
    }

    private static String generateTeamName() {
        String validCharacters = "abcdefghijklmnopqrstuvwxyz1234567890";
        char[] selectedCharacters = new char[TEAM_NAME_LENGTH];

        for (int i = 0; i < TEAM_NAME_LENGTH; i++) {
            selectedCharacters[i] = validCharacters.charAt(rng.nextInt(validCharacters.length()));
        }

        return new String(selectedCharacters);
    }
}
