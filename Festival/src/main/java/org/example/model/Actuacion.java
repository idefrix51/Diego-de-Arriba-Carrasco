package org.example.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Actuacion implements Serializable {
    private int Id;
    private int IdFestival;
    private String Nombre;
    private String Descripcion;
    private String Grupo;
    private String Escenario;
    private Timestamp Inicio;
    private Timestamp Fin;
    private Festival festival;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdFestival() {
        return IdFestival;
    }

    public void setIdFestival(int idFestival) {
        IdFestival = idFestival;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public String getEscenario() {
        return Escenario;
    }

    public void setEscenario(String escenario) {
        Escenario = escenario;
    }

    public Timestamp getInicio() {
        return Inicio;
    }

    public void setInicio(Timestamp inicio) {
        Inicio = inicio;
    }

    public Timestamp getFin() {
        return Fin;
    }

    public void setFin(Timestamp fin) {
        Fin = fin;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    @Override
    public String toString() {
        return "Actuacion{" +
                "Id=" + Id +
                ", IdFestival=" + IdFestival +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Grupo='" + Grupo + '\'' +
                ", Escenario='" + Escenario + '\'' +
                ", Inicio=" + Inicio +
                ", Fin=" + Fin +
                ", festival=" + festival +
                '}';
    }
}
