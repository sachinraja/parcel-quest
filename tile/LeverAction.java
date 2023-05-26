package tile;

@FunctionalInterface
public interface LeverAction {
	void onActiveChanged(boolean active);
}
