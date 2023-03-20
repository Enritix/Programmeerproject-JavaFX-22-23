package be.kdg.arno.enrico.tictactoe.domain.model.exceptions;

public class TileNotEmptyException extends Exception {
    public TileNotEmptyException(String message) {
        super(message);
    }
}
