package com.assignment.tictactoe.service;

public class HumanPlayer extends Player {
    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void move(int row, int col) {
        if (board.isLegalMove(row, col)) {
            board.updateMove(row, col, Piece.X);
            board.getBoardUI().update(col,row,true);
        }
        Winner winner = board.checkWinner();
        if (winner==null){
            return;
        }
        if(winner.getWinningPiece() == Piece.X) {
            board.getBoardUI().notifyWinner(winner);
        }
    }
}
