package game;

import pieces.Piece;

import java.util.ArrayList;

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

    public ColorTeam getTeam(Locations pos) {
        return board[pos.getRow()][pos.getColumn()].getColorTeam();
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

    public boolean checkPos(Locations pos) {
        int x = pos.getRow();
        int y = pos.getColumn();
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    public boolean emptySpot(Locations pos) {

        return board[pos.getRow()][pos.getColumn()] == null;
    }

    public boolean movePiece(Locations start, Locations end) {

        int x1 = start.getRow();
        int x2 = end.getRow();
        int y1 = start.getColumn();
        int y2 = end.getColumn();

        Locations[] positionsBeforeCheck = board[x1][y1].moveLocations(start);
        ArrayList<Locations> dynamicList = new ArrayList<Locations>();
        for (int i = 0; i < positionsBeforeCheck.length; i++) {
            if (checkPos(positionsBeforeCheck[i]))
                dynamicList.add(positionsBeforeCheck[i]);
        }


        if (dynamicList.contains(end)) {
            board[x2][y2] = board[x1][y1];
            board[x1][y1] = null;
            return true;
        } else {
            return false;
        }

    }

    public boolean checkPath(Locations start, Locations end, boolean attacking) {


        return true;
    }
}
