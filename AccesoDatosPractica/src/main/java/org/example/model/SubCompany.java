package org.example.model;

public class SubCompany {
    private int id;
    private String name;
    private String ubicacion;
public SubCompany(){

}
    public SubCompany(int id, String name, String ubicacion) {
        this.id = id;
        this.name = name;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "SubCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
