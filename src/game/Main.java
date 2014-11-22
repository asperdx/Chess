package game;

import graphics.GUI;

import java.util.Scanner;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Main {
    private static GUI gui;
    private static String version = "0.3";
    private static Game game;
    public static void main(String[] args) {
        game = new Game();
        Scanner input = new Scanner(System.in);
        gui = new GUI(80);
        gui.getGraphicsControl().updateBoard(game.getBoard());
        while (game.gameRunning){
            System.out.printf("Make a move: ");
            String move = input.nextLine();
            game.makeMove(move, true);
            
        }

    }
    public static GUI getGui() {
        return gui;
    }   

    public static String getVersion() {
        return version;
    }

    public static Game getGame() {
        return game;
    }
    
}   
