package dev.mavali.game.entities.weapon;


import dev.mavali.game.constant.Constants;
import dev.mavali.game.input.MouseManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bomb {
    private static final float DEFAULT_BOMB_SPEED = 10;
    private float bombXspeed;
    private float bombYspeed;
    private float x, y;
    private int width, height;
    private BufferedImage bombImage;

    public Bomb(BufferedImage bombImage,float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bombImage = bombImage;
        calculation();
    }

    public void tick() {
        if (x < Constants.screenWidth/2) {
            x += bombXspeed;
            if (y < Constants.screenHeight/2)
                y += bombYspeed;
            if (y > Constants.screenHeight/2)
                y -= bombYspeed;
        }
        if (x > Constants.screenWidth/2) {
            x -= bombXspeed;
            if (y > Constants.screenHeight/2)
                y -= bombYspeed;
            if (y < Constants.screenHeight/2)
                y += bombYspeed;
        }

    }

    public void render(Graphics g) {
        g.drawImage(bombImage, (int) x, (int) y, width, height, null);
    }

    private void calculation(){
        float bombSpeed = DEFAULT_BOMB_SPEED;
        float deltaX = Constants.screenWidth/2 - MouseManager.mouseClickedXPosition;
        float deltaY = Constants.screenHeight/2 - MouseManager.mouseClickedYPosition;
        float m = (deltaY) / (deltaX);
        float teta = (float) Math.atan(m);
        bombXspeed = (float) Math.abs(Math.cos(teta) * bombSpeed);
        bombYspeed = (float) Math.abs(Math.sin(teta) * bombSpeed);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
