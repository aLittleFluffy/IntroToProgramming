package connect4;

import java.util.Scanner;

abstract class ConnectPlayer {
    private String playerSymbol;
    String getPlayerSymbol(){
        return playerSymbol;
    }
    void setPlayerSymbol(String playerSymbol){
        this.playerSymbol = playerSymbol;
    }
    abstract int selectCol(int maxCols);
    boolean checkWin(Connect4Grid grid){
        return grid.didLastPieceConnect4();
    }
    static int getUserInt(String message){
        int selected = 0;
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        if(input.hasNextInt()){
            int select = input.nextInt();
            input.close();
            return select;
        } else return getUserInt(message);
    }

}
