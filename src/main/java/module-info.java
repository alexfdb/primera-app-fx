module es.ies.puerto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires transitive javafx.graphics;
    requires com.fasterxml.jackson.databind;

    exports es.ies.puerto;
    exports es.ies.puerto.controller;
    exports es.ies.puerto.model;

    opens es.ies.puerto to javafx.fxml;
    opens es.ies.puerto.controller to javafx.fxml;
    opens es.ies.puerto.model to com.fasterxml.jackson.databind;
}