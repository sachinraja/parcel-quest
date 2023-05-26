package main;

import java.awt.Graphics;

public class Entity {
  public float x, y;
  public int width, height;

  public Entity(float x, float y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public boolean isCollidingWith(Entity entity) {
    return (x < entity.x + entity.width &&
        x + width > entity.x &&
        y < entity.y + entity.height &&
        height + y > entity.y);
  }
  
  public void paint(Graphics g) {}
  public void onTimer(Game game) {}
}