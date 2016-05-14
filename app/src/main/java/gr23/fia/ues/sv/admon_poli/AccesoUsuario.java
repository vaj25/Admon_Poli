package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 13/05/2016.
 */
public class AccesoUsuario {

    String idOpcion ;
    String idUsuario ;

    public AccesoUsuario() {
    }

    public AccesoUsuario(String idOpcion, String idUsuario) {
        this.idOpcion = idOpcion;
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(String idOpcion) {
        this.idOpcion = idOpcion;
    }
}
