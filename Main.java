import javax.swing.*;
import main.*;
import java.awt.*;

public class Main {
  private static final Game game = new Game();

  public static void main(String[] args) {
      SwingUtilities.invokeLater(Main::createAndShowGUI);
  }

  private static void createAndShowGUI() {
      JFrame f = new JFrame("Parcel Quest");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLayout(new FlowLayout());
      f.add(game.levelSelectPanel);
      f.add(game.canvas);
      f.pack();
      f.setVisible(true);
  }
}
