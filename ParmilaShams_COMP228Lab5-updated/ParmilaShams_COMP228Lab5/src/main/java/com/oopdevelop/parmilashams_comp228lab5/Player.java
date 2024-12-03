package com.oopdevelop.parmilashams_comp228lab5;


public class Player {
    private int id;
    private String name;
    private String game;

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