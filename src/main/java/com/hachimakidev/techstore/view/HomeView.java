package com.hachimakidev.techstore.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HomeView {

    public Scene homeScene(){
        VBox vbox_home = new VBox(10, homeUserDataSearchComponent());
        vbox_home.setPadding(new Insets(20));
        return new Scene(vbox_home, 720, 480); 
    }

    private VBox homeUserDataSearchComponent(){


        Label lbl_marca = new Label("Consultar por marca");
        
        TextField txf_marca = new TextField();
        txf_marca.setPromptText("Ej: samsung");

        Button btn_buscar_por_marca = new Button("Buscar por marca");

        HBox hbox_marca = new HBox(10, lbl_marca, txf_marca, btn_buscar_por_marca);

        Label lbl_data_marca = new Label("Marca: _________");
        Label lbl_data_modelo = new Label("Modelo: _________");
        Label lbl_data_precio = new Label("Precio: _________");
        Label lbl_data_disponible = new Label("Disponible: __________");

        VBox vbox_data_dispositivo = new VBox(10, lbl_data_disponible, lbl_data_modelo, lbl_data_marca, lbl_data_precio);

        Button btn_catalogo = new Button("Ver catálogo");

        btn_catalogo.setOnAction(e -> {

            CatalogoView catalogoView = new CatalogoView();
            Scene escenaCatalogo = catalogoView.catalogo();

           Stage ventana = (Stage) btn_catalogo
            .getScene()
            .getWindow();

            ventana.setScene(escenaCatalogo);
        });

        VBox vbox = new VBox(14, vbox_data_dispositivo, btn_catalogo);
        return vbox;

    }
}

