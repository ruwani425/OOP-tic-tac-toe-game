package com.assignment.tictactoe.service;

public class Winner {

    public Piece winningPiece;
    public int col1, row1, col2, row2, col3, row3;


    public Winner(Piece winningPiece, int col1, int row1, int col2, int row2, int col3, int row3) {
        this.winningPiece = winningPiece;
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
        this.col3 = col3;
        this.row3 = row3;
    }

    public Piece getWinningPiece() {
        return winningPiece;
    }

    public int getCol1() {
        return col1;
    }

    public int getRow1() {
        return row1;
    }

    public int getCol2() {
        return col2;
    }

    public int getRow2() {
        return row2;
    }

    public int getCol3() {
        return col3;
    }

    public int getRow3() {
        return row3;
    }

    @Override
    public String toString() {
        return "Winner: " + winningPiece + " with positions (" +
                col1 + ", " + row1 + "), (" +
                col2 + ", " + row2 + "), (" +
                col3 + ", " + row3 + ")";
    }
}
