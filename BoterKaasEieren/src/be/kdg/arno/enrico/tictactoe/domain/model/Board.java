package be.kdg.arno.enrico.tictactoe.domain.model;


public class Board {
    private int size;
    private String[][] tiles;
    /*private ArrayList<String>[][] tiles;*/
    private int pieceCounter;

    public Board(int size) {
        this.size = size;
        this.tiles = new String[size][size];
        /*this.tiles = new ArrayList[size][size];*/
        this.pieceCounter = 0;
    }

    public boolean addPiece(String player, int colNumber, int rowNumber) {
        if (this.tiles[colNumber][rowNumber] == null) {
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
        return tiles[col][row] == null || tiles[col][row].isEmpty();
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
            if ((tiles[0][0] + tiles[0][1] + tiles[0][2]).equals("XXX") || (tiles[0][0] + tiles[0][1] + tiles[0][2]).equals("OOO")) {  //bovenste rij (horizontaal)
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
            }
            /*// Check horizontal lines
            for (int row = 0; row < 3; row++) {
                if (tiles[row][0].equals("X") && tiles[row][1].equals("X") && tiles[row][2].equals("X") ||
                        tiles[row][0].equals("O") && tiles[row][1].equals("O") && tiles[row][2].equals("O")) {
                    return true;
                }
            }

            // Check vertical lines
            for (int col = 0; col < 3; col++) {
                if (tiles[0][col].equals("X") && tiles[1][col].equals("X") && tiles[2][col].equals("X") ||
                        tiles[0][col].equals("O") && tiles[1][col].equals("O") && tiles[2][col].equals("O")) {
                    return true;
                }
            }

            // Check diagonal lines
            if (tiles[0][0].equals("X") && tiles[1][1].equals("X") && tiles[2][2].equals("X") ||
                    tiles[0][0].equals("O") && tiles[1][1].equals("O") && tiles[2][2].equals("O")) {
                return true;
            }

            if (tiles[0][2].equals("X") && tiles[1][1].equals("X") && tiles[2][0].equals("X") ||
                    (tiles[0][2].equals("O") && tiles[1][1].equals("O") && tiles[2][0].equals("O"))) {
                return true;
            }

            // No win found
            return false;*/
        }
        //TODO: size 5 en 7
        return false;
    }

    public int getSize() {
        return size;
    }
}
