package main;

import java.awt.*;
import tile.*;

public class Grid {
  public Tile[][] grid = new Tile[16][16];

  Game game;

  public Grid(Game game) {
    this.game = game;
  }

  public GridCollision getGridCollision(Entity entity) {
    Entity topRaycast = new Entity(entity.x, entity.y - 1, entity.width, 1);
    Entity bottomRaycast = new Entity(entity.x, entity.y + entity.height + 1, entity.width, 1);

    GridCollision collision = new GridCollision();

    for (Tile[] col : grid) {
      for (int i = 0; i < col.length; i++) {
        Tile tile = col[i];
        if (tile == null || !tile.canCollideWith) {
          continue;
        }
        if (tile.markedForDeletion) {
          col[i] = null;
          continue;
        }
        if (tile.isCollidingWith(topRaycast)) {
          collision.setTopTile(tile);
        }

        if (tile.isCollidingWith(bottomRaycast)) {
          collision.setBottomTile(tile);
        }

        if (tile.isCollidingWith(entity)) {
          collision.setCollidingTile(tile);
        }
      }
    }

    return collision;
  }

  public Tile getCollidingWith(Entity entity) {
    for (Tile[] col : grid) {
      for (Tile tile : col) {
        if (tile == null || !tile.canCollideWith) {
          continue;
        }
        if (tile.isCollidingWith(entity)) {
          tile.onCollisionEnter(game, entity);
          return tile;
        }
      }
    }

    return null;
  }

  public void paint(Graphics g) {
    for (Tile[] col : grid) {
      for (Tile tile : col) {
        if (tile == null) {
          continue;
        }
        tile.paint(g);
      }
    }
  }

  public <T extends Tile> T createTile(TileCreator<T> tileCreator, int x, int y) {
    T tile = tileCreator.create(x, y);
    if (tile != null) {
    	grid[x][y] = tile;
    	return tile;
    } else {
    	grid[x][y] = null;
    	return null;
    }
  }

  public <T extends Tile> void createArea(TileCreator<T> tileCreator, int initialX, int initialY, int finalX, int finalY) {
    for (int x = initialX; x <= finalX; x++) {
      for (int y = initialY; y <= finalY; y++) {
    	  createTile(tileCreator, x, y);
      }
    }
  }
}