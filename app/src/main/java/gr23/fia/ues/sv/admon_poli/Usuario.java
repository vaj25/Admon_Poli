package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 13/05/2016.
 */
public class Usuario {

    String idUsuario ;
    String nomUsuario ;
    String clave ;

    public Usuario() {
    }

    public Usuario(String idUsuario, String nomUsuario, String clave) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.clave = clave;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
