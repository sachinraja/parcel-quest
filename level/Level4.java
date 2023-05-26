package level;

import main.Bat;
import main.Entity;
import main.Game;
import tile.*;

public class Level4 implements LevelCreator {
	public Level create(Game game) {
		Level level = new Level(game);
		Tile[] interactTiles = new Tile[2];
		level.interactTiles = interactTiles;
		Entity[] entities = new Entity[1];
		level.entities = entities;

		game.player.x = 50;
		game.player.y = 400;

		level.grid.createArea(Dirt::new, 0, 15, 3, 15);
		level.grid.createArea(Dirt::new, 3, 13, 6, 13);
		level.grid.createArea(Dirt::new, 6, 11, 9, 11);
		level.grid.createArea(Dirt::new, 3, 10, 6, 10);
		level.grid.createArea(Dirt::new, 0, 11, 0, 11);
		level.grid.createArea(Dirt::new, 9, 6, 9, 11);

		level.grid.createArea(Grass::new, 13, 4, 15, 4);
		level.grid.createTile(Key::new, 14, 3);

		interactTiles[0] = level.grid.createTile(Chest::new, 3, 14);
		interactTiles[1] = level.grid.createTile((x, y) -> {
			return new Lever(x, y, (active) -> {
				TileCreator<?> tileCreator = TileCreator::createNull;

				if (active) {
					tileCreator = Dirt::new;
				}

				level.grid.createArea(tileCreator, 4, 8, 4, 9);
			});
		}, 6, 9);

		entities[0] = new Bat(500, 500);
		return level;
	}
}
