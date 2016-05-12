package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Solicitud {

    private int idSolicitud;
    private String estado;
    private String fechaSolicitud;
    private String fechaReserva;
    private int cantAsistentes;
    private int idAdministrador;
    private int idActividad;
    private String dui;
    private double montoArea;
    private String horaReservada;

    public Solicitud(int idSolicitud, double montoArea, String estado, String fechaSolicitud, String fechaReserva, int cantAsistentes, int idAdministrador, int idActividad, String dui, String horaReservada) {
        this.idSolicitud = idSolicitud;
        this.montoArea = montoArea;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaReserva = fechaReserva;
        this.cantAsistentes = cantAsistentes;
        this.idAdministrador = idAdministrador;
        this.idActividad = idActividad;
        this.dui = dui;
        this.horaReservada = horaReservada;
    }

    public Solicitud() {
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public double getMontoArea() { return montoArea; }

    public void setMontoArea(double montoArea) { this.montoArea = montoArea; }

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

    public int getCantAsistentes() {
        return cantAsistentes;
    }

    public void setCantAsistentes(int cantAsistentes) {
        this.cantAsistentes = cantAsistentes;
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

    public String getHoraReservada() {
        return horaReservada;
    }

    public void setHoraReservada(String horaReservada) {
        this.horaReservada = horaReservada;
    }
}