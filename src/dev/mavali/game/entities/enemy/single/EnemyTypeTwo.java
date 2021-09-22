package dev.mavali.game.entities.enemy.single;

import dev.mavali.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyTypeTwo extends Enemy {

    public EnemyTypeTwo(int radius, float x, float y, float xVelocity, float yVelocity) {
        super(radius, x, y, xVelocity, yVelocity);
        enemyImage = new BufferedImage[3];
        health = 3;
        enemyBulletSpeed = 5;
        enemyBulletPossibility = .05f;
        init();
    }

    @Override
     void init() {
        enemyImage [0] = Assets.type_2_0;
        enemyImage [1] = Assets.type_2_1;
        enemyImage [2] = Assets.type_2_2;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {


    }
}
