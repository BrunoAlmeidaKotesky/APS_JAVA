package com.mycompany.impactopandemiameioambiente;

import java.io.IOException;

import com.mycompany.impactopandemiameioambiente.models.Country;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CountryController {

    @FXML
    private TextArea textfield;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Menu");
    }

    @FXML
    public void setCountry(Country country) {
        textfield.setText(country.texto);
    }

    @FXML
    private void initialize() {
        textfield.setText("I'm a Label.");
    }
}