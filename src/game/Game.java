package game;
/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Game {

    public String turn;
    public boolean gameRunning;
    public Board board;
    public Game(){
        gameRunning = true;
        board = new Board();
        Setup setup = new Setup();
        setup.setupBoard(board);
        board.printBoard();
        newTurn();
    }

    public void newTurn(){
        if (turn == null || turn.equals("black")){
            turn = "white";
        }else{
            turn = "black";
        }

        System.out.printf("It is %s turn\'s to play\n", turn);
    }

    public void makeMove(String turn) {

        String[] pos = turn.split(" to ");
        if (!board.checkLocation(pos[0].toLowerCase())) {
            System.out.println(pos[0] + " is invalid. Usage: [a-h][1-8] to [a-hh][1-8]");
        } else if (!board.checkLocation(pos[1])) {
            System.out.println(pos[1] + " is invalid. Usage: [a-h][1-8] to [a-h][1-8]");
        } else {
            System.out.println("Valid location");
            newTurn();
        }


    }
}
