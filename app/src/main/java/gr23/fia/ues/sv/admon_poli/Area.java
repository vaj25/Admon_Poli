package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Area {

    private int idArea ;
    private String nombre ;
    private int capacidad ;
    private float area ; // esta area es en mt2
    private int idDeporte ;

    public Area(int idArea, String nombre, int capacidad, float area) {
        this.idArea = idArea;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.area = area;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }
}
