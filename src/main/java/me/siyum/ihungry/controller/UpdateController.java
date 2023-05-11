package me.siyum.ihungry.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.siyum.ihungry.HelloApplication;
import me.siyum.ihungry.db.Database;
import me.siyum.ihungry.model.Customer;
import me.siyum.ihungry.model.Order;

import java.io.IOException;
import java.util.Arrays;

public class UpdateController {
    public ComboBox<String> cmbOID;
    public TextField txtCostID;
    public TextField txtBQty;
    public TextField txtCostName;
    public TextField txtBillValue;
    public ComboBox<String> cmbStatus;
    public AnchorPane pane;

    int index = 0;

    private Order order = new Order();
    private Customer customer = new Customer();

    public void initialize() {
        ObservableList<String> oIDs = FXCollections.observableArrayList();
        Arrays.stream(Database.orderArray).forEach(order -> oIDs.add(order.getOrderId()));

        cmbOID.setItems(oIDs);
        cmbStatus.getItems().addAll(
                "preparing",
                "completed",
                "cancelled"
        );
    }

    public void updateOrder(ActionEvent actionEvent) {
        Database.orderArray[index] = order;
    }

    public void returnHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void cancel(ActionEvent actionEvent) {
    }

    public void selectedOrder(ActionEvent actionEvent) {
        index = Database.getOrder(cmbOID.getValue());
        order = Database.orderArray[index];
        customer = Database.getCustomer(order.getCustID());

        txtCostID.setText(customer.getId());
        txtCostName.setText(customer.getName());
        txtBQty.setText(String.valueOf(order.getQty()));
        txtBillValue.setText(String.valueOf(order.getQty() * 500));

        cmbStatus.getSelectionModel().select(order.getStatus() == 0 ? "preparing" : order.getStatus() == 1 ? "completed" : "cancelled");

    }

    public void calculateTotal() {
        try {
            txtBillValue.setText(String.valueOf(Integer.parseInt(txtBQty.getText()) * 500));
            order.setQty(Integer.parseInt(txtBQty.getText()));
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Enter a number").show();
        }
    }

    public void statusChanged(ActionEvent actionEvent) {
        if (cmbStatus.getValue().equals("completed")) {
            order.setStatus(1);
        } else if (cmbStatus.getValue().equals("cancelled")) {
            order.setStatus(2);
        }
    }
}
