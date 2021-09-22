package dev.mavali.game.entities.enemy;

import dev.mavali.game.entities.enemy.group.EnemyGroup;
import dev.mavali.game.entities.enemy.group.RectangleGroup;

import java.awt.*;

public class EnemyController {

    private EnemyGroup rectangleGroup = new RectangleGroup(1);

    public void tick(){
        rectangleGroup.tick();
    }
    public void render(Graphics g){
        rectangleGroup.render(g);
    }

}
