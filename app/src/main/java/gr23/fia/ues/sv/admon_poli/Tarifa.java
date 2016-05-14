package gr23.fia.ues.sv.admon_poli;

import java.sql.Time;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Tarifa {
    public Double montoArea;
    public Double canthora;
    public int cantPersonas;

    public Double monto(){

        return 0.5*canthora+1*cantPersonas;
    }

    public Tarifa(Double canthora, int cantPersonas) {

        this.canthora = canthora;
        this.cantPersonas = cantPersonas;
        setMontoArea();
    }

    public Tarifa() {
    }

    public Double getMontoArea() {
        return montoArea;
    }

    public void setMontoArea() {
        this.montoArea = monto();
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
}
