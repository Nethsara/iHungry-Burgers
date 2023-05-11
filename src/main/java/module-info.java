module me.siyum.ihungry {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens me.siyum.ihungry to javafx.fxml;
    exports me.siyum.ihungry;
    exports me.siyum.ihungry.controller;
    exports me.siyum.ihungry.db;
    exports me.siyum.ihungry.model;
    exports me.siyum.ihungry.tm;
    opens me.siyum.ihungry.controller to javafx.fxml;
}