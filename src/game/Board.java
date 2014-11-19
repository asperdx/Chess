package game;

import pieces.Piece;

import javax.lang.model.type.NullType;

/**
 * Created by kllrshrk on 11/18/14.
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null)
                    System.out.print(board[i][j].toString());
                else
                    System.out.print("x");
            }
            System.out.println();
        }
    }
}
