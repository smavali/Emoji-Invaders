package dev.mavali.game.states.panels;

import javax.swing.*;
import java.awt.*;

public class Menu {

    public JFrame frame;
    public PanelController panelController;
    private CardLayout cardLayout;
    public JPanel userPanel;
    public JPanel mainMenuPanel;

    public Menu() {
        frame = new JFrame("game");
        cardLayout = new CardLayout();
        userPanel = new UserPanel(this);
        mainMenuPanel = new MainMenuPanel(this);
        panelController = new PanelController();
        init();

    }

    private void init() {
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        PanelController.setPanel(userPanel, frame);
        com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(frame, true);
        com.apple.eawt.Application.getApplication().requestToggleFullScreen(frame);
    }
}
