module com.mycompany.apsimpactomeioambientecovid {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.apsimpactomeioambientecovid to javafx.fxml;
    exports com.mycompany.apsimpactomeioambientecovid;
}
