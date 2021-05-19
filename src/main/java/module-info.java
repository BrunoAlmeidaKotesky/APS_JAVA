module com.mycompany.apsimpactomeioambientecovid {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    opens com.mycompany.apsimpactomeioambientecovid to javafx.fxml;
    exports com.mycompany.apsimpactomeioambientecovid;
}
