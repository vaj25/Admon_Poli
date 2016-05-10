package gr23.fia.ues.sv.admon_poli;

/**
 * Created by User on 08/05/2016.
 */
public class DetalleReserva {


    private int idReserva;
    private int idArea;

    public DetalleReserva(int idReserva, int idArea){
        this.idReserva = idReserva;
        this.idArea =  idArea;
    }

    public DetalleReserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

}
