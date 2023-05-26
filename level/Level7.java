package level;

import main.Bat;
import main.Entity;
import main.Game;
import tile.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class Level7 implements LevelCreator {
    public Level create(Game game) {
        Level level = new Level(game);
        Tile[] interactTiles = new Tile[3];
        level.interactTiles = interactTiles;
        Entity[] entities = new Entity[1];
        level.entities = entities;

        game.player.y = 12 * Tile.SIZE;

        level.grid.createArea(Grass::new, 0, 14, 15, 14);
        level.grid.createArea(Dirt::new, 0, 15, 15, 15);
        level.grid.createArea(TileCreator::createNull, 6, 14, 8, 14);
        level.grid.createArea(Sewage::new, 6, 15, 8, 15);
        level.grid.createTile(Box::new, 14, 13);
        level.grid.createTile(Box::new, 15, 13);
        level.grid.createTile(Box::new, 15, 12);

        level.grid.createArea(Dirt::new, 3, 11, 12, 11);
        level.grid.createArea(Grass::new, 4, 10, 12, 10);
        level.grid.createArea(Sewage::new, 6, 10, 8, 10);
        level.grid.createArea(Dirt::new, 0, 8, 1, 8);
        level.grid.createTile(Grass::new, 0, 7);

        level.grid.createArea(Grass::new, 4, 6, 9, 6);
        level.grid.createTile(Box::new, 8, 5);
        level.grid.createTile(Box::new, 9, 5);
        level.grid.createTile(Box::new, 9, 4);
        level.grid.createTile(Key::new, 8, 4);

        level.grid.createTile(Grass::new, 11, 2);
        level.grid.createTile(Dirt::new, 15, 1);

        interactTiles[0] = level.grid.createTile(Chest::new, 15, 0);
        Lever lever = level.grid.createTile((x, y) -> new Lever(x, y, (active) -> {
            TileCreator<?> standingChainsTileCreator = Chain::new;
            TileCreator<?> bridgeChainsTileCreator = TileCreator::createNull;

            if (active) {
                standingChainsTileCreator = TileCreator::createNull;
                bridgeChainsTileCreator = Chain::new;
                entities[0] = new Bat(15 * Tile.SIZE, 0);
            } else {
                entities[0] = null;
            }

            level.grid.createArea(standingChainsTileCreator, 5, 12, 5, 13);
            level.grid.createArea(bridgeChainsTileCreator, 6, 14, 7, 14);
        }), 3, 13);
        interactTiles[1] = lever;
        lever.action.onActiveChanged(false);

        interactTiles[2] = level.grid.createTile((x, y) -> new Lever(x, y, (active) -> {
            TileCreator<?> tileCreator = TileCreator::createNull;

            if (active) {
                tileCreator = Box::new;
            }

            level.grid.createTile(tileCreator, 1, 12);
        }), 10, 9);


        return level;
    }
}
