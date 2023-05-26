package tile;

@FunctionalInterface
public interface TileCreator<T extends Tile> {
    T create(int gridX, int gridY);
    static Tile createNull(int x, int y) {
        return null;
    }
}
