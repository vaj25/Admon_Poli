package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 * Clase de actividad de la solicitud
 *
 */
public class Actividad {
    private int idactividad;
    private String nombreactividad;

    public Actividad (int idactiv, String nomactiv){
        this.idactividad=idactiv;
        this.nombreactividad=nomactiv;
    }
public Actividad(){

}
    public int getIdActividad(){
        return this.idactividad;
    }

    public void setIdActividad(int idactiv){
        this.idactividad=idactiv;
    }

    public String getNombreactividad(){
        return this.nombreactividad;
    }

    public void setNombreactividad(String nombreactiv){
        this.nombreactividad=nombreactiv;
    }
}
