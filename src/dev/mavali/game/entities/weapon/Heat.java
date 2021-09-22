package dev.mavali.game.entities.weapon;

import dev.mavali.game.entities.creatures.Player;
import dev.mavali.game.gfx.Assets;
import dev.mavali.game.input.KeyManager;
import dev.mavali.game.input.MouseManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Heat {

    private MouseManager mouseManager;
    private KeyManager keyManager;
    private int tempMax = Assets.heat.getWidth(); //1756 = 13 * 27 * 5
    private int temp = 1;
    private BufferedImage heatImage;

    public Heat(KeyManager keyManager, MouseManager mouseManager) {
        this.keyManager = keyManager;
        this.mouseManager = mouseManager;
    }

    public void render(Graphics g) {
        heatImage = Assets.heat.getSubimage(0, 0, temp, Assets.heat.getHeight());
        g.drawImage(heatImage, 20, 20, temp / 4, Assets.heat.getHeight() / 4, null);
        g.drawImage(Assets.heat1,20, 20, Assets.heat1.getWidth() / 4, Assets.heat.getHeight() / 4, null);
    }

    public void tick() {
        if ((mouseManager.mousePressed || keyManager.space) && Player.canShoot) {
            if (temp < tempMax)
                temp += 6;
            if (temp == tempMax)
                Player.canShoot = false;
        }

        if (!(mouseManager.mousePressed && keyManager.space))
            if (temp > 1)
                temp -= 3;
            if (temp == tempMax)
                Player.canShoot = false;

        if (!Player.canShoot) {
            if (temp > 1)
                temp -= 3;
            if (temp == 1)
                Player.canShoot = true;

        }
    }
}
