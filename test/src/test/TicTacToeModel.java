package test;

class TicTacToeModel {
    public static final int SIZE = 3;
    private String[][] grid = new String[SIZE][SIZE];

    public String[][] getGrid() {
        return grid;
    }

    public void setGridValue(int row, int col, String value) {
        grid[row][col] = value;
    }
}