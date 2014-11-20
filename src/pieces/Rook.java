package pieces;

import game.Locations;

import java.util.ArrayList;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class Rook extends Piece {
    public Rook(String team) {
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
        return "R";
    }

    @Override
    public Locations[] moveLocations(Locations pos) {

        int row = pos.getRow();
        int column = pos.getColumn();

        Locations[] list = new Locations[32];

        for (int i = 1; i <= 8; i++) {
            list[i - 1] = new Locations(row + i, column);
        }
        for (int i = 1; i <= 8; i++) {
            list[i + 7] = new Locations(row - i, column);
        }
        for (int i = 1; i <= 8; i++) {
            list[i + 15] = new Locations(row, column + i);
        }
        for (int i = 1; i <= 8; i++) {
            list[i + 23] = new Locations(row, column - i);
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
        if (startRow > endRow) {
            for (int i = 1; i <= startRow - endRow; i++) {
                list.add(new Locations(startRow - i, startColumn));
            }
        } else if (startRow < endRow) {
            for (int i = 1; i <= endRow - startRow; i++) {
                list.add(new Locations(startRow + i, startColumn));
            }
        } else if (startColumn > endColumn) {
            for (int i = 1; i <= startColumn - endColumn; i++) {
                list.add(new Locations(startRow, startColumn - i));
            }
        } else {
            for (int i = 1; i <= endColumn - startColumn; i++) {
                list.add(new Locations(startRow, startColumn + i));
            }
        }


        return list;
    }
}
