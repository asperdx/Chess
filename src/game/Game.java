package game;

/**
 * Created by kllrshrk on 11/18/14.
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
    }

    public void newTurn(){
        if (turn == null || turn.equals("black")){
            turn = "white";
        }else{
            turn = "black";
        }

        System.out.printf("It is %s turn\'s to play\n", turn);
    }
}
