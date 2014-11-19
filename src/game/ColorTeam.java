package game;

/**
 * Created by kllrshrk on 11/18/14.
 */
public class ColorTeam {

    private String team;

    public ColorTeam(String team){
        setTeam(team);
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean checkTeam(String check){
        return team.equals(check);
    }
}
