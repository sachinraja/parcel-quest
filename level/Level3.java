package level;

import main.Game;
import tile.*;

public class Level3 implements LevelCreator {
	public Level create(Game game) {
		Level level = new Level(game);
		Tile[] interactTiles = new Tile[2];
		level.interactTiles = interactTiles;

		level.grid.createArea(Dirt::new, 0, 4, 12, 4);
		level.grid.createArea(Grass::new, 12, 10, 14, 10);

		level.grid.createArea(Dirt::new, 7, 9,10, 9);
		level.grid.createArea(Dirt::new, 3, 8,4, 8);

		level.grid.createTile(Key::new, 0, 7);
		level.grid.createArea(Grass::new, 0, 8, 1, 8);

		level.grid.createArea(Dirt::new, 7, 11,10, 11);
		level.grid.createArea(Dirt::new, 3, 12, 4, 12);

		interactTiles[0] = level.grid.createTile(Chest::new, 0, 12);
		level.grid.createArea(Grass::new, 0, 13, 1, 13);

		Lever lever = level.grid.createTile((x, y) -> {
			return new Lever(x, y, (active) -> {
				TileCreator<?> keyChainsTileCreator;
				TileCreator<?> chestChainsTileCreator;

				if (active) {
					keyChainsTileCreator = TileCreator::createNull;
					chestChainsTileCreator = Chain::new;
				} else {
					keyChainsTileCreator = Chain::new;
					chestChainsTileCreator = TileCreator::createNull;
				}

				level.grid.createArea(keyChainsTileCreator, 1, 5, 1, 7);
				level.grid.createArea(chestChainsTileCreator, 1, 9, 1, 12);
			});
		}, 1, 3);
		interactTiles[1] = lever;
		lever.action.onActiveChanged(false);

		return level;
	}
}
