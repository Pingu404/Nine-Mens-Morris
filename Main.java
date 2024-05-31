import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nine Men's Morris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        Game game = new Game("Player 1", "Player 2");

        BoardPanel boardPanel = new BoardPanel(game);
        GameInfoPanel gameInfoPanel = new GameInfoPanel(game);
        ScorePanel scorePanel = new ScorePanel(game);

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
