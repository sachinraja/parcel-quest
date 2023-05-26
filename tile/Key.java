package tile;

import main.AssetManager;
import main.Game;
import main.Player;
import main.Entity;
import java.awt.*;

public class Key extends Tile {
  private static final Image image = AssetManager.getAsset("assets/tiles/key.png");
  public Key(int gridX, int gridY) {
    super(gridX, gridY, image);
  }

  public void onCollisionEnter(Game game, Entity entity) {
    if (entity instanceof Player) {
      ((Player)entity).hasKey = true;
      // remove self
      markedForDeletion = true;
    }
  }
}