package gr23.fia.ues.sv.admon_poli;

/**
 * Created by User on 08/05/2016.
 *
 */
public class Administrador {
    private int idadministrador;
    private int telefonoadmin;
    private String emailadmin;

    public Administrador(int idadmin, int teladmin, String email) {
        this.idadministrador = idadmin;
        this.telefonoadmin = teladmin;
        this.emailadmin = email;
    }

    public Administrador() {
    }

    public int getIdadministrador() {
        return this.idadministrador;
    }

    public void setIdadministrador(int idadmin) {
        this.idadministrador = idadmin;
    }

    public int gettelefonoadmin(){
        return this.telefonoadmin;
    }

    public void setTelefonoadmin(int teladmin){
        this.telefonoadmin=teladmin;
    }

    public String getemailadmin(){
        return this.emailadmin;
    }

    public void setEmailadmin(String email){
        this.emailadmin=email;
    }


}

