package tile;

import main.AssetManager;
import java.awt.*;

public class Grass extends Tile {
  private static final Image image = AssetManager.getAsset("assets/tiles/grass.png");
  public Grass(int gridX, int gridY) {
    super(gridX, gridY, image);
  }
}
