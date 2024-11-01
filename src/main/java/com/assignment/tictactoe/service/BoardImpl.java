package com.assignment.tictactoe.service;

public class BoardImpl implements Board {

    public Piece[][] pieces;
    public BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        initializeBoard();
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public void initializeBoard() {
        pieces = new Piece[3][3];//grid pane cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    @Override
    public boolean isLegalMove(int row, int col) {
        return pieces[row][col] == Piece.EMPTY;
    }

    @Override
    public void updateMove(int row, int col, Piece piece) {
        pieces[row][col] = piece;
        printBoard();
    }



    @Override
    public Winner checkWinner() {

        for (int row = 0; row < 3; row++) {
            if (pieces[row][0] != Piece.EMPTY && pieces[row][0] == pieces[row][1] && pieces[row][1] == pieces[row][2]) {
                return new Winner(pieces[row][0], 0, row, 1, row, 2, row);
            }
        }

        for (int col = 0; col < 3; col++) {
            if (pieces[0][col] != Piece.EMPTY && pieces[0][col] == pieces[1][col] && pieces[1][col] == pieces[2][col]) {
                return new Winner(pieces[0][col], col, 0, col, 1, col, 2);
            }
        }

        if (pieces[0][0] != Piece.EMPTY && pieces[0][0] == pieces[1][1] && pieces[1][1] == pieces[2][2]) {
            return new Winner(pieces[0][0], 0, 0, 1, 1, 2, 2);
        }

        if (pieces[0][2] != Piece.EMPTY && pieces[0][2] == pieces[1][1] && pieces[1][1] == pieces[2][0]) {
            return new Winner(pieces[0][2], 2, 0, 1, 1, 0, 2);
        }
        return null;
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(pieces[i][j]);
            }
        }
    }
}
