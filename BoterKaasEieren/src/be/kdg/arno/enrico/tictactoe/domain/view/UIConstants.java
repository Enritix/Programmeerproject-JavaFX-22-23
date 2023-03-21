package be.kdg.arno.enrico.tictactoe.domain.view;

public abstract class UIConstants {
    public static final int DEFAULT_SHADOW = 15;
    public static final int BUTTON_PREFWIDTH = 90;
    public static final int BUTTON_PREFHEIGHT = 90;
    public static final int BUTTON_PREFSIZE = 90;
    public static int boardSize;

    public static void setBoardSize(int size) {
        boardSize = size;
    }

    public static int getBoardSize() {
        return boardSize;
    }
}
