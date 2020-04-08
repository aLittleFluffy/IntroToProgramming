package connect4;

public class C4HumanPlayer extends ConnectPlayer {
    public C4HumanPlayer(String symbol){
        setPlayerSymbol(symbol);
    }
    public C4HumanPlayer(){
        setPlayerSymbol("O");
    }
    @Override
    int selectCol(int maxCols) {
        // Logic to select column
        int selectedCol = 0;
        do{
            selectedCol = C4HumanPlayer.getUserInt("Select a column to drop into: ");
        } while(selectedCol<1 && selectedCol>maxCols);
        return selectedCol;
    }
}
