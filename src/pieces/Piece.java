package pieces;

import game.ColorTeam;

/**
 * Created by kllrshrk on 11/18/14.
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
}
