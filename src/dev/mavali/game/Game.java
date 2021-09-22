package dev.mavali.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.mavali.game.constant.Constants;
import dev.mavali.game.display.Display;
import dev.mavali.game.gfx.Assets;
import dev.mavali.game.input.KeyManager;
import dev.mavali.game.input.MouseManager;
import dev.mavali.game.states.GameState;
import dev.mavali.game.states.MenuState;
import dev.mavali.game.states.State;

public class Game implements Runnable {

	private Display display;
	public int width = Constants.screenWidth,height = Constants.screenHeight;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//State
	public static State gameState;
	private State menuState;

	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	public Game(String title){
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void init(){
		display = new Display(title);
		display.getFrame().addKeyListener(keyManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(null);
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
			bs = display.getCanvas().getBufferStrategy();
			if (bs == null) {
				display.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			//Clear Screen
			g.clearRect(0, 0, width, height);
			//Draw Here!

			if (State.getState() != null)
				State.getState().render(g);

			//End Drawing!
			bs.show();
			g.dispose();
		}

	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public State getGameState() {
		return gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public Display getDisplay() {
		return display;
	}
}











