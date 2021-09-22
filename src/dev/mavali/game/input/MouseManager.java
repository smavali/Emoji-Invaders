package dev.mavali.game.input;

import dev.mavali.game.ui.UIManager;

import java.awt.event.*;

public class MouseManager implements MouseMotionListener, MouseListener, MouseWheelListener {
    public static float mouseClickedXPosition, mouseClickedYPosition;
    private float mouseX, mouseY;
    public boolean mousePressed = false, rightClick = false;
    private UIManager uiManager;

    public void setUiManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
             mousePressed = true;
        if (e.getButton() == MouseEvent.BUTTON3){
            mouseClickedXPosition = e.getX();
            mouseClickedYPosition = e.getY();
            rightClick = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            mousePressed = false;
        if (e.getButton() == MouseEvent.BUTTON3)
            rightClick = false;
        if (uiManager != null)
            uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY =e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY =e.getY();
        if (uiManager != null)
        uiManager.onMouseMove(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    public float getMouseX() {
        return mouseX;
    }

    public float getMouseY() {
        return mouseY;
    }

}
