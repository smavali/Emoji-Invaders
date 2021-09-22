package dev.mavali.game.display.background;

import dev.mavali.game.entities.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cloud extends Entity {
    private float cloudSpeed;
    private BufferedImage cloudImage;
    public Cloud(BufferedImage bufferedImage,float x, float y, int width, int height,float cloudSpeed) {
        super(x, y, width, height);
        this.cloudImage = bufferedImage;
        this.cloudSpeed = cloudSpeed;
    }

    @Override
    public void tick() {
        moveCloud();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(cloudImage,(int)x,(int)y,null);
    }
    private void moveCloud(){
        if (this.x + cloudImage.getWidth()<0)
            this.x = 1440;
        x -= cloudSpeed;
    }
}
