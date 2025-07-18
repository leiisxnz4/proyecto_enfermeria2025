package models;

public class TipoSangre {
    private int id;
    private String nombre;

    public TipoSangre() {}

    public TipoSangre(String nombre) {
        this.nombre = nombre;
    }

    public TipoSangre(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
