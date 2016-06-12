package gr23.fia.ues.sv.admon_poli;

import java.sql.Time;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Tarifa {

    private int idTarifa ;
    private Double precio;
    private Double canthora;
    private int cantPersonas;

    public void monto(){

        precio = (20*canthora)+(1*cantPersonas);
    }

    public Tarifa(int idTarifa, Double canthora, int cantPersonas) {
        this.idTarifa = idTarifa;
        this.canthora = canthora;
        this.cantPersonas = cantPersonas;
    }

    public Tarifa() {

    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCanthora() {
        return canthora;
    }

    public void setCanthora(Double canthora) {
        this.canthora = canthora;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    @Override
    public String toString(){

        return  "Tarifa: "+ canthora + " horas "+ " -- " + cantPersonas + " personas";
    }
}