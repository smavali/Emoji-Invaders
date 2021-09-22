package dev.mavali.game.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage player, background, background_night, background_sick, cloudTypeOneImage
            , cloudTypeTwoImage, knifeBulletImage, bombImage, bye,plus,minus,play,record, heat, heat1, heart, bomb, bolt, pizza, properties
            , type_1_0, type_1_1
            , type_2_0,type_2_1,type_2_2;
    public static BufferedImage [] enemyTypeOneImage = new BufferedImage[2];


    public static void init() {
        // Backgrounds
        background_night = ImageLoader.loadImage("/textures/backgroundMenu.png");
        background_sick = ImageLoader.loadImage("/textures/background_sick.png");
        background = ImageLoader.loadImage("/textures/background.png");
        cloudTypeOneImage = ImageLoader.loadImage("/textures/cloud1.png");
        cloudTypeTwoImage = ImageLoader.loadImage("/textures/cloud2.png");
        // Player
        player = ImageLoader.loadImage("/textures/sunglasses.png");
        knifeBulletImage = ImageLoader.loadImage("/textures/Bullet.png");
        bombImage = ImageLoader.loadImage("/textures/bomb.png");
        heat = ImageLoader.loadImage("/textures/heatBar.png");
        heat1 =ImageLoader.loadImage("/textures/heatBar_1.png");
        // Properties
        properties = ImageLoader.loadImage("/textures/properties.png");
        heart = ImageLoader.loadImage("/textures/heart.png");
        bomb = ImageLoader.loadImage("/textures/bomb1.png");
        bolt = ImageLoader.loadImage("/textures/bolt.png");
        pizza = ImageLoader.loadImage("/textures/pizza.png");
        // Enemy
            // Type 1
            type_1_0= ImageLoader.loadImage("/textures/type_1_0.png");
            type_1_1 = ImageLoader.loadImage("/textures/type_1_1.png");
            // Type 2
            type_2_0= ImageLoader.loadImage("/textures/type_2_0.png");
            type_2_1 = ImageLoader.loadImage("/textures/type_2_1.png");
            type_2_2 = ImageLoader.loadImage("/textures/type_2_2.png");
        // Garbage
//        bye = ImageLoader.loadImage("/textures/bye_black.png");
//        plus = ImageLoader.loadImage("/textures/applePlus.png");
//        minus = ImageLoader.loadImage("/textures/appleMinus.png");
//        record = ImageLoader.loadImage("/textures/record.png");
//        play = ImageLoader.loadImage("/textures/play.png");

    }

}
