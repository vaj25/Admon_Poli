package gr23.fia.ues.sv.admon_poli;

/**
 * Created by Moisés on 08/05/2016.
 */
public class DeporteArea {

    private  int idArea;
    private int idDeporte;

    public DeporteArea(){

    }
    public DeporteArea(int idArea,int idDeporte){
        this.idArea=idArea;
        this.idDeporte=idDeporte;
    }
    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        idDeporte = idDeporte;
    }
    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        idArea = idArea;
    }

}

