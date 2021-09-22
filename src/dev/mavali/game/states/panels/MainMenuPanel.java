package dev.mavali.game.states.panels;

import dev.mavali.game.Game;
import dev.mavali.game.constant.Constants;
import dev.mavali.game.gfx.Assets;
import dev.mavali.game.states.State;


import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel implements PanelEssentials {

    private JButton playButton;
    private JButton recordButton;
    private JButton settingButton;
    private JButton exitButton;
    private  JLabel loginLabel;
    private Menu menu;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.background_sick,0,0,Constants.screenWidth,Constants.screenHeight,null);
    }

    public MainMenuPanel(Menu menu) {
        this.menu = menu;
        setBounds(0,0, Constants.screenWidth, Constants.screenHeight);
        setBackground(Color.getHSBColor(50,100,100));
        setLayout(null);
        init();
        actionOnComponent();
        addComponent();
        setComponentLocation();
        setComponentSize(playButton,recordButton,settingButton,exitButton);
    }
    public void init(){
        //Buttons
        playButton = new JButton("Play");
        recordButton = new JButton("Records");
        settingButton = new JButton("Setting");
        exitButton = new JButton("Exit");
        loginLabel = new JLabel("Hello "+UserPanel.text);

    }

    public void actionOnComponent(){

        playButton.addActionListener(e->{
            State.setState(Game.gameState);
            menu.frame.dispose();
        });

        recordButton.addActionListener(e->{

        });
        settingButton.addActionListener(e->{

        });

        exitButton.addActionListener(e->{
            PanelController.setPanel(menu.userPanel,menu.frame);
            PanelController.getPanel().repaint();
        });
    }

    @Override
    public void addComponent() {
        this.add(loginLabel);
        this.add(playButton);
        this.add(recordButton);
        this.add(settingButton);
        this.add(exitButton);
    }

    public void setComponentSize(JButton... buttons){
        for (JButton button : buttons) {
            button.setSize(400,80);
        }
        loginLabel.setSize(300,200);
    }


    public void setComponentLocation() {
        loginLabel.setLocation(620,100);
        playButton.setLocation(520,400);
        recordButton.setLocation(520,500);
        settingButton.setLocation(520,600);
        exitButton.setLocation(520,700);

    }

    public JButton getPlayButton() {
        return playButton;
    }
}
