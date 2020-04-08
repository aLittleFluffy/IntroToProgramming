package connect4;

public class C4ComputerPlayer extends ConnectPlayer {
    public C4ComputerPlayer(String symbol){
        setPlayerSymbol(symbol);
    }
    public C4ComputerPlayer(){
        setPlayerSymbol("X");
    }
    @Override
    int selectCol(int maxCols) {
        // Random column from 1-7
        return ((int) (Math.random()*(7)))+1;
    }
}
