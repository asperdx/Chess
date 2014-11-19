package pieces;

import game.Locations;

import java.util.ArrayList;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class Pawn extends Piece {
    public boolean firstmove;

    public Pawn(String team) {
        super(team);
        firstmove = true;
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
        return "P";
    }

    @Override
    public Locations[] moveLocations(Locations pos) {

        int row = pos.getRow();
        int column = pos.getColumn();

        Locations[] list;
        if (firstmove) {
            list = new Locations[4];
        } else {
            list = new Locations[3];
        }


        if (colorTeam.getTeam().equals("black")) {
            list[0] = new Locations(row + 1, column);
            list[1] = new Locations(row + 1, column + 1);
            list[2] = new Locations(row + 1, column - 1);
            if (firstmove) {
                list[3] = new Locations(row + 2, column);
            }
            firstmove = false;
        } else {
            list[0] = new Locations(row - 1, column);
            list[1] = new Locations(row - 1, column + 1);
            list[2] = new Locations(row - 1, column - 1);
            if (firstmove) {
                list[3] = new Locations(row - 2, column);
            }
            firstmove = false;

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
        } else {
            for (int i = 1; i <= endRow - startRow; i++) {
                list.add(new Locations(startRow + i, startColumn));
            }
        }

        return list;
    }
}
