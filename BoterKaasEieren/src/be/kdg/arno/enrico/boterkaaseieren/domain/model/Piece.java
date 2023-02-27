package be.kdg.arno.enrico.boterkaaseieren.domain.model;
public class Piece {
    public enum Color {
        RED, BLACK;
    }

    private Color color;
    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
