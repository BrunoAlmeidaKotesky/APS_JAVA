package MeioAmbiente_Gradle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import MeioAmbiente_Gradle.models.Country;
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

    private String[] readCSV(int position) {
        String row = "";
        String[] data = new String[3];
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(MenuController.class.getResourceAsStream("textos.csv")));
        int count = 1;
        try {
            while ((row = csvReader.readLine()) != null) {
                if(count == position) {
                    data = row.split(";");
                }
                count++;
                csvReader.close();

            }
        } catch (IOException e) {
            csvReader.close();
            e.printStackTrace();
            return new String[0];
        }
        finally {
            return data;
        }
    }

    public void initialize() throws IOException {
      euaBtn.setOnAction(e -> sendData(e, readCSV(1)));
      italyBtn.setOnAction(e -> sendData(e, readCSV(2)));
      chinaBtn.setOnAction(e -> sendData(e, readCSV(3)));
      europaBtn.setOnAction(e -> sendData(e, readCSV(4)));
      infoBtn1.setOnAction(e -> sendData(e, readCSV(5)));
      infoBtn2.setOnAction(e -> sendData(e, readCSV(6)));
      infoBtn3.setOnAction(e -> sendData(e, readCSV(7)));
    }
}
