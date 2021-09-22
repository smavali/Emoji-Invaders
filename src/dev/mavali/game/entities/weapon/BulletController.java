package dev.mavali.game.entities.weapon;

import java.awt.*;
import java.util.LinkedList;

public class BulletController {

    private LinkedList<Bullet> bulletList = new LinkedList<Bullet>();
    private Bullet tempBullet;

    public BulletController() {

    }


    public void tick() {
        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);
            tempBullet.tick();
            if (tempBullet.getY() < 0)
                bulletList.remove(tempBullet);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < bulletList.size(); i++) {
            tempBullet = bulletList.get(i);
            tempBullet.render(g);
        }
    }

    public void addBullet(Bullet bullet) {
            bulletList.add(bullet);
    }

    public void removeBullet(Bullet bullet) {
        bulletList.remove(bullet);
    }

}
