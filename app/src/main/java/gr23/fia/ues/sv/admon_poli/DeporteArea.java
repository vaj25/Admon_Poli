package gr23.fia.ues.sv.admon_poli;

/**
 * Created by Moisés on 08/05/2016.
 */
public class DeporteArea {

    private  int idArea;
    private int idDeporte;
    private String descripcion;
    private String activo;

    public DeporteArea(int idArea, int idDeporte, String descripcion, String activo) {
        this.idArea = idArea;
        this.idDeporte = idDeporte;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public DeporteArea() {
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String isActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}

