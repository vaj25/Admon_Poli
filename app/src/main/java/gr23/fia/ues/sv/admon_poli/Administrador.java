package gr23.fia.ues.sv.admon_poli;

/**
 * Created by User on 08/05/2016.
 *
 */
public class Administrador {
    private int idadministrador;
    private int telefonoadmin;
    private String emailadmin;

    public Administrador(int idadmin, int teladmin, String emailadmin) {
        this.idadministrador = idadmin;
        this.telefonoadmin = teladmin;
        this.emailadmin = emailadmin;
    }

    public Administrador() {
    }

    public int getIdAdministrador() {
        return this.idadministrador;
    }

    public void setIdAdministrador(int idadmin) {
        this.idadministrador = idadmin;
    }

    public int getTelefonoadmin(){
        return this.telefonoadmin;
    }

    public void setTelefonoadmin(int teladmin){
        this.telefonoadmin=teladmin;
    }

    public String getEmailadmin(){
        return emailadmin;
    }

    public void setEmailadmin(String emailadmin){
        this.emailadmin=emailadmin;
    }

    @Override
    public String toString() {
        return emailadmin;
    }
}

