package dev.mavali.game.entities.weapon;

import dev.mavali.game.constant.Constants;

import java.awt.*;
import java.util.LinkedList;

public class BombController {

    private LinkedList<Bomb> bombList = new LinkedList<Bomb>();
    private Bomb tempBomb;

    public BombController() {

    }
    private int error = 10;
    public void tick() {
        for (int i = 0; i < bombList.size(); i++) {
            tempBomb = bombList.get(i);
            tempBomb.tick();
            if (tempBomb.getX() > Constants.screenWidth / 2 - error &&
                    tempBomb.getX() < Constants.screenWidth / 2 + error &&
                    tempBomb.getY() > Constants.screenHeight / 2 - error &&
                    tempBomb.getY() < Constants.screenHeight / 2 + error)
                bombList.remove(tempBomb);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < bombList.size(); i++) {
            tempBomb = bombList.get(i);
            tempBomb.render(g);
        }
    }

    public void addBomb(Bomb bomb) {
        bombList.add(bomb);
    }

    public void removeBomb(Bomb bomb) {
        bombList.remove(bomb);
    }

    public int size() {
        return bombList.size();
    }

}