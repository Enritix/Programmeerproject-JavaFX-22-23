package be.kdg.arno.enrico.tictactoe.domain.model;

/**
 * This class is where the scores of the players get saved
 * and compared.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class Scores {
    //Properties.
    private String name;
    private int scores;

    //Constructor.
    public Scores(String name, int scores){
        setName(name);
        setScores(scores);
    }

    //Methods.
    public int compareTo(Scores two) {
        return this.getScores() - two.getScores();
    }//compareTo.

    //Getters and Setters.
    public void setScores(int scores) {
        this.scores = scores;
    }//setScores.

    public void setName(String name) {
        this.name = name;
    }//setName.

    public int getScores() {
        return scores;
    }//getScores.

    public String getName() {
        return name;
    }//getName.

}




