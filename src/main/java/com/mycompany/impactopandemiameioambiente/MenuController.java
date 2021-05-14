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
    private Button infoBtn1;
    @FXML
    private Button infoBtn2;
    @FXML
    private Button infoBtn3;
    @FXML
    private Button docBtn;

    @FXML
    private static FXMLLoader loadFXML(String fxml) throws IOException {
        var filePath = MenuController.class.getResource(fxml + ".fxml");
        return new FXMLLoader(filePath);
    }

    private void sendData(ActionEvent event, String[] data) {
        Country country = new Country();
        Node node = (Node) event.getSource();
        country.setNome(data[0]);
        country.setTexto(data[1]);
        country.setUrlImagem(data[2]);
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = loadFXML("Tela_Pais");
            CountryController controller = new CountryController();
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            controller.setData(country);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public void initialize() {
        euaBtn.setOnAction(e -> sendData(e, new String[]{"Estados Unidos", "Texto estados unidos", "https://i.imgur.com/EuhjrDW.png"}));
        italyBtn.setOnAction(e -> sendData(e, new String[]{"Itália", "Texto da italia", "https://i.imgur.com/8cKNigN.png"}));
        chinaBtn.setOnAction(e -> sendData(e, new String[]{"China", "Texto da China", "https://i.imgur.com/bsmkDGH.png"}));
        europaBtn.setOnAction(e -> sendData(e, new String[]{"União Europeia", "Texto da Europa", "https://i.imgur.com/pnlkcsF.png"}));
        infoBtn1.setOnAction(e -> sendData(e, new String[]{"União Europeia", "Texto da Europa", "https://i.imgur.com/pnlkcsF.png"}));
        infoBtn2.setOnAction(e -> sendData(e, new String[]{"União Europeia", "Texto da Europa", "https://i.imgur.com/pnlkcsF.png"}));
        infoBtn3.setOnAction(e -> sendData(e, new String[]{"União Europeia", "Texto da Europa", "https://i.imgur.com/pnlkcsF.png"}));
    }
}
