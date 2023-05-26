package main;

import tile.Tile;

public class GridCollision {
  public Tile collidingTile, topTile, bottomTile;

  public void setCollidingTile(Tile tile) {
    collidingTile = tile;
  }

  public void setTopTile(Tile tile) {
    topTile = tile;
  }

  public void setBottomTile(Tile tile) {
    bottomTile = tile;
  }
}