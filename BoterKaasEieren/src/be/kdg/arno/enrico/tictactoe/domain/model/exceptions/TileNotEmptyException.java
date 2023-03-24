package be.kdg.arno.enrico.tictactoe.domain.model.exceptions;

/**
 * This class is used to throw an exception once a player tries to place
 * their symbol on top of a tile that isn't empty.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class TileNotEmptyException extends RuntimeException {
    //Constructor.
    public TileNotEmptyException(String message) {
        super(message);
    }
}
