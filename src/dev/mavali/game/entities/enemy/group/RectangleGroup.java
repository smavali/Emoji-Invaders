package dev.mavali.game.entities.enemy.group;

import dev.mavali.game.constant.Constants;
import dev.mavali.game.entities.enemy.single.EnemyTypeOne;

import java.awt.*;
import java.util.ArrayList;

public class RectangleGroup extends EnemyGroup {

    private int groupxVelocity;
    private int groupyVelocity;

    public RectangleGroup(int level) {
        super(level);
        chickenSize = 50;
        weakEnemies = new ArrayList<>();
        init();

    }

    @Override
    public void init() {
        int x = 100, y;
        for (int i = 0; i < 10; i++) {
            x += 100;
            y = 100;
            for (int j = 0; j < 5; j++) {
                weakEnemies.add(new EnemyTypeOne(40, x, y, 6, 0));
                y += 100;
            }
        }
        weakEnemies.size();
    }

    @Override
    public void tick() {
        for (EnemyTypeOne weakEnemy : weakEnemies) {
            // TODO : moshkel dare if ha
//            if (weakEnemy.getX()+ weakEnemy.getRadius() > Constants.screenWidth)
//                weakEnemy.setxVelocity(-weakEnemy.getxVelocity());
//            if (weakEnemy.getX() - weakEnemy.getRadius() < 0)
//                weakEnemy.setxVelocity(-weakEnemy.getxVelocity());
            if (weakEnemies.get(49).getX() + weakEnemies.get(49).getRadius() >= Constants.screenWidth)
                weakEnemy.setxVelocity(-weakEnemy.getxVelocity());
            if (weakEnemies.get(0).getX() - weakEnemies.get(4).getRadius() <= 0)
                weakEnemy.setxVelocity(-weakEnemy.getxVelocity());
            weakEnemy.tick();
        }

    }

    @Override
    public void render(Graphics g) {
        for (EnemyTypeOne weakEnemy : weakEnemies) {
            weakEnemy.render(g);
        }

    }

}
