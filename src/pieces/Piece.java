package pieces;

import game.ColorTeam;
import game.Locations;
import java.awt.Color;
import java.awt.Graphics2D;

import java.util.ArrayList;

/**
 * Written by TheSoberRussian on 11/18/14.
 */
public class Piece {

    public ColorTeam colorTeam;

    public Piece(String team){
        colorTeam = new ColorTeam(team);
    }

    public boolean move(){
        return true;
    }

    public boolean remove(){
        return true;
    }

    public ColorTeam getColorTeam() {
        return colorTeam;
    }

    public void setColorTeam(ColorTeam colorTeam) {
        this.colorTeam = colorTeam;
    }

    @Override
    public String toString() {
        return "X";
    }

    public Locations[] moveLocations(Locations pos) {
        return null;
    }

    public ArrayList<Locations> getPath(Locations begin, Locations end) {
        return null;
    }
    public void draw(Graphics2D g, int width, int height){
        g.fillOval(2, 2, width - 4, height - 4);
        g.setColor(Color.BLACK);
        g.drawString(toString(), 
                width / 2 - g.getFontMetrics().charWidth(toString().charAt(0) / 2), 
                height - 2);
    }
}
