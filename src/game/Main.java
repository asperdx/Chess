package game;

import graphics.GUI;
import graphics.GraphicsController;
import java.util.Scanner;


/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner input = new Scanner(System.in);
        GUI screen = new GUI(60);
        GraphicsController Control = new GraphicsController();
        while (game.gameRunning){
            System.out.printf("Make a move: ");
            String move = input.nextLine();
            game.makeMove(move);
            Control.updateBoard(game.getBoard());
            
        }


    }
}
