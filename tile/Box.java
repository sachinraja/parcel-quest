package tile;

import main.AssetManager;
import java.awt.*;

public class Box extends Tile {
    private static final Image image = AssetManager.getAsset("assets/tiles/box.png");
    public Box(int gridX, int gridY) {
        super(gridX, gridY, image);
    }
}