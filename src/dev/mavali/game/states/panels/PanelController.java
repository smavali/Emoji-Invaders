package dev.mavali.game.states.panels;

import javax.swing.*;

public class PanelController {

    private static JPanel currentPanel = null;

    public static void setPanel(JPanel panel , JFrame frame){
        if (currentPanel != null)
            frame.remove(currentPanel);
        currentPanel = panel;
        frame.getContentPane().add(currentPanel);
        frame.getContentPane().repaint();
        frame.getContentPane().revalidate();
    }

    public static JPanel getPanel(){
        return currentPanel;
    }
}
