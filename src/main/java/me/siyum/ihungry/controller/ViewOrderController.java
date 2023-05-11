package me.siyum.ihungry.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.siyum.ihungry.HelloApplication;
import me.siyum.ihungry.db.Database;
import me.siyum.ihungry.model.Order;

import java.io.IOException;

public class ViewOrderController {
    public Label txtCostID;
    public Label txtCostName;
    public Label txtBurgerQTY;
    public Label txtTotal;
    public Label txtStatus;
    public TextField txtOID;
    public AnchorPane pane;

    public void searchOrder() {
        Order order = Database.orderArray[Database.getOrder(txtOID.getText())];

        if (order != null) {
            txtCostID.setText(order.getCustID());
            txtBurgerQTY.setText(String.valueOf(order.getQty()));
            txtCostName.setText(Database.getCustomer(order.getCustID()).getName());
            txtTotal.setText(String.valueOf(order.getQty() * 500));
            txtStatus.setText(order.getStatus() == 0 ? "preparing" : order.getStatus() == 1 ? "completed" : "cancelled");

        }
    }

    public void backToView() throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
