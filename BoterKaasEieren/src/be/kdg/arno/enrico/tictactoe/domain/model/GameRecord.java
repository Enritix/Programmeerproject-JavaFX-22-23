package be.kdg.arno.enrico.tictactoe.domain.model;

/**
 * This class contains of one single record out of the TableView from the {@link be.kdg.arno.enrico.tictactoe.domain.view.PlayedGamesView}
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class GameRecord {
    //Properties.
    public String date;
    public String nameX;
    public String nameO;
    public String boardSize;
    public String result;

    //Constructor.
    public GameRecord(String date, String nameX, String nameO, String boardSize, String result) {
        this.date = date;
        this.nameX = nameX;
        this.nameO = nameO;
        this.boardSize = boardSize;
        this.result = result;
    }
    //Getters.
    //Deze methodes zijn nodig om de TableView van de 'Played Games' te doen werken.
    //Ook al staan er geen usages bij, ze zijn wel degelijk nodig.
    public String getDate() {
        return date;
    }//getDate.

    public String getNameX() {
        return nameX;
    }//getNameX.

    public String getNameO() {
        return nameO;
    }//getNameO.

    public String getBoardSize() {
        return boardSize;
    }//getBoardSize.

    public String getResult() {
        return result;
    }//getResult.
}
