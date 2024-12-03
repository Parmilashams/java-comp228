package com.oopdevelop.parmilashams_comp228lab5;

public class PlayerGame {
    private String firstName;
    private String lastName;
    private String gameTitle;

    public PlayerGame(String firstName, String lastName, String gameTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gameTitle = gameTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
}