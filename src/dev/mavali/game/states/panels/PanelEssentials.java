package dev.mavali.game.states.panels;

import javax.swing.*;

public interface PanelEssentials {
    void setComponentLocation();
    void setComponentSize(JButton... buttons);
    void actionOnComponent();
    void addComponent();
    void init();
}