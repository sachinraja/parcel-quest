package main;
import tile.Tile;
import java.awt.*;

public class Player extends Entity {
  private static final Image image = AssetManager.getAsset("assets/character.png");
  public float velocityY;
  public Tile tile;
  public boolean isJumping;
  private static final int TERMINAL_VELOCITY = 150;
  public boolean hasKey;

  public Player() {
    super(50, 50, 30, 48);
  }

  public void paint(Graphics g) {
    g.drawImage(image, (int) x, (int) y, width, height, null);
  }

  public void setVelocityY(float newVelocityY) {
    if (Math.abs(newVelocityY) > TERMINAL_VELOCITY) {
      velocityY = Math.signum(newVelocityY) * TERMINAL_VELOCITY;
    } else {
      velocityY = newVelocityY;
    }
  }

  public void reset() {
    this.x = 50;
    this.y = 50;
    this.velocityY = 0;
    this.hasKey = false;
  }
}