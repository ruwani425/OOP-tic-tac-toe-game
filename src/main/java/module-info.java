module com.assignment.tictactoe.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.assignment.tictactoe to javafx.fxml;
    opens com.assignment.tictactoe.controller to javafx.fxml;
    exports com.assignment.tictactoe;
    exports com.assignment.tictactoe.controller;
}