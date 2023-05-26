package main;

import javax.swing.Timer;
import level.*;
import java.awt.*;

public class Game {
  public Player player;
  public Canvas canvas;
  public LevelSelectPanel levelSelectPanel;
  public LevelCreator[] levels;
  public int currentLevelIndex = 0;
  public Level currentLevel;
  public Timer timer = new Timer(30, new GameTimer(this));
  public boolean isPaused = false;

  public Game() {
	  this.player = new Player();
	  this.canvas = new Canvas(this);
	  this.canvas.setVisible(false);

	  this.levels = new LevelCreator[] {
			  new Level1(),
			  new Level2(),
			  new Level3(),
			  new Level4(),
			  new Level5(),
			  new Level6(),
			  new Level7()
	  };
	  this.levelSelectPanel = new LevelSelectPanel(this);
  }
  
  public void setLevel(int levelIndex) {
	  currentLevelIndex = levelIndex;
	  this.currentLevel = levels[levelIndex].create(this);
	  this.levelSelectPanel.setVisible(false);
	  this.canvas.setVisible(true);
	  this.canvas.repaint();
	  this.startTimers();
	  this.isPaused = false;
  }

  public void completeLevel() {
	  this.levelSelectPanel.levelButtons[this.currentLevelIndex].setBackground(Color.GREEN);
	  this.quitLevel();
  }

  public void quitLevel() {
	  this.pauseTimers();
	  this.canvas.setVisible(false);
	  this.levelSelectPanel.setVisible(true);
	  this.player.reset();
  }

	public void restartLevel() {
	  this.player.reset();
	  this.setLevel(currentLevelIndex);
	}

  public void pause() {
	  this.pauseTimers();
	  isPaused = true;
  }

  public void resume() {
	  isPaused = false;
	  this.startTimers();
  }
  
  public void startTimers() {
	  timer.start();
  }
  
  public void pauseTimers() {
	  timer.stop();
  }

  public void paintPausePanel(Graphics g) {
	  int width = 200;
	  int height = 100;
	  int pauseMenuStartX = canvas.getPreferredSize().width / 2 - width / 2;
	  int pauseMenuStartY = canvas.getPreferredSize().height / 2 - height / 2;
	  g.setColor(Color.white);
	  g.fillRect(pauseMenuStartX, pauseMenuStartY, width, height);

	  g.setColor(Color.black);
	  g.drawRect(pauseMenuStartX, pauseMenuStartY, width, height);

	  g.setColor(Color.black);
	  g.drawString("r - Restart", pauseMenuStartX + 20, pauseMenuStartY + 20);
	  g.drawString("q - Quit", pauseMenuStartX + 20, pauseMenuStartY + 40);
	  g.drawString("escape - Resume", pauseMenuStartX + 20, pauseMenuStartY + 60);

  }
}
