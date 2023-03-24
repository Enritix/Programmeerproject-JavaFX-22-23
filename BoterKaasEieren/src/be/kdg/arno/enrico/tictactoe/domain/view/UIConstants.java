package be.kdg.arno.enrico.tictactoe.domain.view;

/**
 * This class contains of static finals, so you can easily access them for all of the classes.
 * We also use it to set the board size.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public abstract class UIConstants {
    public static final int DEFAULT_SHADOW = 15;
    public static final int BUTTON_PREFWIDTH = 90;
    public static final int BUTTON_PREFHEIGHT = 90;
    public static final int BUTTON_MINSIZE = 65;
    public static final int BUTTON_MAXSIZE = 250;
    public static int boardSize;

    public static void setBoardSize(int size) {
        boardSize = size;
    }

    public static int getBoardSize() {
        return boardSize;
    }
}
