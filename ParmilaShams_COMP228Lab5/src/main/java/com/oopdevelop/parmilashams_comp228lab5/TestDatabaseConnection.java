package com.oopdevelop.parmilashams_comp228lab5;

import java.util.List;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            System.out.println("Connection successful!");

            // Fetch players from the database
            List<String> players = dbConnection.getPlayers();
            if (players.isEmpty()) {
                System.out.println("No players found.");
            } else {
                System.out.println("Players and their associated games:");
                for (String player : players) {
                    // Extract player ID from player string (assuming player format is: "FirstName LastName")
                    String[] nameParts = player.split(" ");
                    String firstName = nameParts[0];
                    String lastName = nameParts[1];
                    int playerId = dbConnection.getPlayerIdFromName(firstName, lastName);

                    List<String> games = dbConnection.getGamesForPlayer(playerId);
                    System.out.println(firstName + " " + lastName + ":");
                    if (games.isEmpty()) {
                        System.out.println("No games found.");
                    } else {
                        for (String game : games) {
                            System.out.println(game);
                        }
                    }
                }
            }

            dbConnection.closeConnection();
        } catch (Exception e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
