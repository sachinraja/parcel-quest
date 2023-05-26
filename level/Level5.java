package level;

import tile.*;
import main.*;

public class Level5 implements LevelCreator {
	public Level create(Game game) {
		Level level = new Level(game);
		Tile[] interactTiles = new Tile[3];
		level.interactTiles = interactTiles;
		Entity[] entities = new Entity[1];
		level.entities = entities;
		
		entities[0] = new Bat(100, 0);
	
		level.grid.createArea(Grass::new, 0, 4, 15, 4);
		level.grid.createArea(TileCreator::createNull, 12, 4, 13, 4);

		level.grid.createArea(Dirt::new, 0, 7, 15, 7);
		level.grid.createArea(Chain::new, 3, 5, 3, 6);


		level.grid.createArea(Dirt::new, 0, 10, 15, 10);
		level.grid.createArea(TileCreator::createNull, 1, 10, 2, 10);

		level.grid.createArea(Chain::new, 12, 8, 12, 9);

		level.grid.createTile(Key::new, 14, 9);
		interactTiles[0] = level.grid.createTile(Chest::new, 14, 14);
		interactTiles[1] = level.grid.createTile((x, y) -> new Lever(x, y, (active) -> {

			if (active) {
				level.grid.createArea(TileCreator::createNull, 3, 5, 3, 6);
				level.grid.createArea(TileCreator::createNull, 1, 7, 2, 7);
			} else {
				level.grid.createArea(Chain::new, 3, 5, 3, 6);
				level.grid.createArea(Dirt::new, 1, 7, 2, 7);
			}
   }), 5, 6);
		interactTiles[2] = level.grid.createTile((x, y) -> new Lever(x, y, (active) -> {
			if (active) {
				level.grid.createArea(TileCreator::createNull, 12, 8, 12, 9);
				level.grid.createArea(TileCreator::createNull, 13, 10, 14, 10);
			} else {
				level.grid.createArea(Chain::new, 12, 8, 12, 9);
				level.grid.createArea(Dirt::new, 13, 10, 14, 10);
			}
		}), 10, 9);

		return level;
	}
}
