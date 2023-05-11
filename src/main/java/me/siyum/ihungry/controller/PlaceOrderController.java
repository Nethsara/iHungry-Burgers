package me.siyum.ihungry.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.siyum.ihungry.HelloApplication;
import me.siyum.ihungry.db.Database;
import me.siyum.ihungry.model.Customer;
import me.siyum.ihungry.model.Order;
import me.siyum.ihungry.util.IDGenerator;
import me.siyum.ihungry.util.Rgex;
import me.siyum.ihungry.util.Validation;

import java.io.IOException;

public class PlaceOrderController {
    public TextField txtCostID;
    public TextField txtCustName;
    public TextField txtBurgerQty;
    public TextField txtBillValue;
    public JFXButton btnPlaceOrder;
    public Label txtOrderID;
    public AnchorPane pane;

    public void initialize(){
        txtOrderID.setText(IDGenerator.getID());
        btnPlaceOrder.setDisable(true);
    }

    public void validateThePhoneNumber() {
        if (!Validation.isTextFieldValid(Rgex.SRI_LANKA_MOBILE, txtCostID.getText())) {
            new Alert(Alert.AlertType.ERROR, "Please enter valid phone number").show();
            btnPlaceOrder.setDisable(true);
        } else {
            Customer c = Database.getCustomer(txtCostID.getText());
            if (c != null) {
                txtCustName.setText(c.getName());
            } else {
                new Alert(Alert.AlertType.ERROR, "Customer not found").show();
            }
        }
    }

    public void calculatePrice() {
        try {
            txtBillValue.setText(String.valueOf(Integer.parseInt(txtBurgerQty.getText()) * 500));
            btnPlaceOrder.setDisable(false);
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Enter a number").show();
            btnPlaceOrder.setDisable(true);
        }
    }

    public void cancelOnAction() {
        txtOrderID.setText(IDGenerator.getID());
        txtBillValue.clear();
        txtCustName.clear();
        txtCostID.clear();
        txtBurgerQty.clear();
    }

    public void placeOrderOnAction() {
        Customer c = new Customer(txtCostID.getText(), txtCustName.getText());
        boolean b = Database.checkDuplicates(Database.customerArray,c);
        if (b) {
            boolean orderAdded = Database.addToDatabase(
                    new Order(
                            txtOrderID.getText(),
                            txtCostID.getText(),
                            Integer.parseInt(txtBurgerQty.getText()),
                            0
                    )
            );
            if (orderAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Done Adding").show();
                txtOrderID.setText(IDGenerator.getID());
                btnPlaceOrder.setDisable(true);
                cancelOnAction();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Exists").show();
        }
    }


    public void returnToHomeOnAction() throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
