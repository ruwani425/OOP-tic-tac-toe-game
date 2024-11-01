package com.assignment.tictactoe.controller;

import com.assignment.tictactoe.service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class BoardController implements BoardUI {

    @FXML
    private GridPane gridPane;
    @FXML
    private Button restartGameBtn;

    private final Image xImage = new Image(getClass().getResourceAsStream("/assert/x.png"));
    private final Image oImage = new Image(getClass().getResourceAsStream("/assert/circle.png"));
    private boolean isPlayerX = true;

    private Player humanPlayer;
    private Player aiPlayer;

    private Board board;

    @FXML
    void initialize() {
        board=new BoardImpl(this);
        humanPlayer=new HumanPlayer(board);
        aiPlayer=new AIPlayer(board);
    }

    public void onCellClicked(MouseEvent event) {
        if (isPlayerX){
            ImageView clickedImageView = (ImageView) event.getSource();

            Integer rowIndex = GridPane.getRowIndex(clickedImageView);
            Integer columnIndex = GridPane.getColumnIndex(clickedImageView);

            humanPlayer.move(rowIndex, columnIndex);
            clickedImageView.disableProperty().unbind();
        }
    }

    @Override
    public void update(int row, int col, boolean isHuman) {
        for (var node : gridPane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);
            rowIndex = (rowIndex == null) ? 0 : rowIndex;
            columnIndex = (columnIndex == null) ? 0 : columnIndex;

            if (rowIndex == row && columnIndex == col && node instanceof ImageView) {
                ImageView imageView = (ImageView) node;
                if (isHuman){
                    imageView.setImage(xImage);
                    isPlayerX=false;
                    if (!isPlayerX){
                        aiPlayer.move(-1,-1);
                    }
                    break;
                }else{
                    imageView.setImage(oImage);
                    isPlayerX=true;
                }
                break;
            }
        }
    }

    @Override
    public void notifyWinner(Winner winner) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);

            if (winner.getWinningPiece() == Piece.X) {
                alert.setContentText("Player X is the winner!");
            } else if (winner.getWinningPiece() == Piece.O) {
                alert.setContentText("Player O is the winner!");
            } else{
                alert.setContentText("It's a draw!");
            }

            alert.setOnHidden(dialogEvent -> gameReStartOnAction(null));

            alert.showAndWait();
    }


    @FXML
    void gameReStartOnAction(ActionEvent event) {
        for (var node : gridPane.getChildren()) {
            if (node instanceof ImageView) {
                ((ImageView) node).setImage(null);
            }
        }

        initialize();

        isPlayerX = true;

        board.initializeBoard();

    }
}
