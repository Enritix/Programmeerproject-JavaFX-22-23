package be.kdg.arno.enrico.tictactoe.domain.model;


import be.kdg.arno.enrico.tictactoe.domain.view.UIConstants;

/**
 * This class makes the array which is needed for the application game board to work, because they're linked with eachother.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */

public class Board {
    //Properties.
    private int size;
    private String[][] tiles;
    private int pieceCounter;

    //Constructor.
    public Board(int size) {
        this.size = size;
        createBoard();
        this.pieceCounter = 0;
        clearBoard();
    }

    //Methods.
    public boolean addPiece(String player, int colNumber, int rowNumber) {
        if (this.tiles[colNumber][rowNumber].equals("")) {
            this.pieceCounter++;
            tiles[colNumber][rowNumber] = player;
            return true;
        } else {
            return false;
        }
    }//addPiece.

    public boolean isFull() {
        if (pieceCounter == UIConstants.getBoardSize() * UIConstants.getBoardSize()) {
            return true;
        } else {
            return false;
        }
    }//isFull.

    public boolean isSquareEmpty(int col, int row) {
        return tiles[col][row].equals("") || tiles[col][row].isEmpty();
    }//isSquareEmpty.

    public void clearBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = "";
            }
        }
    }//clearBoard.

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
    }//toString.


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
        if (getSize() > 3) {
            for (int i = 0; i < getSize(); i++) {
                for (int j = 0; j < getSize() - 3; j++) {
                    if (tiles[i][j].equals(tiles[i][j + 1]) && tiles[i][j + 1].equals(tiles[i][j + 2]) && tiles[i][j + 2].equals(tiles[i][j + 3])   //horizontal
                            && !tiles[i][j].equals("")) {
                        return true;
                    }
                    if (tiles[j][i].equals(tiles[j + 1][i]) && tiles[j + 1][i].equals(tiles[j + 2][i]) && tiles[j + 2][i].equals(tiles[j + 3][i])   //verticaal
                            && !tiles[j][i].equals("")) {
                        return true;
                    }
                }
            }
            for (int i = 0; i < getSize() - 3; i++) {   //diagonaal
                for (int j = 0; j < getSize() - 3; j++) {
                    if (i + j < getSize() - 3) {

                        //linksboven naar rechtsonder
                        if (tiles[i + j][i].equals(tiles[i + 1 + j][i + 1]) && tiles[i + 1 + j][i + 1].equals(tiles[i + 2 + j][i + 2]) && tiles[i + 2 + j][i + 2].equals(tiles[i + 3 + j][i + 3])
                                && !tiles[i + j][i].equals("")) {
                            return true;
                        }
                        if (tiles[i][i + j].equals(tiles[i + 1][i + 1 + j]) && tiles[i + 1][i + 1 + j].equals(tiles[i + 2][i + 2 + j]) && tiles[i + 2][i + 2 + j].equals(tiles[i + 3][i + 3 + j])
                                && !tiles[i][i + j].equals("")) {
                            return true;
                        }

                        //linksonder naar rechtsboven
                        if (tiles[getSize() - 1 - i - j][0 + i].equals(tiles[getSize() - 2 - i - j][1 + i]) && tiles[getSize() - 2 - i - j][1 + i].equals(tiles[getSize() - 3 - i - j][2 + i]) && tiles[getSize() - 3 - i - j][2 + i].equals(tiles[getSize() - 4 - i - j][3 + i]) && !tiles[getSize() - 1 - i - j][0 + i].equals("")) {
                            return true;
                        }
                        if (tiles[getSize() - 1 - i][0 + i + j].equals(tiles[getSize() - 2 - i][1 + i + j]) && tiles[getSize() - 2 - i][1 + i + j].equals(tiles[getSize() - 3 - i][2 + i + j]) && tiles[getSize() - 3 - i][2 + i + j].equals(tiles[getSize() - 4 - i][3 + i + j]) && !tiles[getSize() - 1 - i][0 + i + j].equals("")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }//checkWin.

    public void createBoard() {
        this.tiles = new String[UIConstants.boardSize][UIConstants.boardSize];
        clearBoard();
    }//createBoard.

    //Getters.
    public int getSize() {
        return UIConstants.getBoardSize();
    }//getSize.
}
