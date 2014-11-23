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

    @Override
    public String toString() {
        return row + " " + column;
    }

    @Override
    public boolean equals(Object object) {
        boolean sameRow = false;
        boolean sameColumn = false;

        if (object != null && object instanceof Locations) {
            sameRow = this.row == ((Locations) object).row;
            sameColumn = this.column == ((Locations) object).column;
        }

        return sameRow && sameColumn;
    }
    public static String toCoordinateString(Locations loc){
        String coordString = "";
        coordString = new String(Character.toChars(loc.row + 97)).concat(Integer.toString(loc.column + 1));
        return coordString;
    }
}
