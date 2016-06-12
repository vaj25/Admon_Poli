package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Solicitud {

    private int idSolicitud;
    private String estado;
    private String fechaSolicitud;
    private String fechaReserva;
    private int idAdministrador;
    private int idActividad;
    private String dui;
    private int idTarifa;

    public Solicitud() {
    }

    public Solicitud(int idSolicitud, String estado, String fechaSolicitud, String fechaReserva, int idAdministrador, int idActividad, String dui, int idTarifa) {
        this.idSolicitud = idSolicitud;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaReserva = fechaReserva;
        this.idAdministrador = idAdministrador;
        this.idActividad = idActividad;
        this.dui = dui;
        this.idTarifa = idTarifa;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    @Override
    public String toString() {
        return idSolicitud +"-"+ fechaReserva;
    }
}