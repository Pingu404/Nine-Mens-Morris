import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, Position> positions;

    public Board() {
        positions = new HashMap<>();
        // Initialize positions
        for (int i = 1; i <= 24; i++) {
            positions.put(i, new Position(i));
        }
    }
//method to place a piece on the board
    public boolean placePiece(int pos, Piece piece) {
        Position position = positions.get(pos);
        if (position.isOccupied()) {
            return false;
            //return false if the position is already occupied
        }
        position.setPiece(piece);
        return true;
    }
//method to move a piece on the board
    public boolean movePiece(int fromPos, int toPos) {
        Position fromPosition = positions.get(fromPos);
        //get the position of the piece to move from
        Position toPosition = positions.get(toPos);
        if (!fromPosition.isOccupied() || toPosition.isOccupied()) {
            return false;
            //return false if the from position is not occupied or the to position is already occupied
        }
        toPosition.setPiece(fromPosition.getPiece());
        fromPosition.setPiece(null);
        return true;
    }

  //static variable for all the possible mills (through position) on the board
  	private static final int[][] MILLS = {
  			{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}, {13,14,15}, {16,17,18}, {19,20,21}, {22,23,24}, 
  			{1,10,22}, {4,11,19}, {7,12,16}, {2,5,8}, {17,20,23}, {14,11,8}, {3,6,9}, {18,21,24}, 
  			{13,10,7}, {22,23,24}, {19,20,21}, {16,17,18}
  	};

  //check board for if there is a mill
  	public boolean isMill(int pos, Piece piece) {
  		for (int[] mill : MILLS) {
  			if(mill[0] == pos || mill[1] == pos || mill[2] == pos) {
  				if(positions.get(mill[0]).getPiece() == piece &&
  						positions.get(mill[1]).getPiece() == piece &&
  						positions.get(mill[2]).getPiece() == piece) {
                            //check if all the positions in the mill have the same piece
  					return true;
  				}
  			}
  		}
  		return false;
  	}

//method to remove a piece from the board
    public Position getPosition(int pos) {
        return positions.get(pos);
    }
}
