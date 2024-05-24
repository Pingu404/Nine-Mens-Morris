import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class Board {
	public Map<Integer, Position> positions;
	
	public Board() {
		positions = new HashMap<>();
		//Initialize positions
		for (int i = 0; i < 24; i++) {
			positions.put(i, new Position(i));
		}
		
		
	}
	
	public boolean placePiece(int pos, Piece piece) {
		Position position = positions.get(pos);
		if (position.isOccupied()) {
			return false;
		}
		position.setPiece(piece);
		return true;
	}
	
	public boolean movePiece(int fromPos, int toPos) {
		Position fromPosition = positions.get(fromPos);
		Position toPosition = positions.get(toPos);
		if (!fromPosition.isOccupied() || toPosition.isOccupied()) {
			return false;
		}
		toPosition.setPiece(fromPosition.getPiece());
		fromPosition.setPiece(null);
		return true;
	}
	
	public boolean isMill(int pos, Piece piece) {
		//Implement logic to check if placing a piece at position 'pos' forms a mill
		//involves checking rows and columns of the board for three consecutive pieces
		
		return false;
	}
	
	public Position getPosition(int pos)
	{
		return positions.get(pos);
	}
}
