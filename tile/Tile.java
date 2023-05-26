package tile;

import main.*;
import java.awt.*;

public class Tile extends Entity {
  public static final int SIZE = 32;

  public Image image;
  public boolean markedForDeletion;
  public boolean canCollideWith = true;

  public int gridX, gridY;

  Tile(int gridX, int gridY, Image image) {
    super(gridX * SIZE, gridY * SIZE, SIZE, SIZE);
    this.gridX = gridX;
    this.gridY = gridY;
    this.image = image;
  }

  public void paint(Graphics g) {
    g.drawImage(image, (int) x, (int) y, width, height, null);
  }

  public static <T> T create(Class<T> tileClass, int x, int y) {
    try {
      return tileClass.getDeclaredConstructor(new Class[] {int.class,int.class, int.class, int.class}).newInstance(x * SIZE, y * SIZE, x, y);
    } catch(Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void onCollisionEnter(Game game, Entity entity) {}
  public void onInteract(Game game) {}
}