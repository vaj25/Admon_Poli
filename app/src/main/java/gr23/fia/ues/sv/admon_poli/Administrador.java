package gr23.fia.ues.sv.admon_poli;

/**
 * Created by User on 08/05/2016.
 */
public class Administrador {

    private int idAdministrador ;
    private int telefono ;
    private String email ;

    public Administrador() {
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
