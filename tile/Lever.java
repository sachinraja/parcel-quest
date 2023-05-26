package tile;

import main.AssetManager;
import main.Game;

import java.awt.*;

public class Lever extends Tile {
  private static final Image inactiveImage = AssetManager.getAsset("assets/tiles/lever_1.png");
  private static final Image activeImage = AssetManager.getAsset("assets/tiles/lever_2.png");

  boolean active = false;
  public LeverAction action;

  public Lever(int gridX, int gridY, LeverAction action) {
    super(gridX, gridY, inactiveImage);
    canCollideWith = false;
    this.action = action;
  }
  
  
  public void onInteract(Game game) {
	  active = !active;
	  
	  if (active) {
		  image = activeImage;
	  } else {
		  image = inactiveImage;
	  }

	  action.onActiveChanged(active);
  }
}
