package dev.mavali.game.entities.enemy.group;

import dev.mavali.game.entities.enemy.single.EnemyTypeFour;
import dev.mavali.game.entities.enemy.single.EnemyTypeOne;
import dev.mavali.game.entities.enemy.single.EnemyTypeThree;
import dev.mavali.game.entities.enemy.single.EnemyTypeTwo;

import java.awt.*;
import java.util.ArrayList;

public abstract class EnemyGroup {

    protected int level;
    protected ArrayList <EnemyTypeOne> weakEnemies;
    protected ArrayList <EnemyTypeTwo> normalEnemies;
    protected ArrayList <EnemyTypeThree> almostStrongEnemies;
    protected ArrayList <EnemyTypeFour> strongEnemies;
    protected int chickenSize;

    public EnemyGroup(int level) {
        this.level = level;
    }

    public abstract void init();
    public abstract void tick();
    public abstract void render(Graphics g);




}
