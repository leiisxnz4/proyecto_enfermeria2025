package models;

public class Medicamento {
    private int id;
    private String nombre;
    private String dosis;
    private String contraindicaciones;

    public Medicamento() {}

    public Medicamento(String nombre, String dosis, String contraindicaciones) {
        this.nombre = nombre;
        this.dosis = dosis;
        this.contraindicaciones = contraindicaciones;
    }

    public Medicamento(int id, String nombre, String dosis, String contraindicaciones) {
        this.id = id;
        this.nombre = nombre;
        this.dosis = dosis;
        this.contraindicaciones = contraindicaciones;
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

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getContraindicaciones() {
        return contraindicaciones;
    }

    public void setContraindicaciones(String contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
