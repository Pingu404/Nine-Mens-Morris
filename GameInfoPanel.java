import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class GameInfoPanel extends JPanel {
    private JLabel turnLabel;
    private JLabel currentPlayerLabel;
    private JLabel phaseLabel;
    private JLabel player1PiecesLabel;
    private JLabel player2PiecesLabel;

    private Game game;

    public GameInfoPanel(Game game) {
        this.game = game;
        setLayout(new GridLayout(5, 1));

        turnLabel = new JLabel("Turn: 0", SwingConstants.CENTER);
        currentPlayerLabel = new JLabel("Current Player: Player 1", SwingConstants.CENTER);
        phaseLabel = new JLabel("Phase: Placing", SwingConstants.CENTER);
        player1PiecesLabel = new JLabel("Player 1 Pieces Left: 9", SwingConstants.CENTER);
        player2PiecesLabel = new JLabel("Player 2 Pieces Left: 9", SwingConstants.CENTER);

        add(turnLabel);
        add(currentPlayerLabel);
        add(phaseLabel);
        add(player1PiecesLabel);
        add(player2PiecesLabel);

        update();
    }

    public void update() {
        turnLabel.setText("Turn: " + game.getTurnCount());
        currentPlayerLabel.setText("Current Player: " + game.getCurrentPlayer().getName());
        phaseLabel.setText("Phase: " + game.getPhase());
        player1PiecesLabel.setText("Player 1 Pieces Left: " + game.getPlayer1().getRemainingPieces());
        player2PiecesLabel.setText("Player 2 Pieces Left: " + game.getPlayer2().getRemainingPieces());
    }
}
