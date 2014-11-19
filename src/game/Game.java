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
        if (pos.length != 2) {
            System.out.println("Invalid use. Usage: [a-h][1-8] to [a-hh][1-8]");

        } else if (!board.checkLocation(pos[0].toLowerCase())) {
            System.out.println(pos[0] + " is invalid. Usage: [a-h][1-8] to [a-hh][1-8]");
        } else if (!board.checkLocation(pos[1].toLowerCase())) {
            System.out.println(pos[1] + " is invalid. Usage: [a-h][1-8] to [a-h][1-8]");
        } else {
            int x = (pos[0].charAt(0)) - 97;
            int y = Integer.parseInt(pos[1].substring(1));
            if (validTeam(x, y)) {
                newTurn();
            } else {
                System.out.println("Your team doesn't own that piece, try again");
            }
        }


    }

    public boolean validTeam(int x, int y) {

        return board.getTeam(x, y).checkTeam(turn);
    }
}
