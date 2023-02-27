package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import static be.kdg.arno.enrico.boterkaaseieren.domain.model.Piece.Color.*;

public class Board {
    private static final int BOARD_SIZE = 3;
    private Piece[][] pieces;
    private int pieceCounter;

    public Board() {
        this.pieces = new Piece[BOARD_SIZE][BOARD_SIZE];
        this.pieceCounter = 0;
    }

    public boolean addPiece(Piece piece, int columnNumber, int rowNumber) {
        if (pieces[columnNumber][rowNumber] == null) {
            this.pieceCounter++;
            pieces[columnNumber][rowNumber] = piece;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (pieceCounter == BOARD_SIZE * BOARD_SIZE) {
            return true;
        } else {
            return false;
        }

        /*for (int i = 0; i < BORDER; i++) {
            for (int j = 0; j < BORDER; j++) {
                Piece.Color colorRed = RED;
                Piece.Color colorBlack = BLACK;
                if (!pieces[i][j].equals(colorRed) || !pieces[i][j].equals(colorBlack) ) {
                    return false;
                }
            }
        }
        return true;*/
        /*for (Piece[] piece : pieces) {
            for (Piece piece1 : piece) {
                if (piece1 == null) {
                    return false;
                }
            }
        }
        return true;
    }*/

    }

    public void clearBoard() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                pieces[i][j] = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        /*for (int i = 0; i < 3; i++) {
            sb.append(String.format(" %d ", i));
        }
        sb.append("\n");*/
        /*for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == null) {
                    if (j < 2) {
                        sb.append("  ").append(" |");
                    } else {
                        sb.append("   ");
                    }
                } else {
                    if (pieces[i][j].getColor() == RED) {
                        if (j < 2) {
                            sb.append(" O").append(" |");
                        } else {
                            sb.append(" O ");
                        }
                    } else {
                        if (j < 2) {
                            sb.append(" X").append(" |");
                        } else {
                            sb.append(" X ");
                        }
                    }
                }
            }
            if (i < pieces.length - 1) {
                sb.append("\n---+---+---\n");
            }
        }
        return sb.toString();*/
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] == null) {
                    if (j < 2) {
                        sb.append("  ").append(" ║");
                    } else {
                        sb.append("   ");
                    }
                } else {
                    if (pieces[i][j].getColor() == RED) {
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
            if (i < pieces.length - 1) {
                sb.append("\n═══╬═══╬═══\n");
            }
        }
        return sb.toString();
    }



    public Piece.Color hasOXO() {
        /*int[][] direction = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        for (int[] d : direction) { // {1, 0} ↔, {1, -1} ↙ , {1, 1} ↘, {0, 1} ↕
            int dy = d[0];
            int dx = d[1];

            for (int x = 0; x < BOARD_SIZE; x++) {
                for (int y = 0; y < BOARD_SIZE; y++) {

                    int lasty = y + 2 * dy;
                    int lastx = x + 2 * dx;
                    if (lasty < BOARD_SIZE && lasty >= 0 && lastx < BOARD_SIZE && lastx >= 0) {
                        Piece currentPiece = pieces[y][x];
                        if (currentPiece != null && (pieces[y + dy][x + dx] != null && currentPiece.getColor() == pieces[y + dy][x + dx].getColor()
                                && pieces[y + 1 * dy][x + 1 * dx] != null && currentPiece.getColor() == pieces[y + 1 * dy][x + 1 * dx].getColor()
                                && pieces[y + 2 * dy][x + 2 * dx] != null && currentPiece.getColor() == pieces[y + 2 * dy][x + 2 * dx].getColor())) {
                            return currentPiece.getColor();
                        }
                    }
                }
            }
        }
        return null;*/
        // Check rows for winning sequences
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (pieces[row][0] != null && pieces[row][0] == pieces[row][1] && pieces[row][0] == pieces[row][2]) {
                return pieces[row][0].getColor();
            }
        }

        // Check columns for winning sequences
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (pieces[0][col] != null && pieces[0][col] == pieces[1][col] && pieces[0][col] == pieces[2][col]) {
                return pieces[0][col].getColor();
            }
        }

        // Check diagonals for winning sequences
        if (pieces[0][0] != null && pieces[0][0] == pieces[1][1] && pieces[0][0] == pieces[2][2]) {
            return pieces[0][0].getColor();
        }
        if (pieces[0][2] != null && pieces[0][2] == pieces[1][1] && pieces[0][2] == pieces[2][0]) {
            return pieces[0][2].getColor();
        }

        // No winning sequence found
        return null;
    }
}
