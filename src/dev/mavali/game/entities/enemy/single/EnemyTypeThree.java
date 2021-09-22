package dev.mavali.game.entities.enemy.single;

import dev.mavali.game.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyTypeThree extends Enemy {

    public EnemyTypeThree(int radius, float x, float y, float xVelocity, float yVelocity) {
        super(radius, x, y, xVelocity, yVelocity);
        enemyImage = new BufferedImage[5];
        health = 5;
        enemyBulletSpeed = 10;
        enemyBulletPossibility = .1f;
        init();
    }

    @Override
     void init() {
        enemyImage [0] = ImageLoader.loadImage("");
        enemyImage [1] = ImageLoader.loadImage("");
        enemyImage [2] = ImageLoader.loadImage("");
        enemyImage [3] = ImageLoader.loadImage("");
        enemyImage [4] = ImageLoader.loadImage("");
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
