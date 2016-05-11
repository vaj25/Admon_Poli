package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 08/05/2016.
 */
public class DetalleSolicitud {

    private int idSolicitud ;
    private int idArea ;

    public DetalleSolicitud() {
    }

    public DetalleSolicitud(int idArea, int idSolicitud) {
        this.idArea = idArea;
        this.idSolicitud = idSolicitud;
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
}
