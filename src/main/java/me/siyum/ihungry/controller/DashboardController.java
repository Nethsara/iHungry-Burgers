package me.siyum.ihungry.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.siyum.ihungry.HelloApplication;

import java.io.IOException;

public class DashboardController {
    public AnchorPane pane;

    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void placeOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PlaceOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    public void updateOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Update.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void viewOrderOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
