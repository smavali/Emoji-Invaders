package dev.mavali.game.entities.creatures;

import java.awt.Graphics;


import dev.mavali.game.Game;
import dev.mavali.game.constant.Constants;
import dev.mavali.game.entities.user.User;
import dev.mavali.game.entities.weapon.*;
import dev.mavali.game.gfx.Assets;
import dev.mavali.game.input.MouseManager;


public class Player extends Creature {

    private Game game;
    private int width;
    private int height;

    private BulletController bulletController;
    private BombController bombController;
    private Heat heat;
    private Properties properties;
    public static boolean canShoot = true;

    public Player(Game game, float x, float y, int width, int height) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
        this.width = width;
        this.height = height;
        init();
    }

    private void init() {
        bulletController = new BulletController();
        bombController = new BombController();
        heat = new Heat(game.getKeyManager(), game.getMouseManager());

        // TODO : inja bayad ye harkati bznm
        properties = new Properties(new User("ali"));
    }

    @Override
    public void tick() {
        bulletController.tick();
        bombController.tick();
        heat.tick();
        stayInScreen();
        getMouseInput();
        getKeyboardInput();
        move();
    }

    @Override
    public void render(Graphics g) {
        bulletController.render(g);
        bombController.render(g);
        g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
        heat.render(g);
        properties.render(g);

    }

    private double timeBullet = 0;
    private double timeBomb = 0;
    private double bulletDelay = 200;
    private double bombDelay = 3000;

    private void getKeyboardInput() {
        xMove = 0;
        yMove = 0;

        if (game.getKeyManager().up)
            yMove = -speed;
        if (game.getKeyManager().down)
            yMove = speed;
        if (game.getKeyManager().left)
            xMove = -speed;
        if (game.getKeyManager().right)
            xMove = speed;
        if (game.getKeyManager().space && System.currentTimeMillis() - timeBullet > bulletDelay && canShoot) {
            bulletController.addBullet(new Bullet(Assets.knifeBulletImage, this.x, this.y, 80, 80, 6));
            timeBullet = System.currentTimeMillis();
        }
    }

    private void getMouseInput() {
        this.x = game.getMouseManager().getMouseX() - this.getWidth() / 2;
        this.y = game.getMouseManager().getMouseY() - this.getHeight() / 2;

        if (game.getMouseManager().mousePressed && System.currentTimeMillis() - timeBullet > bulletDelay && canShoot) {
            bulletController.addBullet(new Bullet(Assets.knifeBulletImage, this.x, this.y, 80, 80, 6));
            timeBullet = System.currentTimeMillis();
        }

        if (game.getMouseManager().rightClick && System.currentTimeMillis() - timeBomb > bombDelay ) {
            bombController.addBomb(new Bomb(Assets.bombImage, MouseManager.mouseClickedXPosition, MouseManager.mouseClickedYPosition, 50, 50));
            timeBomb = System.currentTimeMillis();
        }
    }


    private void stayInScreen() {
        if (this.x + this.width > Constants.screenWidth)
            this.x = Constants.screenWidth - this.width;
        if (this.x < 0)
            this.x = 0;
        if (this.y < 0)
            this.y = 0;
        if (this.y + this.height > Constants.screenHeight)
            this.y = Constants.screenHeight - this.height;
    }

}
