package game;

import pieces.Piece;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Board {

    private Piece board[][];
    private String[] column = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private String row = "   1 2 3 4 5 6 7 8";

    public Board(){
        board = new Piece[8][8];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public ColorTeam getTeam(int x, int y) {
        return board[x][y].getColorTeam();
    }

    public void printBoard(){
        for (int i = 0; i < board.length; ++i) {
            System.out.print(column[i] + "|");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null)
                    System.out.print(" " + board[i][j].toString());
                else
                    System.out.print(" x");
            }
            System.out.println();
        }
        System.out.println(row);

    }

    public boolean checkLocation(String x) {
        return x.matches("[a-h][1-8]");
    }

    public boolean emptySpot(int x, int y) {

        return board[x][y] == null;
    }

    public void movePiece(int x1, int y1, int x2, int y2) {

        board[x2][y2] = board[x1][y1];
        board[x1][y1] = null;

    }
}
