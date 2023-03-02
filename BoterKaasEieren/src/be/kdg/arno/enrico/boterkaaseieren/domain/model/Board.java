package be.kdg.arno.enrico.boterkaaseieren.domain.model;

public class Board {
    private int size;
    private String[][] tiles;
    private int pieceCounter;

    public Board(int size) {
        this.size = size;
        this.tiles = new String[size][size];
        this.pieceCounter = 0;
    }

    public boolean addPiece(String player, int rowNumber, int colNumber) {
        if (tiles[colNumber][rowNumber] == null) {
            this.pieceCounter++;
            tiles[colNumber][rowNumber] = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (pieceCounter == size * size) {
            return true;
        } else {
            return false;
        }
    }

    public void clearBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = " ";
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == null) {
                    if (j < 2) {
                        sb.append("  ").append(" ║");
                    } else {
                        sb.append("   ");
                    }
                } else {
                    if (tiles[i][j].equals("O")) {
                        if (j < 2) {
                            sb.append(" O").append(" ║");
                        } else {
                            sb.append(" O ");
                        }
                    } else {
                        if (j < 2) {
                            sb.append(" X").append(" ║");
                        } else {
                            sb.append(" X ");
                        }
                    }
                }
            }
            if (i < tiles.length - 1) {
                sb.append("\n═══╬═══╬═══\n");
            }
        }
        return sb.toString();
    }

    public boolean checkWin() {
        if (size == 3) {
            if ((tiles[0][0] + tiles[0][1] + tiles[0][2]).equals("XXX") || (tiles[0][0] + tiles[0][1] + tiles[0][2]).equals("OOO")) {
                return true;
            } else if ((tiles[1][0] + tiles[1][1] + tiles[1][2]).equals("XXX") || (tiles[1][0] + tiles[1][1] + tiles[1][2]).equals("OOO")) {
                return true;
            } else if ((tiles[2][0] + tiles[2][1] + tiles[2][2]).equals("XXX") || (tiles[2][0] + tiles[2][1] + tiles[2][2]).equals("OOO")) {
                return true;
            } else if ((tiles[0][0] + tiles[1][1] + tiles[2][2]).equals("XXX") || (tiles[0][0] + tiles[1][1] + tiles[2][2]).equals("OOO")) {
                return true;
            } else if ((tiles[2][0] + tiles[1][1] + tiles[0][2]).equals("XXX") || (tiles[2][0] + tiles[1][1] + tiles[0][2]).equals("OOO")) {
                return true;
            }
        }
        //TODO: size 5 en 7
        return false;
    }

    public int getSize() {
        return size;
    }
}
