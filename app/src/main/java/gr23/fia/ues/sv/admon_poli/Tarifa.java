package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Tarifa {
    public Double montoArea;
    public Double canthora;
    public int cantPersonas;

    public Tarifa(Double montoArea, double canthora, int cantPersonas) {
        this.montoArea = montoArea;
        this.canthora = canthora;
        this.cantPersonas = cantPersonas;
    }

    public Tarifa() {
    }

    public Double getMontoArea() {
        return montoArea;
    }

    public void setMontoArea(Double montoArea) {
        this.montoArea = montoArea;
    }

    public double getCanthora() {
        return canthora;
    }

    public void setCanthora(double canthora) {
        this.canthora = canthora;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
}
