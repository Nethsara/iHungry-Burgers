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
import me.siyum.ihungry.tm.OrdersTM;

import java.io.IOException;
import java.util.Arrays;

public class ViewAllOrdersController {
    public TableColumn<OrdersTM, String> columnOID;
    public TableView<OrdersTM> tbl;
    public TableColumn<OrdersTM, String> columnCID;
    public TableColumn<OrdersTM, String> columnQTY;
    public TableColumn<OrdersTM, String> columnStatus;

    public AnchorPane pane;

    public void initialize() {
        columnCID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        columnOID.setCellValueFactory(new PropertyValueFactory<>("oid"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        columnQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        ObservableList<OrdersTM> orders = FXCollections.observableArrayList();

        Arrays.stream(Database.orderArray).forEach(order -> {
            orders.add(new OrdersTM(
                    order.getOrderId(),
                    order.getCustID(),
                    order.getQty(),
                    order.getStatus() == 0 ? "preparing" : order.getStatus() == 1 ? "completed" : "cancelled"
            ));
        });

        tbl.setItems(orders);

    }

    public void returnHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
