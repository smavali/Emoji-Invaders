package dev.mavali.game.entities.user;

public class User {


    public String name;
    public int health = 5;
    public int level = 0;
    public int food = 0;
    public int score = 0;
    public int power = 1;
    public int bomb = 0;

    public User(String name) {
        this.name = name;
    }
}
