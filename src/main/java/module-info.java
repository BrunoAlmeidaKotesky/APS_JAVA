/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module MeioAmbiente_Gradle {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.controlsEmpty;
    requires javafx.graphics;
    requires javafx.graphicsEmpty;
    requires javafx.base;
    requires javafx.baseEmpty;
    opens MeioAmbiente_Gradle to javafx.fxml;
    exports MeioAmbiente_Gradle;
}
