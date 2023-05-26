package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer implements ActionListener {
	Game game;

	public GameTimer(Game game) {
		this.game = game;
	}

	public void actionPerformed(ActionEvent event) {
	    GridCollision collision = game.currentLevel.grid.getGridCollision(game.player);

		game.player.tile = collision.bottomTile;
		if (game.player.tile == null) {
			// gravity
			game.player.setVelocityY(game.player.velocityY + 5f);
		} else if (!game.player.isJumping) {
			game.player.velocityY = 0;
			game.player.y = game.player.tile.y - game.player.height - 1;
		}

		if (collision.collidingTile != null) {
	      collision.collidingTile.onCollisionEnter(game, game.player);
	    }
	    if (collision.bottomTile != null) {
	      collision.bottomTile.onCollisionEnter(game, game.player);
	    }
	    if (collision.topTile != null) {
	      collision.topTile.onCollisionEnter(game, game.player);
	    }

	    game.player.y += game.player.velocityY * 0.03;

	    if (collision.topTile != null) {
	      game.player.setVelocityY(Math.abs(game.player.velocityY));
	    }

	    game.player.isJumping = false;

	    for (Entity entity : game.currentLevel.entities) {
			if (entity == null) { continue; }
	    	entity.onTimer(game);
	    }
	    game.canvas.repaint();
	}
}
