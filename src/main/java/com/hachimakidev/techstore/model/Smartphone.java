package com.hachimakidev.techstore.model;

public class Smartphone extends Dispositivo {

    private int almacenamientoGb;
    private int camaraMp;

    public Smartphone(int id, String marca, String modelo, int precio, boolean disponible, String imagen,
            int almacenamientoGb, int camaraMp) {
        super(id, marca, modelo, precio, disponible, imagen);
        this.almacenamientoGb = almacenamientoGb;
        this.camaraMp = camaraMp;
    }



    public Smartphone(int almacenamientoGb, int camaraMp) {
        this.almacenamientoGb = almacenamientoGb;
        this.camaraMp = camaraMp;
    }



    public Smartphone() {}



    @Override
    public String getTipo() {
        return "Smartphone";
    }

    @Override
    public String getEspecificacion() {
        return almacenamientoGb + " GB · " + camaraMp + " MP";
    }

    public int getAlmacenamientoGb() {
        return almacenamientoGb;
    }

    public void setAlmacenamientoGb(int almacenamientoGb) {
        this.almacenamientoGb = almacenamientoGb;
    }

    public int getCamaraMp() {
        return camaraMp;
    }

    public void setCamaraMp(int camaraMp) {
        this.camaraMp = camaraMp;
    }
}

