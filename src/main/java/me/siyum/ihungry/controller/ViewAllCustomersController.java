package me.siyum.ihungry.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import me.siyum.ihungry.HelloApplication;
import me.siyum.ihungry.db.Database;
import me.siyum.ihungry.tm.CustomerTM;

import java.io.IOException;
import java.util.Arrays;

public class ViewAllCustomersController {
    public AnchorPane pane;
    public TableView<CustomerTM> tbl;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colTotal;

    public void initialize() {

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        ObservableList<CustomerTM> customers = FXCollections.observableArrayList();
        System.out.println(Arrays.toString(Database.customerArray));
        Arrays.stream(Database.customerArray).forEach(customer -> {
            customers.add(new CustomerTM(
                    customer.getId(),
                    customer.getName(),
                    Database.getOrderTotalByCustID(customer.getId())
            ));
        });

        System.out.println(customers);
        tbl.setItems(customers);
    }

    public void returnHome() throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
