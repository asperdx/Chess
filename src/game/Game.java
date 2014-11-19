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
            int x1 = (pos[0].charAt(0)) - 97;
            int y1 = Integer.parseInt(pos[0].substring(1)) - 1;
            int x2 = (pos[1].charAt(0)) - 97;
            int y2 = Integer.parseInt(pos[1].substring(1)) - 1;
            Locations startPos = new Locations(x1, y1);
            Locations endPos = new Locations(x2, y2);
            switch (validPos(startPos)) {
                case 0:
                    board.movePiece(startPos, endPos);
                    board.printBoard();
                    newTurn();
                    break;
                case 1:
                    System.out.println("Your team doesn't own that piece, try again");
                    break;
                case 2:
                    System.out.println("There isn't a piece there. Try again");
                    break;
            }
        }


    }


    public int validPos(Locations pos) {


        if (!board.emptySpot(pos))
            if (board.getTeam(pos).checkTeam(turn)) {
                return 0;
            } else {
                return 1;
            }
        else {
            return 2;
        }
    }
}
