package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    ArrayList<Dispositivo> lista_dispositivos = new ArrayList<>();

    public DispositivoManager() {
        loadDispositivo();
    }

    public void loadDispositivo(){
        InputStream cadena = getClass().getResourceAsStream("/dispositivos.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        JsonObject[] dispositivos = gson.fromJson(lector, JsonObject[].class);
    

        for(JsonObject dispositivo : dispositivos){

            String tipo = dispositivo.get("tipo").getAsString();
            
            switch (tipo){
                case "notebook":
                    
                int id = dispositivo.get("id").getAsInt();
                String marca = dispositivo.get("marca").getAsString();
                String modelo = dispositivo.get("modelo").getAsString();
                int precio = dispositivo.get("precio").getAsInt();
                boolean disponible = dispositivo.get("disponible").getAsBoolean();
                int ramGb = dispositivo.get("ramGb").getAsInt();
                String procesador = dispositivo.get("procesador").getAsString();
                String imagen = dispositivo.has("imagen")
                ? dispositivo.get("imagen").getAsString()
                : "";

                Notebook notebook = new Notebook(id, marca, modelo, precio, disponible, imagen, ramGb, procesador);
                lista_dispositivos.add(notebook);
                break;

                case "smartphone":
                    int idS = dispositivo.get("id").getAsInt();
                    String marcaS = dispositivo.get("marca").getAsString();
                    String modeloS = dispositivo.get("modelo").getAsString();
                    int precioS = dispositivo.get("precio").getAsInt();
                    boolean disponibleS = dispositivo.get("disponible").getAsBoolean();
                    int almacenamientoGbS = dispositivo.get("almacenamientoGb").getAsInt();
                    int camaraMp = dispositivo.get("camaraMp").getAsInt();
                    String imagenS = dispositivo.has("imagen")
                        ? dispositivo.get("imagen").getAsString()
                        : "";

                    Smartphone smartphone = new Smartphone(idS, marcaS, modeloS, precioS, disponibleS, imagenS, almacenamientoGbS, camaraMp);
                    lista_dispositivos.add(smartphone);
                    break;

            }
        }



}

    public ArrayList<Dispositivo> getDispositivos() {
        return lista_dispositivos;
    }

    public void mostrarDispositivos() {
        for (Dispositivo dispositivo : lista_dispositivos) {
            System.out.println(dispositivo);

        }
    }
}


