package dev.mavali.game.entities.enemy.single;


import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy {

    protected BufferedImage[] enemyImage;
    protected int radius;
    protected float x, y;
    protected float xVelocity, yVelocity;
    protected int health;
    protected static final float upgradePossibility = 0.03f;
    protected static final float giftPossibility = 0.03f;
    protected float enemyBulletSpeed;
    protected float enemyBulletPossibility;

    public Enemy(int radius, float x, float y, float xVelocity, float yVelocity) {
        this.radius = radius;
        this.x = x + radius;
        this.y = y + radius;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    abstract void init();

    public void tick() {

    }

    public abstract void render(Graphics g);


    // Getters and setters


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }
}
