package be.kdg.arno.enrico.tictactoe.domain.model;


import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

public class Board {
    private int size;
    private String[][] tiles;
    /*private ArrayList<String>[][] tiles;*/
    private int pieceCounter;

    public Board(int size) {
        this.size = size;
        this.tiles = new String[UIConstants.BOARD_SIZE][UIConstants.BOARD_SIZE]; /*new String[size][size];*/
        /*this.tiles = new ArrayList[size][size];*/
        this.pieceCounter = 0;
        clearBoard();
    }

    public boolean addPiece(String player, int colNumber, int rowNumber) {
        if (this.tiles[colNumber][rowNumber].equals("")) {
            this.pieceCounter++;
            /*tiles[colNumber][rowNumber].add(player);*/
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

    public boolean isSquareEmpty(int col, int row) {
        return tiles[col][row].equals("") || tiles[col][row].isEmpty();
    }

    public void clearBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                /*tiles[i][j].clear();*/
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
        if (size == 3) {
            /*if ((tiles[0][0] + tiles[0][1] + tiles[0][2]).equals("XXX") || (tiles[0][0] + tiles[0][1] + tiles[0][2]).equals("OOO")) {  //bovenste rij (horizontaal)
                return true;
            } else if ((tiles[1][0] + tiles[1][1] + tiles[1][2]).equals("XXX") || (tiles[1][0] + tiles[1][1] + tiles[1][2]).equals("OOO")) {    //middelste rij (horizontaal)
                return true;
            } else if ((tiles[2][0] + tiles[2][1] + tiles[2][2]).equals("XXX") || (tiles[2][0] + tiles[2][1] + tiles[2][2]).equals("OOO")) {    //onderste rij (horizontaal)
                return true;
            } else if ((tiles[0][0] + tiles[1][1] + tiles[2][2]).equals("XXX") || (tiles[0][0] + tiles[1][1] + tiles[2][2]).equals("OOO")) {    //linksboven naar rechtsonder (diagonaal)
                return true;
            } else if ((tiles[2][0] + tiles[1][1] + tiles[0][2]).equals("XXX") || (tiles[2][0] + tiles[1][1] + tiles[0][2]).equals("OOO")) {    //linksonder naar rechtsboven (diagonaal)
                return true;
            }else if ((tiles[0][0] + tiles[1][0] + tiles[2][0]).equals("XXX") || (tiles[0][0] + tiles[1][0] + tiles[2][0]).equals("OOO")) {    //linkse kolom (verticaal)
                return true;
            }else if ((tiles[0][1] + tiles[1][1] + tiles[2][1]).equals("XXX") || (tiles[0][1] + tiles[1][1] + tiles[2][1]).equals("OOO")) {    //middelste kolom (verticaal)
                return true;
            }else if ((tiles[0][2] + tiles[1][2] + tiles[2][2]).equals("XXX") || (tiles[0][2] + tiles[1][2] + tiles[2][2]).equals("OOO")) {    //rechtse kolom (verticaal)
                return true;
            }*/
            for (int i = 0; i < size; i++) {
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
        if (size == 5) {
            /*// Check horizontal lines
            for (int row = 0; row < size; row++) {
                for (int col = 0; col <= size - 4; col++) {
                    if (tiles[row][col].equals("X") && tiles[row][col + 1].equals("X") && tiles[row][col + 2].equals("X") && tiles[row][col + 3].equals("X") ||
                            tiles[row][col].equals("O") && tiles[row][col + 1].equals("O") && tiles[row][col + 2].equals("O") && tiles[row][col + 3].equals("O")) {
                        return true;
                    }
                }
            }

            // Check vertical lines
            for (int col = 0; col < size; col++) {
                for (int row = 0; row <= size - 4; row++) {
                    if (tiles[row][col].equals("X") && tiles[row + 1][col].equals("X") && tiles[row + 2][col].equals("X") && tiles[row + 3][col].equals("X") ||
                            tiles[row][col].equals("O") && tiles[row + 1][col].equals("O") && tiles[row + 2][col].equals("O") && tiles[row + 3][col].equals("O")) {
                        return true;
                    }
                }
            }

            // Check diagonal lines
            for (int row = 0; row <= size - 4; row++) {
                for (int col = 0; col <= size - 4; col++) {
                    if (tiles[row][col].equals("X") && tiles[row + 1][col + 1].equals("X") && tiles[row + 2][col + 2].equals("X") && tiles[row + 3][col + 3].equals("X") ||
                            tiles[row][col].equals("O") && tiles[row + 1][col + 1].equals("O") && tiles[row + 2][col + 2].equals("O") && tiles[row + 3][col + 3].equals("O")) {
                        return true;
                    }
                }
            }

            for (int row = 0; row <= size - 4; row++) {
                for (int col = 3; col < size; col++) {
                    if (tiles[row][col].equals("X") && tiles[row + 1][col - 1].equals("X") && tiles[row + 2][col - 2].equals("X") && tiles[row + 3][col - 3].equals("X") ||
                            tiles[row][col].equals("O") && tiles[row + 1][col - 1].equals("O") && tiles[row + 2][col - 2].equals("O") && tiles[row + 3][col - 3].equals("O")) {
                        return true;
                    }
                }
            }*/
            for (int i = 0; i < size; i++) {
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
        if (size == 7) {
            for (int i = 0; i < size; i++) {
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
            for (int i = 0; i < size - 3; i++) {
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
        return size;
    }
}
