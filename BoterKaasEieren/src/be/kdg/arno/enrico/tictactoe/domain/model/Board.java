package be.kdg.arno.enrico.tictactoe.domain.model;


import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

public class Board {
    private int size;
    private String[][] tiles;
    private int pieceCounter;

    public Board(int size) {
        this.size = size;
        createBoard();
        this.pieceCounter = 0;
        clearBoard();
    }

    public boolean addPiece(String player, int colNumber, int rowNumber) {
        if (this.tiles[colNumber][rowNumber].equals("")) {
            this.pieceCounter++;
            tiles[colNumber][rowNumber] = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (pieceCounter == UIConstants.getBoardSize() * UIConstants.getBoardSize()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSquareEmpty(int col, int row) {
        return tiles[col][row].equals("") || tiles[col][row].isEmpty();
    }

    public void clearBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = "";
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == null || tiles[i][j].equals("")) {
                    if (j < 2) {
                        sb.append("  ").append(" ║");
                    } else {
                        sb.append("   ");
                    }
                } else {
                    if (tiles[i][j].equals("X")) {
                        if (j < 2) {
                            sb.append(" X").append(" ║");
                        } else {
                            sb.append(" X ");
                        }
                    } else {
                        if (j < 2) {
                            sb.append(" O").append(" ║");
                        } else {
                            sb.append(" O ");
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
        if (getSize() == 3) {
            for (int i = 0; i < getSize(); i++) {
                if (tiles[i][0].equals(tiles[i][1]) && tiles[i][1].equals(tiles[i][2]) && !tiles[i][0].equals("")) {
                    return true;
                }
                if (tiles[0][i].equals(tiles[1][i]) && tiles[1][i].equals(tiles[2][i]) && !tiles[0][i].equals("")) {
                    return true;
                }
            }
            if (tiles[0][0].equals(tiles[1][1]) && tiles[1][1].equals(tiles[2][2]) && !tiles[0][0].equals("")) {
                return true;
            }
            if (tiles[0][2].equals(tiles[1][1]) && tiles[1][1].equals(tiles[2][0]) && !tiles[0][2].equals("")) {
                return true;
            }
            /*We're first using two loops to check for wins on the horizontal and vertical axes,
            then checking for the diagonal wins individually with an `if` statement at the end.
            We're also checking if the tiles are not empty before checking for a win to avoid unnecessary comparisons.*/
        }
        if (getSize() == 5) {
            for (int i = 0; i < getSize(); i++) {
                if (tiles[i][0].equals(tiles[i][1]) && tiles[i][1].equals(tiles[i][2]) && tiles[i][2].equals(tiles[i][3]) && !tiles[i][0].equals("")) {
                    return true;
                }
                if (tiles[i][1].equals(tiles[i][2]) && tiles[i][2].equals(tiles[i][3]) && tiles[i][3].equals(tiles[i][4]) && !tiles[i][1].equals("")) {
                    return true;
                }
                if (tiles[0][i].equals(tiles[1][i]) && tiles[1][i].equals(tiles[2][i]) && tiles[2][i].equals(tiles[3][i]) && !tiles[0][i].equals("")) {
                    return true;
                }
                if (tiles[1][i].equals(tiles[2][i]) && tiles[2][i].equals(tiles[3][i]) && tiles[3][i].equals(tiles[4][i]) && !tiles[1][i].equals("")) {
                    return true;
                }
            }
            if (tiles[0][0].equals(tiles[1][1]) && tiles[1][1].equals(tiles[2][2]) && tiles[2][2].equals(tiles[3][3]) && !tiles[0][0].equals("")) {
                return true;
            }
            if (tiles[1][1].equals(tiles[2][2]) && tiles[2][2].equals(tiles[3][3]) && tiles[3][3].equals(tiles[4][4]) && !tiles[1][1].equals("")) {
                return true;
            }
            if (tiles[0][4].equals(tiles[1][3]) && tiles[1][3].equals(tiles[2][2]) && tiles[2][2].equals(tiles[3][1]) && !tiles[0][4].equals("")) {
                return true;
            }
            if (tiles[1][3].equals(tiles[2][2]) && tiles[2][2].equals(tiles[3][1]) && tiles[3][1].equals(tiles[4][0]) && !tiles[1][3].equals("")) {
                return true;
            }
        }
        if (getSize() == 7) {
            for (int i = 0; i < getSize(); i++) {
                if (tiles[i][0].equals(tiles[i][1]) && tiles[i][1].equals(tiles[i][2]) && tiles[i][2].equals(tiles[i][3])
                        && !tiles[i][0].equals("")) {
                    return true;
                }
                if (tiles[i][1].equals(tiles[i][2]) && tiles[i][2].equals(tiles[i][3]) && tiles[i][3].equals(tiles[i][4])
                        && !tiles[i][1].equals("")) {
                    return true;
                }
                if (tiles[i][2].equals(tiles[i][3]) && tiles[i][3].equals(tiles[i][4]) && tiles[i][4].equals(tiles[i][5])
                        && !tiles[i][2].equals("")) {
                    return true;
                }
                if (tiles[i][3].equals(tiles[i][4]) && tiles[i][4].equals(tiles[i][5]) && tiles[i][5].equals(tiles[i][6])
                        && !tiles[i][3].equals("")) {
                    return true;
                }

                if (tiles[0][i].equals(tiles[1][i]) && tiles[1][i].equals(tiles[2][i]) && tiles[2][i].equals(tiles[3][i])
                        && !tiles[0][i].equals("")) {
                    return true;
                }
                if (tiles[1][i].equals(tiles[2][i]) && tiles[2][i].equals(tiles[3][i]) && tiles[3][i].equals(tiles[4][i])
                        && !tiles[1][i].equals("")) {
                    return true;
                }
                if (tiles[2][i].equals(tiles[3][i]) && tiles[3][i].equals(tiles[4][i]) && tiles[4][i].equals(tiles[5][i])
                        && !tiles[2][i].equals("")) {
                    return true;
                }
                if (tiles[3][i].equals(tiles[4][i]) && tiles[4][i].equals(tiles[5][i]) && tiles[5][i].equals(tiles[6][i])
                        && !tiles[3][i].equals("")) {
                    return true;
                }
            }
            for (int i = 0; i < getSize() - 3; i++) {
                if (tiles[i][i].equals(tiles[i + 1][i + 1]) && tiles[i + 1][i + 1].equals(tiles[i + 2][i + 2])
                        && tiles[i + 2][i + 2].equals(tiles[i + 3][i + 3]) && !tiles[i][i].equals("")) {
                    return true;
                }
                if (tiles[i][6 - i].equals(tiles[i + 1][5 - i]) && tiles[i + 1][5 - i].equals(tiles[i + 2][4 - i])
                        && tiles[i + 2][4 - i].equals(tiles[i + 3][3 - i]) && !tiles[i][6 - i].equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getSize() {
        return UIConstants.getBoardSize();
    }

    public void createBoard() {
        this.tiles = new String[UIConstants.boardSize][UIConstants.boardSize];
        clearBoard();
    }
}
