package com.oopdevelop.parmilashams_comp228lab5;


public class Player {
    private int id;          // The player's ID (this can be auto-generated in the database)
    private String name;     // The player's name
    private String game;     // The game associated with the player

    // Constructor to initialize the Player object
    public Player(int id, String name, String game) {
        this.id = id;
        this.name = name;
        this.game = game;
    }

    // Getters and setters for all properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Player{" + "id=" + id + ", name='" + name + "', game='" + game + "'}";
    }
}
