package dev.mavali.game.states;

import java.awt.*;
import dev.mavali.game.Game;
import dev.mavali.game.display.background.Background;
import dev.mavali.game.gfx.Assets;
import dev.mavali.game.ui.UIManager;

public class MenuState extends State {
	private Background background;
	private UIManager uiManager;

	public MenuState(Game game) {
		super(game);
		background = new Background(Assets.background_night);
		game.getMouseManager().setUiManager(uiManager);
		uiManager = new UIManager();
//		uiManager.addObject(new UIImageButton(650, 500, 100, 100, Assets.bye, () -> System.exit(0)));
	}

		@Override
		public void tick () {
			background.tick();
			uiManager.tick();
		}

		@Override
		public void render (Graphics g){
			background.render(g);
			uiManager.render(g);
		}

}
