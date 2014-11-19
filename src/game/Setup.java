package game;

import pieces.*;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class Setup {

    public Setup(){

    }

    public boolean setupBoard(Board b){

        Piece board[][] = b.getBoard();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }

        /* set up the rooks */
        board[0][0] = new Rook("black");
        board[0][7] = new Rook("black");
        board[7][0] = new Rook("white");
        board[7][7] = new Rook("white");

        /* set up the knights */
        board[0][1] = new Knight("black");
        board[0][6] = new Knight("black");
        board[7][1] = new Knight("white");
        board[7][6] = new Knight("white");

        /* set up the bishops */
        board[0][2] = new Bishop("black");
        board[0][5] = new Bishop("black");
        board[7][2] = new Bishop("white");
        board[7][5] = new Bishop("white");

        /* set up the royal pieces */
        board[0][3] = new Queen("black");
        board[0][4] = new King("black");
        board[7][3] = new Queen("white");
        board[7][4] = new King("white");

        /* set up the pawns black*/
        for (int i = 0; i < board[1].length; i++) {
            board[1][i] = new Pawn("black");
        }

        /*set up the pawns white*/
        for (int i = 0; i < board[6].length; i++) {
            board[6][i] = new Pawn("white");
        }

        b.setBoard(board);
        return true;
    }
}
