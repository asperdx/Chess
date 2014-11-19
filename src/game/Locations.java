package game;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Locations {

    private int row;
    private int column;

    public Locations(int x, int y) {
        row = x;
        column = y;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
