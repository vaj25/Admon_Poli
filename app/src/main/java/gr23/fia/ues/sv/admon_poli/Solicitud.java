package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Solicitud {

    private int idSolicitud ;
    private String Estado ;
    private Date FechaSolicitud ;
    private Date FechaReserva ;
    private int CantAsistentes ;

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Date getFechaSolicitud() {
        return FechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        FechaSolicitud = fechaSolicitud;
    }

    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        FechaReserva = fechaReserva;
    }

    public int getCantAsistentes() {
        return CantAsistentes;
    }

    public void setCantAsistentes(int cantAsistentes) {
        CantAsistentes = cantAsistentes;
    }
}
