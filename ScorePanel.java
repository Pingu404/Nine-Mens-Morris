import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel {
    private JLabel player1ScoreLabel;
    private JLabel player2ScoreLabel;
    private JButton replayButton;

    private Game game;
    private int player1Score;
    private int player2Score;

    public ScorePanel(Game game) {
        this.game = game;
        this.player1Score = 0;
        this.player2Score = 0;

        player1ScoreLabel = new JLabel("Player 1 Score: 0");
        player2ScoreLabel = new JLabel("Player 2 Score: 0");
        replayButton = new JButton("Replay");

        replayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement replay functionality
                game.reset();
            }
        });

        add(player1ScoreLabel);
        add(player2ScoreLabel);
        add(replayButton);
    }

    public void updateScores(int p1Score, int p2Score) {
        this.player1Score = p1Score;
        this.player2Score = p2Score;
        player1ScoreLabel.setText("Player 1 Score: " + player1Score);
        player2ScoreLabel.setText("Player 2 Score: " + player2Score);
    }
}
