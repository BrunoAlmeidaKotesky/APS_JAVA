package com.mycompany.impactopandemiameioambiente;

import java.io.IOException;
import com.mycompany.impactopandemiameioambiente.models.Country;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MenuController {

    @FXML
    private Button euaBtn;
    @FXML
    private Button italyBtn;
    @FXML
    private Button europaBtn;
    @FXML
    private Button chinaBtn;

    @FXML
    private static FXMLLoader loadFXML(String fxml) throws IOException {
        var filePath = MenuController.class.getResource(fxml + ".fxml");
        return new FXMLLoader(filePath);
    }

    private void sendData(ActionEvent event, String[] data) {
        Country country = new Country();
        Node node = (Node) event.getSource();
        country.setNome(data[0]);
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = loadFXML("Tela_Pais");
            CountryController controller = new CountryController();
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            controller.setCountry(country);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public void initialize() {
        euaBtn.setOnAction(e -> sendData(e, new String[]{"EUA"}));
        euaBtn.setOnAction(e -> sendData(e, new String[]{"ITALY"}));
    }
}
