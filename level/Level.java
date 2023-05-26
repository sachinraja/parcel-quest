package level;

import main.*;
import tile.*;

public class Level {
	public Grid grid;
	public Tile[] interactTiles;
	public Entity[] entities;

	public Level(Game game) {
		this.grid = new Grid(game);
		this.interactTiles = new Tile[0];
		this.entities = new Entity[0];
	}
}
