package connect4;

public interface Connect4Grid {
     abstract void emptyGrid();
     abstract String toString();
     abstract boolean isValidColumn(int column);
     abstract boolean isColumnFull(int column);
     abstract void dropPiece(ConnectPlayer player, int column);
     abstract boolean didLastPieceConnect4();
     abstract boolean isGridFull();
}
