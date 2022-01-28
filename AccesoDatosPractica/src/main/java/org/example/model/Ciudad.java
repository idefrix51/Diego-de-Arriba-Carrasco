package org.example.model;

import java.sql.Date;

public class Ciudad {
    private int Id;
    private String Nombre;
    private int PoblacionONU;
    private int PoblacionCenso;
    private String Pais;


    public Ciudad(){

    }

    public Ciudad(int id, String Nombre, int poblacionONU, int poblacionCenso, String pais) {
        Id = id;
        this.Nombre = Nombre;
        PoblacionONU = poblacionONU;
        PoblacionCenso = poblacionCenso;
        Pais = pais;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPoblacionONU() {
        return PoblacionONU;
    }

    public void setPoblacionONU(int poblacionONU) {
        PoblacionONU = poblacionONU;
    }

    public int getPoblacionCenso() {
        return PoblacionCenso;
    }

    public void setPoblacionCenso(int poblacionCenso) {
        PoblacionCenso = poblacionCenso;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", PoblacionONU=" + PoblacionONU +
                ", PoblacionCenso=" + PoblacionCenso +
                ", Pais='" + Pais + '\'' +
                '}';
    }
}
