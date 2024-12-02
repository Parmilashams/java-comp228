package com.oopdevelop.parmilashams_comp228lab5;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlayerController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField provinceField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField gameTitleField;
    @FXML
    private TextField updatePlayerIdField;
    @FXML
    private TextField updateAddressField;
    @FXML
    private TextField updatePhoneField;
    @FXML
    private TextArea outputArea;

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
        String phoneNumber = phoneField.getText();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !postalCode.isEmpty() && !province.isEmpty() && !phoneNumber.isEmpty()) {
            try {
                dbConnection.addPlayer(firstName, lastName, address, postalCode, province, phoneNumber);
                outputArea.setText("Player added: " + firstName + " " + lastName);
            } catch (Exception ex) {
                outputArea.setText("Error adding player: " + ex.getMessage());
            }
        } else {
            outputArea.setText("Please fill in all fields.");
        }
    }

    @FXML
    public void handleAddGame() {
        String gameTitle = gameTitleField.getText();

        if (!gameTitle.isEmpty()) {
            try {
                dbConnection.addGame(gameTitle);
                outputArea.setText("Game added: " + gameTitle);
            } catch (Exception ex) {
                outputArea.setText("Error adding game: " + ex.getMessage());
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

            dbConnection.updatePlayer(playerId, newAddress, newPhone);
            outputArea.setText("Player updated successfully.");
        } catch (NumberFormatException ex) {
            outputArea.setText("Invalid player ID.");
        } catch (Exception ex) {
            outputArea.setText("Error updating player: " + ex.getMessage());
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
        } catch (Exception ex) {
            outputArea.setText("Error fetching players: " + ex.getMessage());
        }
    }

    @FXML
    public void handleDisplayReports() {
        try {
            StringBuilder report = new StringBuilder();
            var players = dbConnection.getPlayers();
            for (String player : players) {
                String[] nameParts = player.split(" ");
                String firstName = nameParts[0];
                String lastName = nameParts[1];
                int playerId = dbConnection.getPlayerIdFromName(firstName, lastName);

                var games = dbConnection.getGamesForPlayer(playerId);
                report.append(firstName + " " + lastName + ":\n");
                if (games.isEmpty()) {
                    report.append("No games found.\n");
                } else {
                    for (String game : games) {
                        report.append("  - " + game + "\n");
                    }
                }
                report.append("\n");
            }
            outputArea.setText(report.toString());
        } catch (Exception ex) {
            outputArea.setText("Error displaying report: " + ex.getMessage());
        }
    }
}
