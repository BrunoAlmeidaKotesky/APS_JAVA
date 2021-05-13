module com.mycompany.impactopandemiameioambiente {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.mycompany.impactopandemiameioambiente to javafx.fxml;
    exports com.mycompany.impactopandemiameioambiente;
}
