package com.oopdevelop.parmilashams_comp228lab5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD"; // Update this with your database URL
    private static final String USER = "COMP228_F24_soh_54"; // Update this with your DB username
    private static final String PASSWORD = "Kabul"; // Update this with your DB password
    private Connection connection;

    // Constructor to establish the connection
    public DatabaseConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Unable to connect to the database.");
        }
    }

    // Method to get players from the database
    public List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        String query = "SELECT first_name, last_name FROM Parmila_players";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                players.add(firstName + " " + lastName);  // Store full name of player
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Method to get games associated with a specific player
    public List<String> getGamesForPlayer(int playerId) {
        List<String> games = new ArrayList<>();
        String query = "SELECT g.games_title " +
                "FROM Parmila_games g " +
                "JOIN Parmila_players_and_games pg ON g.games_id = pg.games_id " +
                "WHERE pg.players_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId); // Set the player ID parameter
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(rs.getString("games_title"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    // Method to get player ID from their first and last name
    public int getPlayerIdFromName(String firstName, String lastName) {
        String query = "SELECT players_id FROM Parmila_players WHERE first_name = ? AND last_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("players_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if no player is found
    }

    // Add a new player to the database
    public void addPlayer(String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        String query = "INSERT INTO Parmila_players (first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, postalCode);
            stmt.setString(5, province);
            stmt.setString(6, phoneNumber);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding player: " + e.getMessage(), e);
        }
    }

    // Add a new game to the database
    public void addGame(String gameTitle) {
        String query = "INSERT INTO Parmila_games (games_title) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gameTitle);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding game: " + e.getMessage(), e);
        }
    }

    // Update an existing player's address and phone number
    public void updatePlayer(int playerId, String address, String phoneNumber) {
        String query = "UPDATE Parmila_players SET address = ?, phone_number = ? WHERE players_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, address);
            stmt.setString(2, phoneNumber);
            stmt.setInt(3, playerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating player: " + e.getMessage(), e);
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
