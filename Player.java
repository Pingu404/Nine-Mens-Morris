public class Player {
    private String name;
    private Piece pieceType;
    private int remainingPieces;
    private int piecesOnBoard;
    // Constructor

    public Player(String name, Piece pieceType) {
        this.name = name;
        this.pieceType = pieceType;
        this.remainingPieces = 9;
        this.piecesOnBoard = 0;
    }
    // Get the player's name

    public String getName() {
        return name;
    }
// Get the player's piece type
    public Piece getPieceType() {
        return pieceType;
    }
// Get the number of remaining pieces
    public int getRemainingPieces() {
        return remainingPieces;
    }
// Decrement the number of remaining pieces
    public void decrementRemainingPieces() {
        remainingPieces--;
    }

    public void incrementPiecesOnBoard() {
        piecesOnBoard++;
    }

    public int getPiecesOnBoard() {
        return piecesOnBoard;
    }
// Decrement the number of pieces on the board
    public void decrementPiecesOnBoard() {
        piecesOnBoard--;
    }
}
