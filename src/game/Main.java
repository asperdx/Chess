package game;

import java.util.Scanner;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner input = new Scanner(System.in);

        while (game.gameRunning){
            game.newTurn();
            System.out.printf("Make a move: ");
            String move = input.nextLine();
        }


    }
}
