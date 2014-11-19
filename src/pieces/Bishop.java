package pieces;

import game.Locations;

import java.util.ArrayList;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Bishop extends Piece {

    public Bishop(String team) {
        super(team);
    }

    @Override
    public boolean move() {
        return super.move();
    }

    @Override
    public boolean remove() {
        return super.remove();
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public Locations[] moveLocations(Locations pos) {

        int row = pos.getRow();
        int column = pos.getColumn();

        Locations[] list = new Locations[32];
        for (int i = 0; i < 8; i++) {
            list[i] = new Locations(row + i, column + i);
        }
        for (int i = 8; i < 16; i++) {
            list[i] = new Locations(row + i, column - i);
        }
        for (int i = 16; i < 24; i++) {
            list[i] = new Locations(row - i, column + i);
        }
        for (int i = 24; i < 32; i++) {
            list[i] = new Locations(row - i, column - i);
        }
        return list;
    }

    @Override
    public ArrayList<Locations> getPath(Locations begin, Locations end) {

        int startRow = begin.getRow();
        int startColumn = begin.getColumn();

        int endRow = end.getRow();
        int endColumn = end.getColumn();

        ArrayList<Locations> list = new ArrayList<Locations>();
        if (startRow < endRow) {
            if (startColumn < endColumn) {
                for (int i = 0; i < endRow - startRow; i++) {
                    list.add(new Locations(startRow - i, startColumn + i));
                }
            } else {
                for (int i = 0; i < endRow - startRow; i++) {
                    list.add(new Locations(startRow - i, startColumn - i));
                }
            }
        } else {
            if (startColumn < endColumn) {
                for (int i = 0; i < startRow - endRow; i++) {
                    list.add(new Locations(startRow - i, startColumn + i));
                }
            } else {
                for (int i = 0; i < startRow - endRow; i++) {
                    list.add(new Locations(startRow - i, startColumn - i));
                }
            }
        }


        return list;
    }
}
