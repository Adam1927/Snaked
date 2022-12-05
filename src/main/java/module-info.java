module snaked.snaked {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    opens snaked to javafx.fxml;
    exports snaked;
    exports snaked.controller;
    exports snaked.model;
    exports snaked.sceneController;

    opens snaked.controller to javafx.fxml;

    opens snaked.sceneController to javafx.fxml;
}