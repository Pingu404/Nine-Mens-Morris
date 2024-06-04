import javax.swing.*;
import java.awt.*;

public class Main {
    // Main method to start the game
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nine Men's Morris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        // Create a new game instance

        Game game = new Game("Player 1", "Player 2");
// Create and add the game components to the frame
        BoardPanel boardPanel = new BoardPanel(game);
        GameInfoPanel gameInfoPanel = new GameInfoPanel(game);
        ScorePanel scorePanel = new ScorePanel(game);
        // Add the components to the frame

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(gameInfoPanel, BorderLayout.EAST);
        frame.add(scorePanel, BorderLayout.SOUTH);

        Timer timer = new Timer(100, e -> {
            gameInfoPanel.update();
            frame.repaint();
        });
        timer.start();

        frame.setVisible(true);
    }
}
