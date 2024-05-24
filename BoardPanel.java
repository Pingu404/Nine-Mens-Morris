import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class BoardPanel extends JPanel{
	public static final int BOARD_SIZE = 500;
	public static final int PADDING = 50;
	
	private Board board;
	private Game game;
	
	public BoardPanel() {
		this.board = new Board();
		//this.game = new Game("P1", "P2");
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e.getX(), e.getY());
			}
		});
	}
	
	private void handleMouseClick(int x, int y) {
		//Translate mouse click to board position
		//Handle piece placement or movement based on game phase
		//Update the game state and repaint board
		
		int pos = translateClickToPosition(x, y);
		if (pos != -1) {
			// game.handleUserAction(pos);
			repaint();
		}
	}
	
	private int translateClickToPosition(int x, int y) {
		return -1;
		//placeholder
		//implement logic to map place x/y coordinates to board positions

	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoard(g);
		drawPieces(g);
	}
	
	public void drawBoard(Graphics g) {
		g.setColor(Color.BLACK);
		int[][] lines = {
				{PADDING, PADDING, BOARD_SIZE - PADDING, PADDING},
				{PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING},
				{PADDING, PADDING, PADDING, BOARD_SIZE - PADDING},
				{BOARD_SIZE - PADDING, PADDING, BOARD_SIZE - PADDING, BOARD_SIZE - PADDING},
				
				{PADDING, BOARD_SIZE/2, BOARD_SIZE/2 - PADDING, BOARD_SIZE/2},
				{BOARD_SIZE/2 + PADDING, BOARD_SIZE/2, BOARD_SIZE - PADDING, BOARD_SIZE/2},
				{BOARD_SIZE/2, PADDING, BOARD_SIZE/2, BOARD_SIZE/2 - PADDING}, 
				{BOARD_SIZE, BOARD_SIZE/2 + PADDING, BOARD_SIZE/2, BOARD_SIZE - PADDING},
				{PADDING, PADDING, BOARD_SIZE/2 - PADDING, BOARD_SIZE/2 - PADDING},
				{BOARD_SIZE - PADDING, PADDING, BOARD_SIZE/2 + PADDING, BOARD_SIZE/2 + PADDING},
				{PADDING, BOARD_SIZE - PADDING, BOARD_SIZE/2 - PADDING, BOARD_SIZE/2 + PADDING},
				{BOARD_SIZE - PADDING, BOARD_SIZE - PADDING, BOARD_SIZE/2 + PADDING, BOARD_SIZE/2 - PADDING}	
		};
		
		for (int[] line : lines) {
			g.drawLine(line[0], line[1], line[2], line[3]);
		}
	}
	
	public void drawPieces (Graphics g) {
		for (int i = 1; i <= 24; i++) {
			Position pos = board.getPosition(i);
			if(pos.isOccupied()) {
				Piece piece = (Piece) pos.getPiece();
				int [] coords = getPositionCoordinates(i);
				
				if (piece.getSymbol() == 'X') {
					g.setColor(Color.RED);
				}else {
					g.setColor(Color.BLUE);
				}
				g.fillOval(coords[0] - 10, coords[1]-10, 20, 30);
			}
		}
	}
	
	private int[] getPositionCoordinates (int pos){
		switch(pos) {
		case 1: return new int[] {PADDING, PADDING};
		case 2: return new int[] {BOARD_SIZE/2, PADDING};
		case 3: return new int[] {BOARD_SIZE - PADDING, PADDING};
		// add remaining cases for positions 4-24
		default: return new int[] {0,0};
		}
	}
	
}
