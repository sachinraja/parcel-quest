package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LevelSelectPanel extends JPanel {
    Game game;
    public JButton[] levelButtons;

    public LevelSelectPanel(Game game) {
        this.game = game;
        this.levelButtons = new JButton[game.levels.length];

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        add(titlePanel);

        JLabel levelsLabel = new JLabel("Levels");
        levelsLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
        levelsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(levelsLabel);

        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener((actionEvent) -> {
            JOptionPane.showInternalMessageDialog(null,"""
<html><body><p style='width: 200px;'>
You are tasked with finding all the keys and retrieving the items inside the chests to return to the "Parceler".
Each level will contain a key and a chest. Your job is to get the key and open the chest.
Press "e" when you are near a chest or a lever to "interact" with it (open the chest or flick the lever).
Opening a chest completes the level.
Controls: a - move left, d - move right, space - jump, e - interact (chest, lever), escape - pause, r - restart, q - quit.
</p></body></html>""",
                    "Instructions", JOptionPane.INFORMATION_MESSAGE);
        });
        titlePanel.add(instructionsButton);

        JPanel levelsPanel = new JPanel();
        levelsPanel.setLayout(new GridLayout(PhysicsUtilities.ceilDiv(game.levels.length, 4), 4));
        for (int i = 0; i < game.levels.length; i++) {
            JButton levelButton = new JButton("" + (i + 1));
            int finalI = i;
            levelButton.addActionListener(e -> game.setLevel(finalI));
            levelsPanel.add(levelButton);
            levelButtons[i] = levelButton;
            levelButton.setOpaque(true);
        }
        add(levelsPanel);
    }

    public Dimension getPreferredSize() {
        return new Dimension(512, 512);
    }
}
