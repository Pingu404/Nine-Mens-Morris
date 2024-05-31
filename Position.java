public class Position {
    private int id;
    private Piece piece;

    public Position(int id) {
        this.id = id;
        this.piece = null;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getId() {
        return id;
    }
}
