package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 08/05/2016.
 */
public class DetalleSolicitud {

    private int idSolicitud ;
    private int idArea ;
    private String descripcion;


    public DetalleSolicitud() {
    }

    public DetalleSolicitud(int idSolicitud, int idArea, String descripcion) {
        this.idSolicitud = idSolicitud;
        this.idArea = idArea;
        this.descripcion = descripcion;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }


    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }


}
