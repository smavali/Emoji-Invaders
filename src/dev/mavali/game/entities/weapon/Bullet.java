package dev.mavali.game.entities.weapon;

import java.awt.*;
import java.awt.image.BufferedImage;

public  class Bullet {

    private float x;
    private float y;
    private int width;
    private int height;
    public int heatAmount;

    private BufferedImage bulletImage;

    public Bullet(BufferedImage bulletImage, float x, float y, int width, int height, int heatAmount) {
        this.x = x; 
        this.y = y;
        this.width = width;
        this.height = height;
        this.bulletImage = bulletImage;
        this.heatAmount = heatAmount;

    }

    public void tick() {
        y -= 10;
    }

    public void render(Graphics g) {
        g.drawImage(bulletImage, (int) x, (int) y, width, height, null);
    }

    public float getY() {
        return y;
    }
}
