package game;

import pieces.Piece;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Board {

    private Piece board[][];

    public Board(){
        board = new Piece[8][8];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public void printBoard(){
        for (Piece[] aBoard : board) {
            for (int j = 0; j < aBoard.length; j++) {
                if (aBoard[j] != null)
                    System.out.print(aBoard[j].toString());
                else
                    System.out.print("x");
            }
            System.out.println();
        }
    }

    public boolean checkLocation(String x) {
        return x.matches("[a-h][1-8]");
    }
}
