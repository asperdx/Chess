package pieces;

import game.Locations;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class Knight extends Piece {
    public Knight(String team) {
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
        return "N";
    }

    @Override
    public Locations[] moveLocations(Locations pos) {

        int row = pos.getRow();
        int column = pos.getColumn();

        Locations[] list = new Locations[8];


        list[0] = new Locations(row + 2, column + 1);
        list[1] = new Locations(row + 2, column - 1);
        list[2] = new Locations(row + 1, column + 2);
        list[3] = new Locations(row + 1, column - 2);
        list[4] = new Locations(row - 2, column + 1);
        list[5] = new Locations(row - 2, column - 1);
        list[6] = new Locations(row - 1, column + 2);
        list[7] = new Locations(row - 1, column - 2);

        return list;

    }
}
