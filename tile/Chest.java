package tile;

import main.AssetManager;
import main.Game;

import java.awt.*;

public class Chest extends Tile {
  private static final Image image = AssetManager.getAsset("assets/tiles/chest.png");
  
  public Chest(int gridX, int gridY) {
    super(gridX, gridY, image);
  }
  
  public void onInteract(Game game) {
	if (game.player.hasKey) {
		game.completeLevel();
	}
  }
}