package tile;

import main.AssetManager;
import main.Game;
import main.Player;
import main.Entity;
import java.awt.*;

public class Sewage extends Tile {
    private static final Image image = AssetManager.getAsset("assets/tiles/sewage.png");
    public Sewage(int gridX, int gridY) {
        super(gridX, gridY, image);
    }

    public void onCollisionEnter(Game game, Entity entity) {
        if (entity instanceof Player) {
            game.restartLevel();
        }
    }
}