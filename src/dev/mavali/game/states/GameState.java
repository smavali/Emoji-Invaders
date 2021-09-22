package dev.mavali.game.states;

import java.awt.*;
import java.security.PrivateKey;

import dev.mavali.game.Game;
import dev.mavali.game.display.background.Background;
import dev.mavali.game.entities.creatures.Player;
import dev.mavali.game.entities.enemy.EnemyController;
import dev.mavali.game.entities.enemy.single.Enemy;
import dev.mavali.game.entities.enemy.single.EnemyTypeOne;
import dev.mavali.game.gfx.Assets;

public class GameState extends State {
	private Background background;
	private Player player;
	private EnemyController enemyController;
	public GameState(Game game){
		super(game);
		player = new Player( game, 720, 450,100,100);
		background = new Background(Assets.background);
		enemyController = new EnemyController();
	}
	
	@Override
	public void tick() {
		player.tick();
		enemyController.tick();
		background.tick();
	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		enemyController.render(g);
		player.render(g);
	}

}
