package connect4;

import java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args) {
        boolean quit = false;
        Connect4Grid2DArray grid = new Connect4Grid2DArray();
        do {
            if(!grid.isGridFull()){
                // game setup
                if(grid.roundCount==0){
                    // Setup

                } else {
                    // game logic

                }
            }
        } while (!quit);
    }
    private static String readStringInput(String message){
        try{
            System.out.println(message);
            Scanner inputParser = new Scanner(System.in);
            if(inputParser.hasNext()){
                return inputParser.next();
            } else return readStringInput(message);
        } catch (Exception e){
            System.err.println(e);
            return readStringInput(message);
        }
    }
}
