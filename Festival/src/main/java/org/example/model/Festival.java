package org.example.model;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class Festival implements Serializable {
    private int Id;
    private String Nombre;
    private String Descripcion;
    private Timestamp Inicio;
    private Timestamp Fin;
    private int Aforo;
    private int Precio;
    private int Ventas;
    private Set<Actuacion> actuacion;

    public Festival(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getAforo() {
        return Aforo;
    }

    public void setAforo(int aforo) {
        Aforo = aforo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public int getVentas() {
        return Ventas;
    }

    public void setVentas(int ventas) {
        Ventas = ventas;
    }

    public Set<Actuacion> getActuacion() {
        return actuacion;
    }

    public void setActuacion(Set<Actuacion> actuacion) {
        this.actuacion = actuacion;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Inicio=" + Inicio +
                ", Fin=" + Fin +
                ", Aforo=" + Aforo +
                ", Precio=" + Precio +
                ", Ventas=" + Ventas +
                ", actuacion=" + actuacion +
                '}';
    }
}
