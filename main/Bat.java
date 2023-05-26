package main;

import java.awt.*;

public class Bat extends Entity {
    private static final Image image = AssetManager.getAsset("assets/bat.png");

    public Bat(float x, float y) {
        super(x, y, 48, 30);
    }
    
    public void onTimer(Game game) {
    	if (x < game.player.x) {
    		x += 1;
    	} else if (x > game.player.x) {
    		x -= 1;
    	}
    	
    	if (y < game.player.y) {
    		y += 1;
    	} else if (y > game.player.y) {
    		y-= 1;
    	}
    	
    	if (this.isCollidingWith(game.player)) {
    		game.restartLevel();
    	}
    }

    public void paint(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);
    }
}