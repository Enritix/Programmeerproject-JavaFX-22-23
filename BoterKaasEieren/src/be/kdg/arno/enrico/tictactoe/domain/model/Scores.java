package be.kdg.arno.enrico.tictactoe.domain.model;

public class Scores {
    private String name;
    private int points;


    public Scores(String name, int points){
        setName(name);
        setPoints(points);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Scores two) {

        return this.getPoints() - two.getPoints();
    }
}




