package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 * Clase de actividad de la solicitud
 *
 */
public class Actividad {

    private int idActividad;
    private String nombre;

    public Actividad(int idActividad, String nombre) {
        this.idActividad = idActividad;
        this.nombre = nombre;
    }

    public Actividad(){}

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idactividad) {
        this.idActividad = idactividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Actividad: "+nombre;
    }
}
