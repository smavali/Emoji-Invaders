package dev.mavali.game.entities.enemy.single;

import dev.mavali.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyTypeOne extends Enemy {

    public EnemyTypeOne(int radius, float x, float y, float xVelocity, float yVelocity) {
        super(radius, x, y, xVelocity, yVelocity);
        enemyImage = new BufferedImage[2];
        health = 2;
        enemyBulletSpeed = 5;
        enemyBulletPossibility = .05f;
        init();
    }
    @Override
    void init() {
        enemyImage [0] = Assets.type_1_0;
        enemyImage [1] = Assets.type_1_1;
    }

    @Override
    public void tick() {
        x += xVelocity;
        y += yVelocity;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(enemyImage[0],(int)x - radius ,(int) y - radius,2*radius,2*radius ,null);
    }
}
