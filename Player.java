@SuppressWarnings("hiding")
public class Player<Piece> {
	private String name;
	private Piece pieceType;
	private int remainingPieces;
	private int piecesOnBoard;
	
	public Player(String name, Piece pieceType) {
		this.name = name;
		this.pieceType = pieceType;
		this.remainingPieces = 9;
		this.piecesOnBoard = 0;
		
	}
	
	public String getName() {
		return name;
	}
	public Piece getPieceType() {
		return pieceType;
	}
	public int getRemainingPieces() {
		return remainingPieces;
	}
	public void decrementRemainingPieces() {
		remainingPieces--;
	}
	public void incrementPiecesOnBoard() {
		piecesOnBoard++;
	}
	public int getPiecesOnBoard() {
		return piecesOnBoard;
	}
	public void decrementPiecesOnBoard() {
		piecesOnBoard--;
	}
}
