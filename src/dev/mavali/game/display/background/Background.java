package dev.mavali.game.display.background;

import dev.mavali.game.constant.Constants;
import dev.mavali.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    private BufferedImage background;
    private Cloud cloudTypeOne;
    private Cloud cloudTypeTwo;


    public Background(BufferedImage background) {
        this.background = background;
        init();
    }
    private void init(){
        cloudTypeOne = new Cloud(Assets.cloudTypeOneImage,1200,300,Assets.cloudTypeOneImage.getWidth(),Assets.cloudTypeOneImage.getHeight(),1);
        cloudTypeTwo = new Cloud(Assets.cloudTypeTwoImage,600,100,Assets.cloudTypeTwoImage.getWidth(),Assets.cloudTypeTwoImage.getHeight(), 1.5f);

    }
    public void tick(){
        cloudTypeOne.tick();
        cloudTypeTwo.tick();

    }
    public void render(Graphics g){
        g.drawImage(background,0,0, Constants.screenWidth,Constants.screenHeight,null);
        cloudTypeOne.render(g);
        cloudTypeTwo.render(g);
    }
}
