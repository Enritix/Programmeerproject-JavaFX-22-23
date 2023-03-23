package be.kdg.arno.enrico.tictactoe.domain.model;

public class GameRecord {
    public String date;
    public String nameX;
    public String nameO;
    public String boardSize;
    public String result;

    public GameRecord(String date, String nameX, String nameO, String boardSize, String result) {
        this.date = date;
        this.nameX = nameX;
        this.nameO = nameO;
        this.boardSize = boardSize;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public String getNameX() {
        return nameX;
    }

    public String getNameO() {
        return nameO;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public String getResult() {
        return result;
    }
}
