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

        for (int i = 1; i <= 8; i++) {
            list[i] = new Locations(row + i, column);
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
        for (int i = 1; i <= 8; i++) {
            list[i + 31] = new Locations(row + i, column + i);
        }
        for (int i = 1; i <= 8; i++) {
            list[i + 39] = new Locations(row + i, column - i);
        }
        for (int i = 1; i <= 8; i++) {
            list[i + 47] = new Locations(row - i, column + i);
        }
        for (int i = 1; i <= 8; i++) {
            list[i + 55] = new Locations(row - i, column - i);
        }
//        List rookMoves = Arrays.asList(new Rook(this.colorTeam.getTeam()).moveLocations(pos));
//        List bishopMoves = Arrays.asList(new Bishop(this.colorTeam.getTeam()).moveLocations(pos));
//        Collections.addAll(rookMoves, bishopMoves);
//        return (Locations[])rookMoves.toArray();
        return list;
        
    }

    @Override
    public String toString() {
        return "Q";
    }
}
