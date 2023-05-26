package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import tile.*;

public class Canvas extends JPanel {
	Game game;

	public Canvas(Game game) {
		this.game = game;

		InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = this.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke('a'), "moveLeft");
		actionMap.put("moveLeft", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (game.isPaused) {return;}
				for (int i = 0; i < 10; i++) {
					game.player.x -= 1;
					if (game.currentLevel.grid.getCollidingWith(game.player) != null) {
						game.player.x += 1;
						break;
					}
				}
			}
		});

		inputMap.put(KeyStroke.getKeyStroke('d'), "moveRight");
		actionMap.put("moveRight", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (game.isPaused) {return;}
				for (int i = 0; i < 10; i++) {
					game.player.x += 1;
					if (game.currentLevel.grid.getCollidingWith(game.player) != null) {
						game.player.x -= 1;
						break;
					}
				}
			}
		});

		inputMap.put(KeyStroke.getKeyStroke("SPACE"), "jump");
		actionMap.put("jump", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (game.isPaused) {return;}
				if (game.player.tile != null) {
					game.player.setVelocityY(-150);
					game.player.isJumping = true;
				}
			}
		});

		inputMap.put(KeyStroke.getKeyStroke('e'), "interact");
		actionMap.put("interact", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (game.isPaused) {return;}
				Tile shortestDistanceTile = game.currentLevel.interactTiles[0];
				double shortestDistance = PhysicsUtilities.distance(game.player, shortestDistanceTile);
				
				for (Tile interactTile : game.currentLevel.interactTiles) {
					double thisDistance = PhysicsUtilities.distance(game.player, interactTile);
					if (thisDistance < shortestDistance) {
						shortestDistance = thisDistance;
						shortestDistanceTile = interactTile;
					}
				}
								
				if (shortestDistance < 100) {
					shortestDistanceTile.onInteract(game);
				}
			}
		});

		inputMap.put(KeyStroke.getKeyStroke('r'), "restart");
		actionMap.put("restart", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				game.restartLevel();
			}
		});

		inputMap.put(KeyStroke.getKeyStroke('q'), "quit");
		actionMap.put("quit", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				game.quitLevel();
			}
		});

		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "pause");
		actionMap.put("pause", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (game.isPaused) {
					game.resume();
					return;
				}

				game.pause();
				game.canvas.repaint();
			}
		});
	}

	public Dimension getPreferredSize() {
		return new Dimension(512, 512);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.player.paint(g);
		game.currentLevel.grid.paint(g);
		for (Entity entity : game.currentLevel.entities) {
			if (entity == null) {continue;}
			entity.paint(g);
		}
		if (game.isPaused) {
			game.paintPausePanel(g);
		}
	}
}
