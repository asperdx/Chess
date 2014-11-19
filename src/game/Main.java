package game;

import java.util.Scanner;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner input = new Scanner(System.in);


        while (game.gameRunning){
            System.out.printf("Make a move: ");
            String move = input.nextLine();
            game.makeMove(move);
        }


    }
}
