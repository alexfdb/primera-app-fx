module es.ies.puerto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;

    exports es.ies.puerto;
    exports es.ies.puerto.controller;
    exports es.ies.puerto.crud;
    exports es.ies.puerto.model;
    exports es.ies.puerto.util;

    opens es.ies.puerto to javafx.fxml;
    opens es.ies.puerto.controller to javafx.fxml;
}