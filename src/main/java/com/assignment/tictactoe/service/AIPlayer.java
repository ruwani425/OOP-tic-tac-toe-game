package com.assignment.tictactoe.service;

public class AIPlayer extends Player {

    public AIPlayer(Board board) {
        super(board);
    }

    @Override
    public void move(int row, int col) {
        int[] bestMove = findBestMove();
        if (bestMove != null) {
            board.updateMove(bestMove[0], bestMove[1], Piece.O);
            board.getBoardUI().update(bestMove[0],bestMove[1],false);
        }
        Winner winner = board.checkWinner();
        if (winner==null){
            return;
        }
        if(winner.getWinningPiece() == Piece.O) {
            board.getBoardUI().notifyWinner(winner);
        }
    }

    private int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isLegalMove(row, col)) {
                    board.updateMove(row, col, Piece.O);

                    int score = minimax(false);

                    board.updateMove(row, col, Piece.EMPTY);

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{row, col};
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(boolean isMaximizing) {
        Winner winner = board.checkWinner();

        if (winner != null) {
            if (winner.getWinningPiece() == Piece.O) {
                return 1;
            } else if (winner.getWinningPiece() == Piece.X) {
                return -1;
            } else {
                return 0;
            }
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isLegalMove(row, col)) {
                        board.updateMove(row, col, Piece.O);

                        int score = minimax(false);//method recurtion

                        board.updateMove(row, col, Piece.EMPTY);

                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.isLegalMove(row, col)) {
                        board.updateMove(row, col, Piece.X);

                        int score = minimax(true);

                        board.updateMove(row, col, Piece.EMPTY);

                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
}
