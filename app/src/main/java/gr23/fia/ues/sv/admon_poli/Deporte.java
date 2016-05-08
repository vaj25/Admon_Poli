package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 07/05/2016.
 */
public class Deporte {

    private int idDeporte ;
    private String nombre ;

    public Deporte(int idDeporte, String nombre) {
        this.idDeporte = idDeporte;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        this.idDeporte = idDeporte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
