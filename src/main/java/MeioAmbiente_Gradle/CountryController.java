package MeioAmbiente_Gradle;
 
import java.io.IOException;
import MeioAmbiente_Gradle.models.Country;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class CountryController {

    @FXML
    private TextArea textfield;
    @FXML
    private Label label;
    @FXML
    private ImageView img;

    @FXML
    private void returnToMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));  
        Stage stage = new Stage();
        Node node = (Node) event.getSource();
        Stage thisWindow = (Stage) node.getScene().getWindow();
        thisWindow.close();
        stage.setScene(new Scene((Parent) loader.load()));
        stage.showAndWait();
    }

    private void setImageData(String imgUrl) {
        img.setFitWidth(225);
        img.setFitHeight(225);
        img.setLayoutX(325);
        img.setLayoutY(118);
        img.setPickOnBounds(true);
        img.setPreserveRatio(true);
        img.setImage(new Image(imgUrl, 180, 180, true, true));
    }

    @FXML
    public void setData(Country country) {
        textfield.setText(country.getTexto());
        label.setText(country.getNome());
        setImageData(country.getUrlImagem());
    }

    @FXML
    private void initialize() {
        System.out.println("Tela carregada");
    }
}   

