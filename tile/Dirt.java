package tile;

import main.AssetManager;
import java.awt.*;

public class Dirt extends Tile {
  private static final Image image = AssetManager.getAsset("assets/tiles/dirt.png");
  public Dirt(int gridX, int gridY) {
    super(gridX, gridY, image);
  }
}