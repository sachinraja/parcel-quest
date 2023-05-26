package level;

import main.Bat;
import main.Entity;
import main.Game;
import tile.*;

public class Level6 implements LevelCreator {
    public Level create(Game game) {
        Level level = new Level(game);
        Tile[] interactTiles = new Tile[3];
        level.interactTiles = interactTiles;
        Entity[] entities = new Entity[1];
        level.entities = entities;

        level.grid.createArea(Dirt::new,0, 0, 0, 15);

        level.grid.createArea(Grass::new, 2, 4, 3, 4);
        level.grid.createTile(Grass::new, 1, 8);
        level.grid.createArea(Grass::new, 2, 11, 3, 11);
        level.grid.createArea(Sewage::new, 1, 15, 2, 15);
        level.grid.createArea(Grass::new, 3, 15, 6, 15);
        level.grid.createTile(Sewage::new, 7, 15);

        level.grid.createArea(Dirt::new, 4, 0, 4, 12);

        level.grid.createTile(Grass::new, 7, 13);
        level.grid.createTile(Grass::new, 5, 11);
        level.grid.createTile(Grass::new, 7, 9);
        level.grid.createTile(Grass::new, 5, 7);
        level.grid.createTile(Grass::new, 7, 5);

        level.grid.createArea(Dirt::new, 8, 3, 8, 15);

        level.grid.createTile(Grass::new, 11, 11);
        level.grid.createTile(Key::new, 11, 10);

        level.grid.createArea(Dirt::new, 12, 0, 12, 12);

        interactTiles[0] = level.grid.createTile(Chest::new, 15, 14);
        level.grid.createArea(Grass::new, 11, 15, 15,15);
        interactTiles[1] = level.grid.createTile((x, y) -> new Lever(x, y, (active) -> {
            TileCreator<?> tileCreator = Dirt::new;

            if (active) {
                tileCreator = TileCreator::createNull;
            }

            level.grid.createTile(tileCreator, 8, 12);
        }), 1, 7);
        interactTiles[2] = level.grid.createTile((x, y) -> new Lever(x, y, (active) -> {
            TileCreator<?> tileCreator = Dirt::new;

            if (active) {
                tileCreator = TileCreator::createNull;
            }

            level.grid.createTile(tileCreator, 8, 11);
        }), 7, 8);

        entities[0] = new Bat(2 * Tile.SIZE, -100);
        return level;
    }
}
