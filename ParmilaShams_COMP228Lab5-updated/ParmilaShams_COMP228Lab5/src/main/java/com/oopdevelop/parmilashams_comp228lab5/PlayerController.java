package com.oopdevelop.parmilashams_comp228lab5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PlayerController {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField addressField;
    @FXML private TextField postalCodeField;
    @FXML private TextField provinceField;
    @FXML private TextField phoneField;
    @FXML private TextField gameTitleField;
    @FXML private TextField updatePlayerIdField;
    @FXML private TextField updateAddressField;
    @FXML private TextField updatePhoneField;
    @FXML private TextArea outputArea;
    @FXML
    private ListView<String> playersListView;
    private DatabaseConnection dbConnection;

    public PlayerController() {
        try {
            dbConnection = new DatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAddPlayer() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String postalCode = postalCodeField.getText();
        String province = provinceField.getText();
        String phone = phoneField.getText();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !postalCode.isEmpty() && !province.isEmpty() && !phone.isEmpty()) {
            try {
                dbConnection.addPlayer(firstName, lastName, address, postalCode, province, phone);
                outputArea.setText("Player added successfully: " + firstName + " " + lastName);
            } catch (Exception e) {
                outputArea.setText("Error adding player: " + e.getMessage());
            }
        } else {
            outputArea.setText("All fields are required to add a player.");
        }
    }

    @FXML
    public void handleViewPlayers() {
        try {
            var players = dbConnection.getPlayers();
            if (players.isEmpty()) {
                outputArea.setText("No players found.");
            } else {
                outputArea.setText("Players:\n" + String.join("\n", players));
            }
        } catch (Exception e) {
            outputArea.setText("Error fetching players: " + e.getMessage());
        }
    }

    @FXML
    public void handleAddGame() {
        String gameTitle = gameTitleField.getText();

        if (!gameTitle.isEmpty()) {
            try {
                dbConnection.addGame(gameTitle);
                outputArea.setText("Game added successfully: " + gameTitle);
            } catch (Exception e) {
                outputArea.setText("Error adding game: " + e.getMessage());
            }
        } else {
            outputArea.setText("Please enter a valid game title.");
        }
    }

    @FXML
    public void handleUpdatePlayer() {
        try {
            int playerId = Integer.parseInt(updatePlayerIdField.getText());
            String newAddress = updateAddressField.getText();
            String newPhone = updatePhoneField.getText();

            if (!newAddress.isEmpty() && !newPhone.isEmpty()) {
                dbConnection.updatePlayer(playerId, newAddress, newPhone);
                outputArea.setText("Player updated successfully.");
            } else {
                outputArea.setText("Address and phone fields cannot be empty.");
            }
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid player ID.");
        } catch (Exception e) {
            outputArea.setText("Error updating player: " + e.getMessage());
        }
    }

    @FXML
    public void handleDisplayReports() {
        try {
            ObservableList<PlayerGame> data = FXCollections.observableArrayList();

            // Get the list of players
            var players = dbConnection.getPlayers();
            if (players.isEmpty()) {
                outputArea.setText("No players found.");
                return;
            }

            for (String player : players) {
                String[] nameParts = player.split(" ");
                String firstName = nameParts[0];
                String lastName = nameParts[1];
                int playerId = dbConnection.getPlayerIdFromName(firstName, lastName);

                // Get the games associated with the player
                var games = dbConnection.getGamesForPlayer(playerId);
                for (String game : games) {
                    // Add the player and their game to the data list
                    data.add(new PlayerGame(firstName, lastName, game));
                }
            }

            // Display reports in the output area
            StringBuilder report = new StringBuilder("Player Reports:\n");
            for (PlayerGame pg : data) {
                report.append(pg.getFirstName()).append(" ")
                        .append(pg.getLastName()).append(" - ")
                        .append(pg.getGameTitle()).append("\n");
            }
            outputArea.setText(report.toString());

        } catch (Exception ex) {
            outputArea.setText("Error displaying reports: " + ex.getMessage());
        }
    }
}