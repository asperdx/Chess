package pieces;

import game.Locations;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class King extends Piece {
    public King(String team) {
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
        return "K";
    }

    @Override
    public Locations[] moveLocations(Locations pos) {

        int row = pos.getRow();
        int column = pos.getColumn();

        Locations[] list = new Locations[8];

        list[0] = new Locations(row + 1, column);
        list[1] = new Locations(row + 1, column + 1);
        list[2] = new Locations(row, column + 1);
        list[3] = new Locations(row - 1, column + 1);
        list[4] = new Locations(row - 1, column);
        list[5] = new Locations(row - 1, column - 1);
        list[6] = new Locations(row, column - 1);
        list[7] = new Locations(row + 1, column - 1);

        return list;
    }
        public void draw(Graphics2D g, int width, int height){
        g.fillOval(2, 2, width - 4, height - 4);
        g.setColor(Color.BLACK);
        g.drawString(toString(), 
                width / 2 - g.getFontMetrics().charWidth(toString().charAt(0) / 3), 
                height - 2);
    }
}
