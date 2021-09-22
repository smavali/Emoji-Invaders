package dev.mavali.game.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

    private ArrayList<UIObject> objects;

    public UIManager() {
        objects = new ArrayList<UIObject>();
    }
    public  void tick(){
        for (UIObject object : objects) {
            object.tick();
        }
    }

    public  void render(Graphics g){
        for (UIObject object : objects) {
            object.render(g);
        }
    }

    public void onMouseMove(MouseEvent e) {
        for (UIObject object : objects) {
            object.onMouseMove(e);
        }
    }
    public void onMouseRelease(MouseEvent e){
        for (UIObject object : objects) {
            object.onMouseRelease(e);
        }
    }
    public void addObject(UIObject uiObject) {
        objects.add(uiObject);
    }
    public void removeObject(UIObject uiObject) {
        objects.remove(uiObject);
    }
}
