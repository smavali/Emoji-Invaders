package dev.mavali.game.entities.creatures;

import dev.mavali.game.constant.Constants;
import dev.mavali.game.entities.user.User;
import dev.mavali.game.gfx.Assets;

import javax.swing.*;
import java.awt.*;

public class Properties {
    private User user;
//    JLabel propertiesLabel;


    public Properties(User user) {
        this.user = user;
    }

    public void render(Graphics g) {
        // Image size : 960 * 160
        g.drawImage(Assets.properties, 20, Constants.screenHeight - Assets.properties.getHeight() / 4 - 20,
                Assets.properties.getWidth() / 4, Assets.properties.getHeight() / 4, null);

        // Properties Details
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        g.setColor(Color.cyan);
        g.drawString(""+user.health , 62,Constants.screenHeight - Assets.properties.getHeight() / 4 + 5);
        g.drawString(""+user.bomb , 134,Constants.screenHeight - Assets.properties.getHeight() / 4 + 5);
        g.drawString(""+user.power , 195,Constants.screenHeight - Assets.properties.getHeight() / 4 + 5);
        g.drawString(""+user.food , 260,Constants.screenHeight - Assets.properties.getHeight() / 4 + 5); }
}
