package level;

import main.Game;
import tile.*;

public class Level1 implements LevelCreator {
	public Level create(Game game) {
		Level level = new Level(game);
		Tile[] interactTiles = new Tile[1];
		level.interactTiles = interactTiles;

		game.player.y = 13 * Tile.SIZE;

		level.grid.createArea(Dirt::new,0, 14, 15, 15);
		level.grid.createTile(Key::new, 5, 13);

		interactTiles[0] = level.grid.createTile(Chest::new, 15, 13);

		return level;
	}
}
