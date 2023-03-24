package be.kdg.arno.enrico.tictactoe.domain.model.exceptions;

public class TileNotEmptyException extends RuntimeException {
    public TileNotEmptyException(String message) {
        super(message);
    }
}
