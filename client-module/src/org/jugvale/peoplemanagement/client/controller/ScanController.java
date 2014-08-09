/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jugvale.peoplemanagement.client.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.jugvale.peoplemanagement.client.rfid.ui.FTDIReaderPane;

/**
 * FXML Controller class
 *
 * @author william
 */
public class ScanController implements Initializable {

    @FXML
    VBox infoPane;

    @FXML
    StackPane mainPane;

    @FXML
    Label lblRFID;

    @FXML
    Label lblReadInfo;

    @FXML
    Label lblStatus;

    FTDIReaderPane rfidPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rfidPane = new FTDIReaderPane(s -> {
            lblRFID.setText("RFID: " + s);
            lblStatus.setText("RFID Read. Searching info on the DB...");
            getPersonInfo(s);
        }, lblStatus::setText);
        rfidPane.setVisible(false);
        mainPane.getChildren().add(rfidPane);
        infoPane.visibleProperty().bind(rfidPane.visibleProperty().not());
    }

    public void readRFID() {
        rfidPane.askForDeviceAndReadTag();
    }

    public void getPersonInfo(String rfid) {
        // TODO: Go to the API and bring info!
    }

}
