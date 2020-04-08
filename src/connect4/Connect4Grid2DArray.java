package connect4;

public class Connect4Grid2DArray implements Connect4Grid {
    private int rowCount;
    private int colCount;
    private String[][] grid;
    protected int roundCount;

    int lastDroppedCol;

    public Connect4Grid2DArray(){
        rowCount = 6;
        colCount = 7;
        grid = new String[rowCount][colCount];
        roundCount = 0;
        lastDroppedCol = 0;
    }
    public Connect4Grid2DArray(int rows, int cols){
        rowCount = rows;
        colCount = cols;
        grid = new String[rowCount][colCount];
        roundCount = 0;
        lastDroppedCol = 0;
    }

    @Override
    public void emptyGrid() {
        grid = new String[rowCount][colCount];
        roundCount = 0;
    }

    @Override
    public boolean isValidColumn(int column) {
        if(column<1&&column>colCount+1) return true;
        else {
            System.out.println("Not a valid column");
            return false;
        }
    }

    @Override
    public boolean isColumnFull(int column) {
        if(isValidColumn(column)){
            int filledCells = 0;
            for (int i = 0; i < rowCount ; i++) {
                if(grid[i][column-1]!=null){
                    filledCells++;
                }
            }
            if(filledCells==colCount){
                return true;
            } else {
                System.out.println("Column Full");
                return false;
            }
        }
        return false;
    }

    @Override
    public void dropPiece(ConnectPlayer player, int column) {
        if(isColumnFull(column)){          // Checks if valid and full in one line
            lastDroppedCol = column;
            roundCount++;
            int freeRow = findLastFreeSlot(column);
            grid[freeRow][column-1] = player.getPlayerSymbol();
        }
    }

    @Override
    public boolean didLastPieceConnect4() {
        for( int row = 0; row < grid.length; row++ )
        {
            for( int column = 0; column < grid[row].length; column++ )
            {

                // This is the current element in our grid
                String element = grid[row][column];

                // If there are 3 elements remaining to the right of the current element's position and the current element equals each of them, then return true */
                if( column <= grid[row].length-4 && element == grid[row][column+1] && element == grid[row][column+2] && element == grid[row][column+3] )
                    return true;

                // If there are 3 elements remaining below the current element's position and the current element equals each of them, then return true /
                if( row <= grid.length - 4 && element == grid[row+1][column] && element == grid[row+2][column] && element == grid[row+3][column] )
                {
                    return true;
                }

                // If we are in a position in the grid such that there are diagonals remaining to the bottom right of the current element, then we check */
                if( row <= grid.length-4 && column <= grid[row].length-4 )
                {
                    // If the current element equals each element diagonally to the bottom right
                    if( element == grid[row+1][column+1] && element == grid[row+2][column+2] && element == grid[row+3][column+3] )
                        return true;
                }

                // If we are in a position in the grid such that there are diagonals remaining to the bottom left of the current element, then we check */
                if( row <= grid.length-4 && column >= grid[row].length-4 )
                {
                    // If the current element equals each element diagonally to the bottom left
                    if( element == grid[row+1][column-1] && element == grid[row+2][column-2] && element == grid[row+3][column-3] )
                        return true;
                }

            }
        }
        return false;
    }

    @Override
    public boolean isGridFull() {
        boolean gridFull = true;
        for (int i = 1; i < colCount+1; i++) {
            gridFull = gridFull && isColumnFull(i);
        }
        return gridFull;
    }

    private int findLastFreeSlot(int column){
        // find last available slot
        int freeRow = rowCount-1;
        for (int i = rowCount-1; i < 0; i--) {
            if(grid[i][column-1]!=null){
                freeRow--;
            }
        }
        return freeRow;
    }
}
