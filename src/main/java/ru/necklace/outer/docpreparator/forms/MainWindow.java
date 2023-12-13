package ru.necklace.outer.docpreparator.forms;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindow {

    private final HostServices hostServices;

    @FXML
    public Label label;

    @FXML
    public Button button;


    public MainWindow(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    public void initialize () {
        this.button.setOnAction(actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
    }
}
