package level;

import main.Game;
import tile.*;

public class Level2 implements LevelCreator {
	public Level create(Game game) {
		Level level = new Level(game);
		Tile[] interactTiles = new Tile[1];
		level.interactTiles = interactTiles;

		level.grid.createArea(Dirt::new, 3, 10, 15, 12);
		level.grid.createArea(Grass::new, 4, 10, 15, 10);
		level.grid.createArea(Dirt::new, 0, 15, 15, 15);
		level.grid.createTile( Dirt::new, 0, 14);
		level.grid.createTile(Grass::new, 2, 12);
		
		level.grid.createTile(TileCreator::createNull, 3, 10);
		level.grid.createTile(Key::new, 14, 14);
		
		interactTiles[0] = level.grid.createTile(Chest::new, 14, 9);

		return level;
	}
}
