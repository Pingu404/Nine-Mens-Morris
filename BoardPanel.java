import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    public static final int BOARD_SIZE = 500;
    public static final int PADDING = 50;
    public static final int INNER_PADDING = 150;

    private Game game;
    private JButton[] buttons;

    public BoardPanel(Game game) {
        this.game = game;
        this.buttons = new JButton[24];

        setLayout(null); // Use absolute positioning

        for (int i = 0; i < 24; i++) {
            buttons[i] = new JButton();
            buttons[i].setBounds(getPositionCoordinates(i + 1)[0] - 15, getPositionCoordinates(i + 1)[1] - 15, 30, 30);
            buttons[i].setOpaque(true);
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBorderPainted(true);
            buttons[i].setBackground(Color.GRAY);
            int pos = i + 1;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(pos);
                }
            });
            add(buttons[i]);
        }
    }

    private void handleButtonClick(int pos) {
        game.handleUserAction(pos);
        updateBoard();
    }

    private int[] getPositionCoordinates(int pos) {
        switch (pos) {
            case 1: return new int[]{PADDING, PADDING};
            case 2: return new int[]{BOARD_SIZE / 2, PADDING};
            case 3: return new int[]{BOARD_SIZE - PADDING, PADDING};
            case 4: return new int[]{INNER_PADDING, INNER_PADDING};
            case 5: return new int[]{BOARD_SIZE / 2, INNER_PADDING};
            case 6: return new int[]{BOARD_SIZE - INNER_PADDING, INNER_PADDING};
            case 7: return new int[]{PADDING + INNER_PADDING, PADDING + INNER_PADDING};
            case 8: return new int[]{BOARD_SIZE / 2, PADDING + INNER_PADDING};
            case 9: return new int[]{BOARD_SIZE - PADDING - INNER_PADDING, PADDING + INNER_PADDING};
            case 10: return new int[]{PADDING, BOARD_SIZE / 2};
            case 11: return new int[]{INNER_PADDING, BOARD_SIZE / 2};
            case 12: return new int[]{PADDING + INNER_PADDING, BOARD_SIZE / 2};
            case 13: return new int[]{BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE / 2};
            case 14: return new int[]{BOARD_SIZE - INNER_PADDING, BOARD_SIZE / 2};
            case 15: return new int[]{BOARD_SIZE - PADDING, BOARD_SIZE / 2};
            case 16: return new int[]{PADDING + INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING};
            case 17: return new int[]{BOARD_SIZE / 2, BOARD_SIZE - PADDING - INNER_PADDING};
            case 18: return new int[]{BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING};
            case 19: return new int[]{INNER_PADDING, BOARD_SIZE - INNER_PADDING};
            case 20: return new int[]{BOARD_SIZE / 2, BOARD_SIZE - INNER_PADDING};
            case 21: return new int[]{BOARD_SIZE - INNER_PADDING, BOARD_SIZE - INNER_PADDING};
            case 22: return new int[]{PADDING, BOARD_SIZE - PADDING};
            case 23: return new int[]{BOARD_SIZE / 2, BOARD_SIZE - PADDING};
            case 24: return new int[]{BOARD_SIZE - PADDING, BOARD_SIZE - PADDING};
            default: return new int[]{0, 0};
        }
    }

    private void updateBoard() {
        for (int i = 0; i < 24; i++) {
            Position pos = game.getBoard().getPosition(i + 1);
            if (pos.isOccupied()) {
                Piece piece = pos.getPiece();
                if (piece.getSymbol() == 'X') {
                    buttons[i].setBackground(Color.WHITE);
                } else {
                    buttons[i].setBackground(Color.BLACK);
                }
            } else {
                buttons[i].setBackground(Color.GRAY);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    public void drawBoard(Graphics g) {
        g.setColor(Color.BLACK);
        int[][] lines = {
            {PADDING, PADDING, BOARD_SIZE - PADDING, PADDING},
            {PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING},
            {PADDING, PADDING, PADDING, BOARD_SIZE - PADDING},
            {BOARD_SIZE - PADDING, PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING},
            
            {INNER_PADDING, INNER_PADDING, BOARD_SIZE - INNER_PADDING, INNER_PADDING},
            {INNER_PADDING, BOARD_SIZE - INNER_PADDING, BOARD_SIZE - INNER_PADDING, BOARD_SIZE - INNER_PADDING},
            {INNER_PADDING, INNER_PADDING, INNER_PADDING, BOARD_SIZE - INNER_PADDING},
            {BOARD_SIZE - INNER_PADDING, INNER_PADDING, BOARD_SIZE - INNER_PADDING, BOARD_SIZE - INNER_PADDING},
            
            {PADDING + INNER_PADDING, PADDING + INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING, PADDING + INNER_PADDING},
            {PADDING + INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING},
            {PADDING + INNER_PADDING, PADDING + INNER_PADDING, PADDING + INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING},
            {BOARD_SIZE - PADDING - INNER_PADDING, PADDING + INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING},
            
            {PADDING, BOARD_SIZE / 2, PADDING + INNER_PADDING, BOARD_SIZE / 2},
            {BOARD_SIZE - PADDING, BOARD_SIZE / 2, BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE / 2},
            {PADDING + INNER_PADDING, PADDING, PADDING + INNER_PADDING, PADDING + INNER_PADDING},
            {PADDING + INNER_PADDING, BOARD_SIZE - PADDING, PADDING + INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING},
            {BOARD_SIZE - PADDING - INNER_PADDING, PADDING, BOARD_SIZE - PADDING - INNER_PADDING, PADDING + INNER_PADDING},
            {BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING - INNER_PADDING},
            {PADDING + INNER_PADDING, PADDING, PADDING + INNER_PADDING, INNER_PADDING},
            {PADDING + INNER_PADDING, BOARD_SIZE - PADDING, PADDING + INNER_PADDING, BOARD_SIZE - INNER_PADDING},
            {BOARD_SIZE - PADDING - INNER_PADDING, PADDING, BOARD_SIZE - PADDING - INNER_PADDING, INNER_PADDING},
            {BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING - INNER_PADDING, BOARD_SIZE - INNER_PADDING}
        };

        for (int[] line : lines) {
            g.drawLine(line[0], line[1], line[2], line[3]);
        }
    }
}
