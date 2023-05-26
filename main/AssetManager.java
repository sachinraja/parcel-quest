package main;

import java.util.HashMap;
import java.awt.*;

public class AssetManager {
  static HashMap<String, Image> assets = new HashMap<>();

  public static Image getAsset(String path) {
    Image image = assets.get(path);
    if (image != null) {
      return image;
    }

    Image loadedImage = Toolkit.getDefaultToolkit().createImage(path);
    assets.put(path, loadedImage);
    return loadedImage;
  }
}