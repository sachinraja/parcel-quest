package tile;

import main.AssetManager;
import java.awt.*;

public class Chain extends Tile {
    private static final Image image = AssetManager.getAsset("assets/tiles/chain.png");
    public Chain(int gridX, int gridY) {
        super(gridX, gridY, image);
    }
}