package gr23.fia.ues.sv.admon_poli;

/**
 * Created by FAMILY on 08/05/2016.
 */
public class Solicitante {
    private String dui;
    private String nombreSol;
    private String apellidoSol;
    private int telefonoSol;
    private String mail;

    public Solicitante(String dui, String nombreSol, String apellidoSol, int telefonoSol, String mail) {
        this.dui = dui;
        this.nombreSol = nombreSol;
        this.apellidoSol = apellidoSol;
        this.telefonoSol = telefonoSol;
        this.mail = mail;
    }

    public Solicitante() {
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombreSol() {
        return nombreSol;
    }

    public void setNombreSol(String nombreSol) {
        this.nombreSol = nombreSol;
    }

    public String getApellidoSol() {
        return apellidoSol;
    }

    public void setApellidoSol(String apellidoSol) {
        this.apellidoSol = apellidoSol;
    }

    public int getTelefonoSol() {
        return telefonoSol;
    }

    public void setTelefonoSol(int telefonoSol) {
        this.telefonoSol = telefonoSol;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return nombreSol+ " " +apellidoSol;
    }
}
