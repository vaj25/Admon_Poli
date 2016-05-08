package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Solicitud {

    private int idSolicitud ;
    private int idTarifa ;
    private String Estado ;
    private String FechaSolicitud ;
    private String FechaReserva ;
    private int CantAsistentes ;

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaSolicitud() {
        return FechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        FechaSolicitud = fechaSolicitud;
    }

    public String getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        FechaReserva = fechaReserva;
    }

    public int getCantAsistentes() {
        return CantAsistentes;
    }

    public void setCantAsistentes(int cantAsistentes) {
        CantAsistentes = cantAsistentes;
    }
}
