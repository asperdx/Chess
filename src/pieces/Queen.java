package pieces;

import game.Locations;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class Queen extends Piece {
    public Queen(String team) {
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
    public Locations[] moveLocations(Locations pos) {

        int row = pos.getRow();
        int column = pos.getColumn();

        Locations[] list = new Locations[64];

        for (int i = 0; i < 8; i++) {
            list[i] = new Locations(row + i, column);
        }
        for (int i = 8; i < 16; i++) {
            list[i] = new Locations(row - i, column);
        }
        for (int i = 16; i < 24; i++) {
            list[i] = new Locations(row, column + i);
        }
        for (int i = 24; i < 32; i++) {
            list[i] = new Locations(row, column - i);
        }
        for (int i = 32; i < 40; i++) {
            list[i] = new Locations(row + i, column + i);
        }
        for (int i = 40; i < 48; i++) {
            list[i] = new Locations(row + i, column - i);
        }
        for (int i = 48; i < 56; i++) {
            list[i] = new Locations(row - i, column + i);
        }
        for (int i = 56; i < 64; i++) {
            list[i] = new Locations(row - i, column - i);
        }
        return list;
    }

    @Override
    public String toString() {
        return "Q";
    }
}
