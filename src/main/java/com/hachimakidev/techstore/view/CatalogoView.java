package com.hachimakidev.techstore.view;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class CatalogoView {

    private TableView<Dispositivo> tablaDispositivos;
    private DispositivoController dispositivoController;

    public CatalogoView() {

        dispositivoController = new DispositivoController();

        configurarTabla();
        cargarDispositivos();
    }

    private void configurarTabla() {

        tablaDispositivos = new TableView<>();

        // Columna ID
        TableColumn<Dispositivo, Integer> columnaId =
                new TableColumn<>("ID");

        columnaId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        // Columna Tipo
        TableColumn<Dispositivo, String> columnaTipo =
                new TableColumn<>("Tipo");

        columnaTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));

        // Columna Marca
        TableColumn<Dispositivo, String> columnaMarca =
                new TableColumn<>("Marca");

        columnaMarca.setCellValueFactory(
                new PropertyValueFactory<>("marca"));

        // Columna Modelo
        TableColumn<Dispositivo, String> columnaModelo =
                new TableColumn<>("Modelo");

        columnaModelo.setCellValueFactory(
                new PropertyValueFactory<>("modelo"));

        // Columna Precio
        TableColumn<Dispositivo, Integer> columnaPrecio =
                new TableColumn<>("Precio");

        columnaPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        // Columna Disponible
        TableColumn<Dispositivo, Boolean> columnaDisponible =
                new TableColumn<>("Disponible");

        columnaDisponible.setCellValueFactory(
                new PropertyValueFactory<>("disponible"));

        TableColumn<Dispositivo, String> columnaImagen =
        new TableColumn<>("Imagen");

        columnaImagen.setCellValueFactory(
        new PropertyValueFactory<>("imagen"));



        // Agregar columnas a la tabla
        tablaDispositivos.getColumns().add(columnaId);
        tablaDispositivos.getColumns().add(columnaTipo);
        tablaDispositivos.getColumns().add(columnaMarca);
        tablaDispositivos.getColumns().add(columnaModelo);
        tablaDispositivos.getColumns().add(columnaPrecio);
        tablaDispositivos.getColumns().add(columnaDisponible);
        tablaDispositivos.getColumns().add(columnaImagen);

        // 1. Configuramos altura fija para las imágenes
tablaDispositivos.setFixedCellSize(110);

// 2. Personalizamos la columna Imagen
columnaImagen.setCellFactory(columna -> {

    return new TableCell<Dispositivo, String>() {

        private final ImageView vistaImagen = new ImageView();

        {
            vistaImagen.setFitWidth(70);
            vistaImagen.setFitHeight(100);
            vistaImagen.setPreserveRatio(true);
        }

        @Override
        protected void updateItem(String rutaImagen, boolean vacio) {

            super.updateItem(rutaImagen, vacio);

            if (vacio || rutaImagen == null || rutaImagen.isBlank()) {

                setGraphic(null);
                setText(null);

            } else {

                Image imagen = new Image(rutaImagen, true);

                vistaImagen.setImage(imagen);

                setGraphic(vistaImagen);
                setText(null);
            }
        }
    };
});
    }

    private void cargarDispositivos() {

        ObservableList<Dispositivo> dispositivos =
                FXCollections.observableArrayList(
                        dispositivoController.getDispositivos());

        tablaDispositivos.setItems(dispositivos);
    }

    public Scene catalogo() {

        VBox contenedor = new VBox(tablaDispositivos);

        Scene escena = new Scene(contenedor, 800, 600);

        return escena;
    }
}