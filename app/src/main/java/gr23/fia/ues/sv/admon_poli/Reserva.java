package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Reserva {
    private String fechaReserva;
    private Double tiempoReserva;

    public Reserva(String fechaReserva, Double tiempoReserva){
        this.fechaReserva = fechaReserva;
        this.tiempoReserva = tiempoReserva;
    }

    public String getFechaReserva(){
        return fechaReserva;
    }
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Double getTiempoReserva() {
        return tiempoReserva;
    }

    public void setTiempoReserva(Double tiempoReserva) {
        this.tiempoReserva = tiempoReserva;
    }


}
