package com.hachimakidev.techstore.controller;

import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.DispositivoManager;

import java.util.ArrayList;

public class DispositivoController {


    private DispositivoManager dispositivoManager;
    
    public DispositivoController(){
        dispositivoManager = new DispositivoManager();

    }

    public ArrayList<Dispositivo> getDispositivos(){
        return dispositivoManager.getDispositivos();
    }



    // TODO 1: Instanciar DispositivoManager como atributo del controlador.

    // TODO 2: Crear el método que retorne la lista de dispositivos desde el manager hacia la vista.

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

}

