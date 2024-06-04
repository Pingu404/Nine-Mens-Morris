public class Game {
    private Board board;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private int turnCount;
    private String phase; // "Placing", "Moving", "Removing"

    public Game(String player1Name, String player2Name) {
        this.board = new Board();
        this.p1 = new Player(player1Name, new Piece('X'));
        this.p2 = new Player(player2Name, new Piece('O'));
        this.currentPlayer = p1;
        this.turnCount = 0;
        this.phase = "Placing";
    }

    public void handleUserAction(int pos) {
        if (phase.equals("Placing")) {
            placePiece(pos);
        } else if (phase.equals("Moving")) {
        	 movePiece(pos, pos);
        } else if (phase.equals("Removing")) {
            removePiece(pos);
        }
    }

    private void placePiece(int pos) {
        Piece piece = currentPlayer.getPieceType();
        if (board.placePiece(pos, piece)) {
            currentPlayer.decrementRemainingPieces();
            currentPlayer.incrementPiecesOnBoard();
            turnCount++;
            checkMill(pos);
            switchPlayer();
            if (turnCount == 18) {
                phase = "Moving";
            }
        }
    }
    
    private void handleRemoving() {
        boolean removedPiece = false;
        while (!removedPiece) {
            int pos = getUserInput(); // Implement a method to get user input for the position
            if (currentPlayer.getPieceType() != getPiece(pos) && removePiece(pos)) {
                removedPiece = true;
            } else {
                System.out.println("Invalid position or not an opponent's piece. Try again.");
            }
        }
    }

    private Piece getPiece(int pos) {
        return board.getPosition(pos).getPiece();
    }

    private boolean isOpponentPiece(int pos) {
        return board.getPosition(pos).isOccupied() && board.getPosition(pos).getPiece().getSymbol() != currentPlayer.getPieceType().getSymbol();
    }

    private int getUserInput() {
        // Implement a method to get user input for the position
        return 0;
    }

    void movePiece(int fromPos, int toPos) {
        if (board.movePiece(fromPos, toPos)) {
            checkMill(toPos);
           
            switchPlayer();
        }
    }



    boolean removePiece(int pos) {
        Position position = board.getPosition(pos);
        if (position.isOccupied() && position.getPiece().getSymbol() != currentPlayer.getPieceType().getSymbol()) {
            Piece removedPiece = position.getPiece();
            position.setPiece(null);
            if (currentPlayer == p1) {
                p2.decrementPiecesOnBoard();
            } else {
                p1.decrementPiecesOnBoard();
            }
            phase = "Placing";
            switchPlayer();
        }
		return false;
    }

    private void checkMill(int pos) {
        if (board.isMill(pos, currentPlayer.getPieceType())) {
            phase = "Removing";
            BoardPanel.setCurrentPhase(phase);
        }
    }
    
    public void setPhase(String phase) {
        this.phase = phase;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == p1) ? p2 : p1;
    }

    public String getPhase() {
        return phase;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public Player getPlayer1() {
        return p1;
    }

    public Player getPlayer2() {
        return p2;
    }

    public void reset() {
        this.board = new Board();
        this.p1 = new Player(p1.getName(), new Piece('X'));
        this.p2 = new Player(p2.getName(), new Piece('O'));
        this.currentPlayer = p1;
        this.turnCount = 0;
        this.phase = "Placing";
        
    }
    
    
    
    
}
