package dev.mavali.game;

import dev.mavali.game.states.panels.MainMenuPanel;
import dev.mavali.game.states.panels.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher {


	public static void main(String[] args){

		Game game = new Game("game");
		game.start();
		Menu menu = new Menu();

	}
	
}
